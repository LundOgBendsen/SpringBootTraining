package dk.lundogbendsen.boot.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import dk.lundogbendsen.boot.model.Currency;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyRepoTest {
	@Autowired
	private CurrencyRepository CurrencyRepo;

	@Before
	public void prepare() {
		List<Currency> all = CurrencyRepo.findAll();
		all.forEach((a) -> CurrencyRepo.delete(a));
		//CurrencyRepo.deleteAll() is also an option.
	}
	
//	@Test
//	public void testFindCurrencyFromNickname() {
//		Currency a = new Currency("12121212");
//		a.setBalance(100.0);
//		a.setNickname("savings");
//		CurrencyRepo.save(a);
//
//		a = new Currency("12121213");
//		a.setBalance(100.0);
//		a.setNickname("savings2");
//		CurrencyRepo.save(a);
//		
//		List<Currency> nicks = CurrencyRepo.findByNickname("savings");
//		assertEquals(1, nicks.size());
//		assertEquals("savings", nicks.get(0).getNickname());
//		assertEquals(100.0, nicks.get(0).getBalance(), 0.001);
//		assertEquals("12121212", nicks.get(0).getNumber());
//
//	}
//	
	@Test
	public void testFindCurrencyAfterCreation() {
//		Currency a = new Currency("12121212");
//		a.setBalance(100.0);
//		a.setNickname("savings");
//		CurrencyRepo.save(a);
//
//		List<Currency> Currencys = CurrencyRepo.findAll();
//
//		assertEquals(1, Currencys.size());
//		assertEquals("savings", Currencys.get(0).getNickname());
//		assertEquals(100.0, Currencys.get(0).getBalance(), 0.001);
//		assertEquals("12121212", Currencys.get(0).getNumber());
	}
}
