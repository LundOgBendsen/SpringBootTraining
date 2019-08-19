package dk.lundogbendsen.boot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import dk.lundogbendsen.boot.model.Currency;
import dk.lundogbendsen.boot.xml.currency.Exchangerates;

@Service
public class CurrencyRateFetcher {
	CurrencyService currencyService;
	
	public CurrencyRateFetcher(@Autowired CurrencyService currencyService) {
		this.currencyService = currencyService;
	}
	
	@Scheduled(fixedDelay = 10000)
	public void scheduleFixedDelayTask() throws Exception {
	    System.out.println(
	      "Fixed delay task - " + System.currentTimeMillis() / 1000);
	   List<Currency> currencies = getCurrencies();
	   for (Currency currency : currencies) {
		   currencyService.save(currency);
	   }
	   System.out.println("Saved!");
	}
	
	public List<Currency> getCurrencies() throws Exception {
		final String uri = "http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);			
	    XmlMapper xmlMapper = new XmlMapper();
	    xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    Exchangerates rates = xmlMapper.readValue(result, Exchangerates.class);
	    System.out.println(rates.getDailyrates().size());
	    List<Currency> collect = rates.getDailyrates().stream().map(CurrencyRateFetcher::convert).collect(Collectors.toList());
	    return collect;
	}
	
	private static Currency convert(dk.lundogbendsen.boot.xml.currency.Currency c) {
		return new Currency(c.getCode(), c.getRate(), c.getDescription());
	}
}


