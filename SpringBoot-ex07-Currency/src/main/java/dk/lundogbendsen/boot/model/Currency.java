package dk.lundogbendsen.boot.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Jakob
 *
 *         A class representing a standard account
 *
 */
@Entity
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@JsonProperty("code")
	String code;
	
	@JsonProperty("rate")
	double rate;
	
	@JsonProperty("desc")
	String description;
	
	LocalDateTime ts = LocalDateTime.now();

	public Currency() {
		super();
	}

	public Currency(String code, double rate, String description) {
		super();
		this.code = code;
		this.rate = rate;
		this.description = description;
		System.out.println("setting desc with " + this.description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getTs() {
		return ts;
	}

	public void setTs(LocalDateTime ts) {
		this.ts = ts;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", code=" + code + ", rate=" + rate + ", description=" + description + ", ts="
				+ ts + "]";
	}

}
