package co.com.zemoga.api;

import co.com.zemoga.entity.Portfolio;
import co.com.zemoga.resource.PortfolioResource;
import co.com.zemoga.service.PortfolioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.hateoas.Resources;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioRestControllerTest {

    @Mock
    private PortfolioService portfolioService;
    @InjectMocks
    private PortfolioRestController controller;

    private Portfolio portfolio = new Portfolio();

    private static final String USER_NAME = "user1234";

    @Before
    public void setUp() throws Exception {
        portfolio.setId(1);
        portfolio.setTitle("Portfolio Title");
        when(portfolioService.getByUserName(any())).thenReturn(portfolio);
        //when(portfolioService.findById(any())).thenReturn(new Portfolio());
        when(portfolioService.getPortfolios()).thenReturn(new ArrayList<>());
    }

    @Test
    public void testRetrievePortfolios() throws Exception {
        Resources<PortfolioResource> users = controller.getUsers();
        assertNotNull(users);
        verify(portfolioService, times(1)).getPortfolios();
    }

}
