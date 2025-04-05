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

import com.example.BankApp.Entity.PaymentEntity;
import com.example.BankApp.Service.PaymentService;
@RestController
public class PaymentController {
	@Autowired PaymentService pay;
	@GetMapping("/Payget")
	public List<PaymentEntity> get() {
		return pay.Payget();
	}
	
	@PostMapping("/Paypost")
	public PaymentEntity post(@RequestBody PaymentEntity obj) {
		return pay.Paypost(obj);
	}
	
	@DeleteMapping("/Paydelete/{id}")
	public String delete(@PathVariable int id) {
		return pay.Paydelete(id);
	}
	
	@PutMapping("/Payupdate/{id}")
	public PaymentEntity update(@PathVariable int id, @RequestBody PaymentEntity obj) {
		return pay.Payput(obj, id);
	}

}
