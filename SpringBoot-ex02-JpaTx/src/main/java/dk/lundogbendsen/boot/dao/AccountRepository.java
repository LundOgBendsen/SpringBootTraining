package dk.lundogbendsen.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dk.lundogbendsen.boot.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("SELECT a FROM Account a  WHERE a.nickname=(:nickname)")
	public List<Account> findByNickname(@Param("nickname") String nickname);
}
