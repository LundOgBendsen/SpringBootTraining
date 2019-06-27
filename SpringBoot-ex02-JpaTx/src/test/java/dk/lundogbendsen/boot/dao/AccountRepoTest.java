package dk.lundogbendsen.boot.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import dk.lundogbendsen.boot.model.Account;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepoTest {
	@Autowired
	private AccountRepository accountRepo;

	@Before
	public void prepare() {
		List<Account> all = accountRepo.findAll();
		all.forEach((a) -> accountRepo.delete(a));
		//accountRepo.deleteAll() is also an option.
	}
	
	@Test
	public void testFindAccountFromNickname() {
		Account a = new Account("12121212");
		a.setBalance(100.0);
		a.setNickname("savings");
		accountRepo.save(a);

		a = new Account("12121213");
		a.setBalance(100.0);
		a.setNickname("savings2");
		accountRepo.save(a);
		
		List<Account> nicks = accountRepo.findByNickname("savings");
		assertEquals(1, nicks.size());
		assertEquals("savings", nicks.get(0).getNickname());
		assertEquals(100.0, nicks.get(0).getBalance(), 0.001);
		assertEquals("12121212", nicks.get(0).getNumber());

	}
	
	@Test
	public void testFindAccountAfterCreation() {
		Account a = new Account("12121212");
		a.setBalance(100.0);
		a.setNickname("savings");
		accountRepo.save(a);

		List<Account> accounts = accountRepo.findAll();

		assertEquals(1, accounts.size());
		assertEquals("savings", accounts.get(0).getNickname());
		assertEquals(100.0, accounts.get(0).getBalance(), 0.001);
		assertEquals("12121212", accounts.get(0).getNumber());
	}
}
