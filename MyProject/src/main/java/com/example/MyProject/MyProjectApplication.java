package com.example.MyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(MyProjectApplication.class, args);
	}
}