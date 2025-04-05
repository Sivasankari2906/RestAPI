package com.example.BankApp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankApp.Entity.EmpEntity;
@Repository
public interface EmpRepo extends JpaRepository<EmpEntity,Integer>{

	List<EmpEntity> findByNameStartingWith(String name);
	List<EmpEntity> findByNameEndingWith(String name);
	List<EmpEntity> findByNameContains(String name);
	List<EmpEntity> findByNameContaining(String name);
	List<EmpEntity> findByNameIsContaining(String name);
	List<EmpEntity> findByNameNotContains(String name);

}