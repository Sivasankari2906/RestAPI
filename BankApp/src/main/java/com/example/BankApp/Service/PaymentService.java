package com.example.BankApp.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BankApp.Entity.PaymentEntity;
import com.example.BankApp.Repo.PaymentRepo;
@Service
public class PaymentService {
@Autowired PaymentRepo Pr;
	
	//get
	public List<PaymentEntity> Payget() {
		return Pr.findAll();
	}
	
	//post
	public PaymentEntity Paypost(PaymentEntity pay) {
		return Pr.save(pay);
	}
	
	//delete
	public String Paydelete(int id) {
		if(Pr.existsById(id)) {
			Pr.deleteById(id);
			return "Deleted successfully!";
		}
		else {
			return "Value not found"+id;
		}
	}
	
	//update
	public PaymentEntity Payput (PaymentEntity pay,int id) {
		if(Pr.existsById(id)) {
			PaymentEntity obj=Pr.findById(id).get();
			obj.setDate(pay.getDate());
			obj.setAmount(pay.getAmount());
			return Pr.save(obj);
		}
		return pay;
	}
	
}
