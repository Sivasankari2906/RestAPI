package com.example.BankApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BankApp.Entity.LoanEntity;
import com.example.BankApp.Repo.LoanRepo;
@Service
public class LoanService {
	@Autowired LoanRepo Lr;
	
	//get
	public List<LoanEntity> Loanget() {
		return Lr.findAll();
	}
	
	//post
	public LoanEntity Loanpost(LoanEntity ln) {
		return Lr.save(ln);
	}
	
	//delete
	public String Loandelete(int id) {
		if(Lr.existsById(id)) {
			Lr.deleteById(id);
			return "Deleted successfully!";
		}
		else {
			return "Value not found"+id;
		}
	}
	
	//update
	public LoanEntity Loanput (LoanEntity ln,int id) {
		if(Lr.existsById(id)) {
			LoanEntity obj=Lr.findById(id).get();
			obj.setLoantype(ln.getLoantype());
			obj.setAmount(ln.getAmount());
			obj.setInterest_rate(ln.getInterest_rate());
			return Lr.save(obj);
		}
		return ln;
	}
}