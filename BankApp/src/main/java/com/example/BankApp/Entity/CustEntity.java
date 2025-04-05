package com.example.BankApp.Entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="customer")
public class CustEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long cust_id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private List<AccEntity> acc;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private List<LoanEntity> loan;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private List<PaymentEntity> pay;
    
    @Column(name="receiver")
	private String receiver;
	@Column(name="subject")
	private String subject;
	@Column(name="body")
	private String body;
    
}
