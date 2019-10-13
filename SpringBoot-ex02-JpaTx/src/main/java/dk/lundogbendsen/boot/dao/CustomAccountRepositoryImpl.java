package dk.lundogbendsen.boot.dao;

import dk.lundogbendsen.boot.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomAccountRepositoryImpl implements CustomAccountRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Account> findAccountsWithNonNegativeBalance() {
        String hql = "SELECT a FROM Account a WHERE a.balance >= 0";
        TypedQuery<Account> query = entityManager.createQuery(hql, Account.class);
        return query.getResultList();
    }
}
