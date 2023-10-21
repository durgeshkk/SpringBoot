package com.springboot;

import com.springboot.Entities.TasksEntitiesss;
import com.springboot.dao.TaskManagerrRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = TaskManagerrRepository.class)
@EntityScan(basePackages = "com.springboot.*")
@ComponentScan(basePackages = {"com.springboot.*"})
public class MainTaskManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(MainTaskManagerApp.class, args);
    }
}
