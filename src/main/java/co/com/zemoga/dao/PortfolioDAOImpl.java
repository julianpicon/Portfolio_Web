package co.com.zemoga.dao;

import co.com.zemoga.entity.Portfolio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Portfolio> getPortfolios() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Portfolio> cq = cb.createQuery(Portfolio.class);
        Root<Portfolio> root = cq.from(Portfolio.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Portfolio getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Portfolio portfolio = session.get(Portfolio.class, id);
        return portfolio;
    }

    @Override
    public Portfolio getByUserName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Portfolio> criteria = criteriaBuilder.createQuery(Portfolio.class);
        Root<Portfolio> root = criteria.from(Portfolio.class);
        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(criteriaBuilder.equal(root.get("twitterUserName"), userName));
        criteria.select(root).where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(criteria);
        return (Portfolio) query.getSingleResult();
    }

    @Override
    public void update(Portfolio portfolio) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(portfolio);
    }
}
