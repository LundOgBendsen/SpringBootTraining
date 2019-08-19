package dk.lundogbendsen.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dk.lundogbendsen.boot.dao.CurrencyRepository;
import dk.lundogbendsen.boot.model.Currency;

@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository repo;

	

	@Transactional(propagation = Propagation.REQUIRED)
	public <S extends Currency> S save(S entity) {
		return repo.save(entity);
	}
		
	@Transactional(propagation = Propagation.SUPPORTS)	
	public List<Currency> findAll() {
		return repo.findAll();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public long count() {
		return repo.count();
	}

	@Transactional(propagation = Propagation.REQUIRED)	
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)	
	public void delete(Currency entity) {
		repo.delete(entity);
	}
	

	public Optional<Currency> findById(Integer id) {
		return repo.findById(id);
	}

	
}
