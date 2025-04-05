package com.example.BankApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankApp.Entity.EmpEntity;
import com.example.BankApp.Service.EmpService;
@RestController
public class EmpController {
	@Autowired EmpService emp;
	@GetMapping("/Empget")
	public List<EmpEntity> get() {
		return emp.Empget();
	}
	
	@PostMapping("/Emppost")
	public EmpEntity post(@RequestBody EmpEntity obj) {
		return emp.Emppost(obj);
	}
	
	@DeleteMapping("/Empdelete/{id}")
	public String delete(@PathVariable int id) {
		return emp.Empdelete(id);
	}
	
	@PutMapping("/Empupdate/{id}")
	public EmpEntity update(@PathVariable int id, @RequestBody EmpEntity obj) {
		return emp.Empput(obj, id);
	}
	@GetMapping("/empstarts")
	public List<EmpEntity> start_1(@RequestParam String name) {
		return emp.starts(name);
	}
	@GetMapping("/empends")
	public List<EmpEntity> end_1(@RequestParam String name) {
		return emp.ends(name);
	}
	@GetMapping("/empcontaindata")
	public List<EmpEntity> contains(@RequestParam String name){
		return emp.namecontain(name);
	}
	@GetMapping("/empcontaining")
	public List<EmpEntity> containing(@RequestParam String name)
	{
		return emp.containing(name);
	}	
	@GetMapping("/empiscontaining")
	public List<EmpEntity> iscon(@RequestParam String name)
	{
		return emp.iscon(name);
	}
	@GetMapping("/empnotcontain")
	public List<EmpEntity> notcontain(@RequestParam String name)
	{
		return emp.notcontain(name);
	}
}