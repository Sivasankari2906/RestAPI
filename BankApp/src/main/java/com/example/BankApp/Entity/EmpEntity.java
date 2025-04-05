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
@Table(name="employees")
public class EmpEntity {

	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long emp_id;
	@Column(name="name")
	private String name;
	@Column(name="role")
	private String role;
	@Column(name="email")
	private String email;	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private List<PaymentEntity> payemp;
}