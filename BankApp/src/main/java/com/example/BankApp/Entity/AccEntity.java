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
@Table(name="account")
public class AccEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_no")
    private long acc_no;
    @Column(name = "accholder_name")
    private String accholder_name;
    @Column(name = "acc_type")
    private String acc_type;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="acc_no")
	private List<LoanEntity> loan;
}
