package com.example.BankApp.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.BankApp.Entity.LoanEntity;
import com.example.BankApp.Service.LoanService;

@RestController
public class LoanController {
	@Autowired LoanService ln;
	@GetMapping("/Loanget")
	public List<LoanEntity> get() {
		return ln.Loanget();
	}
	
	@PostMapping("/Loanpost")
	public LoanEntity post(@RequestBody LoanEntity obj) {
		return ln.Loanpost(obj);
	}
	
	@DeleteMapping("/Loandelete/{id}")
	public String delete(@PathVariable int id) {
		return ln.Loandelete(id);
	}
	
	@PutMapping("/Loanupdate/{id}")
	public LoanEntity update(@PathVariable int id, @RequestBody LoanEntity obj) {
		return ln.Loanput(obj, id);
	}
}
