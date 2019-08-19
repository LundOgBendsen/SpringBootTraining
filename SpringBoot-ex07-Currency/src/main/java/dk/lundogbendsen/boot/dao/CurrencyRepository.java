package dk.lundogbendsen.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dk.lundogbendsen.boot.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
	
}
