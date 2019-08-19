package dk.lundogbendsen.boot.xml.currency;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "exchangerates")
@JsonIgnoreProperties(value = { "id" })
public class Exchangerates {
	
	@JacksonXmlProperty(localName = "dailyrates")
	@JacksonXmlElementWrapper(useWrapping = true)
	List<Currency> dailyrates = new ArrayList<Currency>();

	@JacksonXmlProperty(isAttribute = true)
	String type; 
	@JacksonXmlProperty(isAttribute = true)
	String author;
	@JacksonXmlProperty(isAttribute = true)
	String refcur; 
	@JacksonXmlProperty(isAttribute = true)
	double refamt;
	
	public List<Currency> getDailyrates() {
		return dailyrates;
	}

	public void setDailyrates(List<Currency> dailyrates) {
		this.dailyrates = dailyrates;
	}

	@Override
	public String toString() {
		return "Exchangerates [dailyrates=" + dailyrates + "]";
	}
	
	
}
