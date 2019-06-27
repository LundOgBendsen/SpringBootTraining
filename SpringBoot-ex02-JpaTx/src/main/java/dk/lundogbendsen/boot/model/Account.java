package dk.lundogbendsen.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Jakob
 *
 *         A class representing a standard account
 *
 */
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String number;
	private String nickname;
	private double balance = 0.0;

	/**
	 * 
	 * @param id     a synthetic id that must be unique
	 * @param number the account number (10 digits)
	 * @throws AccountIdException if Id already exists
	 */
	public Account(String number) {
		this.number = number;
	}
	
	public Account() {
	}

	public Integer getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", nickname=" + nickname + ", balance=" + balance + "]";
	}
}
