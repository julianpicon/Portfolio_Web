package co.com.zemoga.controller;

import co.com.zemoga.entity.Portfolio;
import co.com.zemoga.exception.UserNotFoundException;
import co.com.zemoga.service.PortfolioService;
import co.com.zemoga.service.TwitterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioControllerTest {

    @Mock
    private PortfolioService portfolioService;
    @Mock
    private TwitterService twitterService;
    @InjectMocks
    private PortfolioController controller;

    private Portfolio portfolio = new Portfolio();
    private List<Tweet> tweets = new ArrayList<Tweet>();

    private static final String USER_NAME = "user1234";

    @Before
    public void setUp() throws Exception {
        portfolio.setId(1);
        portfolio.setTitle("Portfolio Title");
        when(portfolioService.getByUserName(any())).thenReturn(portfolio);
        when(twitterService.getTweets(any())).thenReturn(new ArrayList<Tweet>());
    }

    @Test
    public void testGetPortfolio() throws Exception {
        ModelAndView response = controller.getPortfolio(USER_NAME);
        verify(portfolioService, times(1)).getByUserName(any());
        verify(twitterService, times(1)).getTweets(any());
        assertNotNull(response);
        assertNotNull(portfolioService.getByUserName(USER_NAME));
        assertNotNull(twitterService.getTweets(USER_NAME));
    }

    @Test(expected = UserNotFoundException.class)
    public final void testUserNotFoundException() throws Exception {
        when(portfolioService.getByUserName(any())).thenReturn(null);
        controller.getPortfolio(USER_NAME);
        verify(portfolioService, times(1)).getByUserName(any());
        verify(twitterService, never()).getTweets(any());
        assertNotNull(portfolioService.getByUserName(USER_NAME));
    }

}
