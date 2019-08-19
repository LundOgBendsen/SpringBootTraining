package dk.lundogbendsen.boot.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.lundogbendsen.boot.model.Currency;
import dk.lundogbendsen.boot.service.CurrencyService;

@RestController
public class CurrencyResource {

	@Autowired
	private CurrencyService currencyService;
	
	
	@GetMapping("/currencies")
	public List<Currency> retrieveAllCurrencies() {
		return currencyService.findAll();
	}
}