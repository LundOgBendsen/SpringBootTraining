package dk.lundogbendsen.mavendemo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class QuotesTest {

	@Test
	public void testGetTodaysQuote() {
		Quotes myClass = new Quotes();
		String quote = myClass.getTodaysQuote();
		assertTrue(quote.length() > 10 );		
	}
	
	@Test
	public void testGetQuotesAsPDF() {
		Quotes myClass = new Quotes();
		try {
			myClass.saveQuoteAsPdf();
		} catch (Exception e) {		
			e.printStackTrace();
			fail();
		}
			
	}
	

}
