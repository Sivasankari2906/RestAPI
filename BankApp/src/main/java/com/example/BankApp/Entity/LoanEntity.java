package com.example.BankApp.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="loans")
public class LoanEntity {
	@Id
	@Column(name="loan_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long loan_id;
	@Column(name="loantype")
	private String loantype;
	@Column(name="amount")
	private int amount;
	@Column(name="interest_rate")
	private int interest_rate;	
	
}