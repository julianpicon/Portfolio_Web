package co.com.zemoga.controller;

import co.com.zemoga.dto.UserPortfolioDTO;
import co.com.zemoga.entity.Portfolio;
import co.com.zemoga.service.PortfolioService;
import co.com.zemoga.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private TwitterService twitterService;

    @RequestMapping(value = "/portfolio/{userName}", method = RequestMethod.GET)
    public ModelAndView getPortfolio(@PathVariable String userName) {
        Portfolio portfolio = portfolioService.getByUserName(userName);
        List<Tweet> tweets = twitterService.getTweets(userName);
        return new ModelAndView("portfolio", "userPortfolio", new UserPortfolioDTO(portfolio, tweets));
    }
}
