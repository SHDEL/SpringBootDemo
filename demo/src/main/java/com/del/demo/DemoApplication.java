package com.del.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.del.demo.entity.User;
import com.del.demo.repository.UserDAO;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(UserDAO dao){
		return runner ->{
			System.out.println("startup successfully");
		};

	}
	public void insert(UserDAO dao){
		User u = new User("deler", "del2547.pv@gmail.com", "del1311");
		dao.save(u);
		System.out.println("Insert Success");
	}
	public void delete(UserDAO dao){
		dao.delete(7);
		System.out.println("Delete Complete");
	}

}
