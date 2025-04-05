package com.example.BankApp.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.BankApp.Entity.CustEntity;
import com.example.BankApp.Repo.CustRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class CustService {
	@Autowired CustRepo Ur;
	@Autowired private JavaMailSender sender;
	
	//get
	public List<CustEntity> Custget() {
		return Ur.findAll();
	}
	
	//post
	public CustEntity Custpost(CustEntity cust) {
		return Ur.save(cust);
	}
	
	//delete
	public String Custdelete(int id) {
		if(Ur.existsById(id)) {
			Ur.deleteById(id);
			return "Deleted successfully!";
		}
		else {
			return "Value not found"+id;
		}
	}
	
	//update
	public CustEntity Custput (CustEntity cust,int id) {
		if(Ur.existsById(id)) {
			CustEntity obj=Ur.findById(id).get();
			obj.setName(cust.getName());
			obj.setPassword(cust.getPassword());
			obj.setEmail(cust.getEmail());
			obj.setCust_id(cust.getCust_id());
			return Ur.save(obj);
		}
		return cust;
	}
	public Page<CustEntity> paging(int page,int size) {
	   	 PageRequest pr = PageRequest.of(page, size);
	   	 return Ur.findAll(pr);
	}
	public List<CustEntity> starts(String name){
		return Ur.findByNameStartingWith(name);
	}

	public List<CustEntity> ends(String name) {
		return Ur.findByNameEndingWith(name);
	}
	public List<CustEntity> namecontain(String name){
		return Ur.findByNameContains(name);
	}
	public List<CustEntity> containing(String name){
		return Ur.findByNameContaining(name);
	}	
	public List<CustEntity> iscon(String name){
		return Ur.findByNameIsContaining(name);
	}
	public List<CustEntity> notcontain(String name){
		return Ur.findByNameNotContains(name);
	}
	public List<CustEntity> and(String name,String pass)
	{
		return Ur.findByNameAndPassword(name, pass);
	}
	public List<CustEntity> or(String name,String pass)
	{
		return Ur.findByNameOrPassword(name, pass);
	}
	public List<CustEntity> in(List<String> name)
	{
		return Ur.findByNameIn(name);
	}
	
	
	
	public String mail(String receiver,String subject,String body) {
    	try {
    		MimeMessage message=sender.createMimeMessage();
    		MimeMessageHelper helper=new MimeMessageHelper(message);
    		helper.setTo(receiver);
    		helper.setSubject(subject);
    		helper.setText(body);
    		sender.send(message);
    		CustEntity email=new CustEntity();
    		email.setReceiver(receiver);
    		email.setSubject(subject);
    		email.setBody(body);
    		Ur.save(email);
    		return "Email send successfully";
    	}
    	catch (MessagingException e) {
    		return "Email not Send"+e.getMessage();
    		}
    	}
}