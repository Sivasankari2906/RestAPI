package com.example.BankApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankApp.Entity.AccEntity;
import com.example.BankApp.Repo.AccRepo;

@Service
public class AccService {
	@Autowired AccRepo Ac;
	
	//get
	public List<AccEntity> Accget() {
		return Ac.findAll();
	}
	
	//post
	public AccEntity Accpost(AccEntity acc) {
		return Ac.save(acc);
	}
	
	//delete
	public String Accdelete(int id) {
		if(Ac.existsById(id)) {
			Ac.deleteById(id);
			return "Deleted successfully!";
		}
		else {
			return "Value not found"+id;
		}
	}
	
	//update
	public AccEntity Accput (AccEntity acc,int id) {
		if(Ac.existsById(id)) {
			AccEntity obj=Ac.findById(id).get();
			obj.setAccholder_name(acc.getAccholder_name());
			obj.setAcc_type(acc.getAcc_type());
			return Ac.save(obj);
		}
		return acc;
	}

}