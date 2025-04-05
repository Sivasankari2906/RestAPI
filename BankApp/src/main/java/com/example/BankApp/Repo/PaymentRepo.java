package com.example.BankApp.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankApp.Entity.PaymentEntity;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity,Integer>{

}