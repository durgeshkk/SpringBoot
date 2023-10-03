package com.jpa.test.bootjpaexample;

import com.jpa.test.bootjpaexample.dao.UserRepository;
import com.jpa.test.bootjpaexample.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		User dk = new User();
		dk.setName("Durgesh Khandelwal");
		dk.setCity("Khamgaon");
		dk.setStatus("Competitive Programmer");
		User dk2 = new User();
		dk2.setName("Golu");
		dk2.setCity("Pune");
		dk2.setStatus("Java Programmer");

//		User dka = userRepository.save(dk);
//		System.out.println("Saved Data "+dka);
//		User dka2 = userRepository.save(dk2);
//		System.out.println("Saved Data "+dka2);
//		System.out.println("Done");

//		List<User> v = List.of(dk,dk2);
//		Iterable<User> res = userRepository.saveAll(v);
//		res.forEach(user -> {
//			System.out.println(user);
//		});

//		Optional<User> opt = userRepo.findById(11);

//		15. JPQL and Native Query
		List<User> allUser = userRepository.getAllUser();
		allUser.forEach(e -> {
			System.out.println(e);
		});

		List<User> allUser2 = userRepository.getUserByName("Golu");
		allUser2.forEach(e -> {
			System.out.println(e);
		});

		List<User> allUser3 = userRepository.getUserByNameAndCity("Durgesh Khandelwal","Khamgaon");
		allUser3.forEach(e -> {
			System.out.println(e);
		});

		userRepository.getUsers().forEach(e-> System.out.println(e));
	}

}
