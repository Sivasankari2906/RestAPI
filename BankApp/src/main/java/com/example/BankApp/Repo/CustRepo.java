package com.example.BankApp.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankApp.Entity.CustEntity;
@Repository
public interface CustRepo extends JpaRepository<CustEntity,Integer>{

	List<CustEntity> findByNameNotContains(String name);
	List<CustEntity> findByNameIsContaining(String name);
	List<CustEntity> findByNameContaining(String name);
	List<CustEntity> findByNameContains(String name);
	List<CustEntity> findByNameEndingWith(String name);
	List<CustEntity> findByNameStartingWith(String name);
	List<CustEntity> findByNameAndPassword(String name, String pass);
	List<CustEntity> findByNameOrPassword(String name, String pass);
	List<CustEntity> findByNameIn(List<String> name);

}