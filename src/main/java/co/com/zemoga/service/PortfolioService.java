package co.com.zemoga.service;

import co.com.zemoga.entity.Portfolio;

import java.util.List;

public interface PortfolioService {

    List<Portfolio> getPortfolios();

    Portfolio findById(int id);

    Portfolio getByUserName(String userName);

    void update(Portfolio portfolio);
}
