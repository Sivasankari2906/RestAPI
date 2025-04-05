package com.example.BankApp.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankApp.Entity.LoanEntity;

@Repository
public interface LoanRepo extends JpaRepository<LoanEntity,Integer>{


}