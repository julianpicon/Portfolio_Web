package co.com.zemoga.dao;

import co.com.zemoga.entity.Portfolio;

import java.util.List;

public interface PortfolioDAO {

    List<Portfolio> getPortfolios();

    Portfolio getById(int id);

    Portfolio getByUserName(String userName);

    void update(Portfolio portfolio);
}
