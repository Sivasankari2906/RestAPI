package com.example.BankApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BankApp.Entity.EmpEntity;
import com.example.BankApp.Repo.EmpRepo;
@Service
public class EmpService {
	
	@Autowired EmpRepo Er;
	
	//get
	public List<EmpEntity> Empget() {
		return Er.findAll();
	}
	
	//post
	public EmpEntity Emppost(EmpEntity emp) {
		return Er.save(emp);
	}
	
	//delete
	public String Empdelete(int id) {
		if(Er.existsById(id)) {
			Er.deleteById(id);
			return "Deleted successfully!";
		}
		else {
			return "Value not found"+id;
		}
	}
	
	//update
	public EmpEntity Empput (EmpEntity emp,int id) {
		if(Er.existsById(id)) {
			EmpEntity obj=Er.findById(id).get();
			obj.setName(emp.getName());
			obj.setRole(emp.getRole());
			obj.setEmail(emp.getEmail());
			obj.setEmp_id(emp.getEmp_id());
			return Er.save(obj);
		}
		return emp;
	}
	public List<EmpEntity> starts(String name){
		return Er.findByNameStartingWith(name);
	}

	public List<EmpEntity> ends(String name) {
		return Er.findByNameEndingWith(name);
	}
	public List<EmpEntity> namecontain(String name){
		return Er.findByNameContains(name);
	}
	public List<EmpEntity> containing(String name){
		return Er.findByNameContaining(name);
	}	
	public List<EmpEntity> iscon(String name){
		return Er.findByNameIsContaining(name);
	}
	public List<EmpEntity> notcontain(String name){
		return Er.findByNameNotContains(name);
	}
}
