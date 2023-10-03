package com.api.book.bootrestbookdb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * All the files we create are always stored in 2 folders differently one the src 
 * and other one the target!!
 * Server serves the Target files and not the src ones!!
 * All the files in target gets overwrites when we build/run
 */

@SpringBootApplication
public class BootrestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootrestbookApplication.class, args);
	}

}
