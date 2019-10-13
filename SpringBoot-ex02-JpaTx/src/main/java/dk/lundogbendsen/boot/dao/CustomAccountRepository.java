package dk.lundogbendsen.boot.dao;

import dk.lundogbendsen.boot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomAccountRepository {
	public List<Account> findAccountsWithNonNegativeBalance();
}
