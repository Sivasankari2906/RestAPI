package com.example.BankApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
		connect();
	}
	public static void connect() {
		String url="jdbc:mysql://localhost:3306/db";
		String user="root";
		String password="root";
		
		try (Connection conn=DriverManager.getConnection(url, user, password)){
			if(conn!=null) {
				System.out.println("Connection is Successfull!");
			}		
		}
		catch(SQLException e) {
			System.out.println("Connection is Unsuccessfull!" + e.getMessage());
		}
	}
}
