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
@Table(name="payments")
public class PaymentEntity {
	@Id
	@Column(name="payment_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long payment_no;
	@Column(name="date")
	private String date;
	@Column(name="amount")
	private int amount;
	
}
