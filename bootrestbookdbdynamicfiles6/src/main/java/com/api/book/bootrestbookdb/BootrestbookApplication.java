package com.api.book.bootrestbookdb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * All the files we create are always stored in 2 folders differently one the src 
 * and other one the target!!
 * Server serves the Target files and not the src ones!!
 * All the files in target gets overwrites when we build/run
 * Also second problem is we have kept the loc as fixed bt when we will 
 * change PCs we will again need to update the dir loc
 * 
 * Target is dynamic Folder and is created when we deploy our prjct
 */

@SpringBootApplication
public class BootrestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootrestbookApplication.class, args);
	}

}
