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

import com.example.BankApp.Entity.AccEntity;
import com.example.BankApp.Service.AccService;
@RestController
public class AccController {
	@Autowired AccService acc;
	@GetMapping("/Accget")
	public List<AccEntity> get() {
		return acc.Accget();
	}
	
	@PostMapping("/Accpost")
	public AccEntity post(@RequestBody AccEntity obj) {
		return acc.Accpost(obj);
	}
	
	@DeleteMapping("/Accdelete/{id}")
	public String delete(@PathVariable int id) {
		return acc.Accdelete(id);
	}
	
	@PutMapping("/Accput/{id}")
	public AccEntity update(@PathVariable int id, @RequestBody AccEntity obj) {
		return acc.Accput(obj, id);
	}
}
