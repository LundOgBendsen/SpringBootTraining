package dk.lundogbendsen.boot.integration;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dk.lundogbendsen.boot.model.Account;
import dk.lundogbendsen.boot.service.AccountService;

@RestController
public class AccountResource {

	@Autowired
	private AccountService accountService;

	@GetMapping("/init")
	public String init() {
		accountService.init();
		return "created 10 accounts";
	}
	
	@GetMapping("/accounts")
	public List<Account> retrieveAllAccounts() {
		return accountService.findAll();
	}

	@GetMapping("/accounts/{id}")
	public Account retrieveAccount(@PathVariable int id) {
		Optional<Account> account = accountService.findById(id);

		return account.get();
	}

	@GetMapping("/accounts/transfer")
	public void transfer(@RequestParam("from") int from, @RequestParam("to") int to, @RequestParam("amount") double amount ) {
		Optional<Account> f = accountService.findById(from);
		Optional<Account> t = accountService.findById(to);
		if (f.isPresent() && t.isPresent()) {
			accountService.transferTo(f.get(), t.get(), amount);
			System.out.println("Transferred " + amount + " from " + from + " to " + to);
		}
	}
	
	@GetMapping("/accounts/transferWithError")
	public void transferWith(@RequestParam("from") int from, @RequestParam("to") int to, @RequestParam("amount") double amount, @RequestParam("fail") boolean fail ) {
		Optional<Account> f = accountService.findById(from);
		Optional<Account> t = accountService.findById(to);
		if (f.isPresent() && t.isPresent()) {
			if (fail) {
				System.out.println("Fail on purpose");
				
				accountService.transferToWithError(f.get(), t.get(), amount);
			} else {
				accountService.transferTo(f.get(), t.get(), amount);				
			}
			System.out.println("Transferred " + amount + " from " + from + " to " + to);
		}
	}

	
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteById(id);
	}

	@PostMapping("/accounts")
	public ResponseEntity<Object> createAccount(@RequestBody Account account) {
		Account savedAccount = accountService.save(account);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAccount.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/accounts/{id}")
	public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathVariable int id) {

		Optional<Account> accountOptional = accountService.findById(id);

		if (!accountOptional.isPresent())
			return ResponseEntity.notFound().build();

		accountService.save(account);

		return ResponseEntity.noContent().build();
	}
}