package co.com.zemoga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.inject.Inject;

@Configuration
@PropertySource("classpath:social.properties")
public class TwitterConfig {

    @Inject
    private Environment environment;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new TwitterConnectionFactory(
                environment.getProperty("twitter.consumerKey"),
                environment.getProperty("twitter.consumerSecret")));
        return registry;
    }

    @Bean
    public Twitter twitterConnection() {
        return new TwitterTemplate(environment.getProperty("twitter.consumerKey"),
                environment.getProperty("twitter.consumerSecret"),
                environment.getProperty("twitter.accessToken"),
                environment.getProperty("twitter.accessTokenSecret"));
    }

}