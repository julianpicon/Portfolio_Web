package co.com.zemoga.api;

import co.com.zemoga.exception.UserNotFoundException;
import co.com.zemoga.resource.PortfolioResource;
import co.com.zemoga.entity.Portfolio;
import co.com.zemoga.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/api/v1")
public class PortfolioRestController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping(value = "/users", produces = "application/json") ///zemoga_portfolio_api/user_info
    public Resources<PortfolioResource> getUsers() {
        List<Portfolio> portfolios = portfolioService.getPortfolios();
        List<PortfolioResource> portfoliosResources = new ArrayList();
        for (Portfolio portfolio : portfolios) {
            PortfolioResource portfolioRs = new PortfolioResource(portfolio);
            Link linkGetInfo = linkTo(methodOn(PortfolioRestController.class).getUserInfoById(portfolio.getId())).withSelfRel();
            Link linkUpdateInfo = linkTo(methodOn(PortfolioRestController.class).updateUser(new Portfolio(), portfolio.getId())).withSelfRel();
            portfolioRs.add(linkGetInfo);
            portfolioRs.add(linkUpdateInfo);
            portfoliosResources.add(portfolioRs);
        }
        Link link = linkTo(methodOn(PortfolioRestController.class).getUsers()).withSelfRel();
        Resources<PortfolioResource> resources = new Resources<>(portfoliosResources, link);
        return resources;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<PortfolioResource> getUserInfoById(@PathVariable int id) {
        Portfolio portfolio = Optional.ofNullable(this.portfolioService.findById(id))
                        .orElseThrow(() -> new UserNotFoundException(id));
        PortfolioResource portfolioResource = new PortfolioResource(portfolio);
        Link linkUpdateInfo = linkTo(methodOn(PortfolioRestController.class).updateUser(new Portfolio(), portfolioResource.getIdPortfolio())).withSelfRel();
        portfolioResource.add(linkUpdateInfo);
        return ResponseEntity.ok(portfolioResource);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json") ///zemoga_portfolio_api/modify_user_info
    public ResponseEntity<Object> updateUser(@RequestBody Portfolio portfolioFromRequest, @PathVariable int id) {
        Optional<Portfolio> studentOptional = Optional.ofNullable(portfolioService.findById(id));
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        Portfolio portDb = studentOptional.get();
        Optional.ofNullable(portfolioFromRequest.getTwitterUserName()).ifPresent(u -> portDb.setTwitterUserName(u));
        Optional.ofNullable(portfolioFromRequest.getImageUrl()).ifPresent(u -> portDb.setImageUrl(u));
        Optional.ofNullable(portfolioFromRequest.getDescription()).ifPresent(u -> portDb.setDescription(u));
        this.portfolioService.update(portDb);
        return ResponseEntity.ok(portDb);
    }

}
