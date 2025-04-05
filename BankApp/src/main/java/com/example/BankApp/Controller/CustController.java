package com.example.BankApp.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankApp.Entity.CustEntity;
import com.example.BankApp.Service.CustService;
@RestController
public class CustController {
	@Autowired CustService cust;
	@GetMapping("/Custget")
	public List<CustEntity> get() {
		return cust.Custget();
	}
	
	@PostMapping("/Custpost")
	public CustEntity post(@RequestBody CustEntity obj) {
		return cust.Custpost(obj);
	}
	
	@DeleteMapping("/Custdelete/{id}")
	public String delete(@PathVariable int id) {
		return cust.Custdelete(id);
	}
	
	@PutMapping("/Custupdate/{id}")
	public CustEntity update(@PathVariable int id, @RequestBody CustEntity obj) {
		return cust.Custput(obj, id);
	}
	//paging
    @GetMapping("/studentpage")
  	public Page<CustEntity> getPage (@RequestParam int page,@RequestParam int size) {
  		return cust.paging(page, size);
  	}
    @GetMapping("/starts")
	public List<CustEntity> start_1(@RequestParam String name) {
		return cust.starts(name);
	}
	@GetMapping("/ends")
	public List<CustEntity> end_1(@RequestParam String name) {
		return cust.ends(name);
	}
	@GetMapping("/containdata")
	public List<CustEntity> contains(@RequestParam String name){
		return cust.namecontain(name);
	}
	@GetMapping("/containing")
	public List<CustEntity> containing(@RequestParam String name)
	{
		return cust.containing(name);
	}	
	@GetMapping("/iscontaining")
	public List<CustEntity> iscon(@RequestParam String name)
	{
		return cust.iscon(name);
	}
	@GetMapping("/notcontain")
	public List<CustEntity> notcontain(@RequestParam String name)
	{
		return cust.notcontain(name);
	}
	@GetMapping("/and")
    public List<CustEntity> and(@RequestParam String name,@RequestParam String pass)
    {
  	  return  cust.and(name, pass);
    } @GetMapping("/or")
    public List<CustEntity> or(@RequestParam String name,@RequestParam String pass)
    {
  	  return  cust.or(name,pass);
    } @GetMapping("/in")
    public List<CustEntity> in(@RequestParam List<String> name)
    {
  	  return  cust.in(name);
    }
    
    @PostMapping("/mail")
  	public String email(@RequestParam String receiver,@RequestParam String subject,@RequestParam String body) {
  		return cust.mail(receiver,subject,body);
  	}
}