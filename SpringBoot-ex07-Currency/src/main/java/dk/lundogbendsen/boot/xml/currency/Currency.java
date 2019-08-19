package dk.lundogbendsen.boot.xml.currency;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class Currency {
		@JacksonXmlProperty(localName = "code", isAttribute = true)		
		String code;
		
		@JacksonXmlProperty(localName = "rate", isAttribute = true)		
		double rate;
		
		@JacksonXmlProperty(localName = "desc", isAttribute = true)
		String description;
		
		public Currency() {
		}
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "Currency [code=" + code + ", rate=" + rate + ", description=" + description + "]";
		}
}
