package co.com.zemoga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TwitterServiceImpl implements TwitterService {

    private final static int TWEETS_NUMBER_MAX = 5;

    @Autowired
    private Twitter twitter;

    @Override
    public List<Tweet> getTweets(String userName) {
        return twitter.timelineOperations().getUserTimeline(userName, TWEETS_NUMBER_MAX);
    }
}
