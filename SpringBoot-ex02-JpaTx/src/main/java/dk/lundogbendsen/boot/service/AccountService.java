package dk.lundogbendsen.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dk.lundogbendsen.boot.dao.AccountRepository;
import dk.lundogbendsen.boot.model.Account;

@Service
public class AccountService {

	@Autowired
	AccountRepository repo;

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Account> findByNickname(String nickname) {
		return repo.findByNickname(nickname);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public <S extends Account> S save(S entity) {
		return repo.save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void init() {
		for (int i = 0; i < 10; i++) {
			Account account = new Account((int)(Math.random()*1e9) + "");
			account.setNickname("savings");
			account.setBalance(Math.random()*1000);
			repo.save(account);
		}
		System.out.println("generated 10 accounts");
	}

		
	@Transactional(propagation = Propagation.SUPPORTS)	
	public List<Account> findAll() {
		return repo.findAll();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Account> findAllNonNegative() {
		return repo.findAccountsWithNonNegativeBalance();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public long count() {
		return repo.count();
	}

	@Transactional(propagation = Propagation.REQUIRED)	
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)	
	public void delete(Account entity) {
		repo.delete(entity);
	}
	

	public Optional<Account> findById(Integer id) {
		return repo.findById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)	
	public void transferTo(Account from, Account to, double amount) {
		Optional<Account> f = repo.findById(from.getId());
		Optional<Account> t = repo.findById(to.getId());
		if (f.isPresent() && t.isPresent()) {
			from.setBalance(from.getBalance()-amount);
			to.setBalance(to.getBalance()+amount);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void transferToWithError(Account from, Account to, double amount) {
		Optional<Account> f = repo.findById(from.getId());
		Optional<Account> t = repo.findById(to.getId());
		if (f.isPresent() && t.isPresent()) {
			from.setBalance(from.getBalance()-amount);
			to.setBalance(to.getBalance()+amount);
		}
		throw new TransferException("Something went wrong");
	}

}
