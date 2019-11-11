package co.com.zemoga.service;

import co.com.zemoga.dao.PortfolioDAO;
import co.com.zemoga.entity.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PortfolioServiceImpl implements  PortfolioService {

    @Autowired
    private PortfolioDAO portfolioDAO;

    @Override
    public List<Portfolio> getPortfolios() {
        return this.portfolioDAO.getPortfolios();
    }

    @Override
    public Portfolio findById(int id) {
        return this.portfolioDAO.getById(id);
    }

    @Override
    public Portfolio getByUserName(String userName) {
        return this.portfolioDAO.getByUserName(userName);
    }

    @Override
    public void update(Portfolio portfolio) {
        this.portfolioDAO.update(portfolio);
    }

}
