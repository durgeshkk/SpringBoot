package com.springboot.ServicesProvided;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.springboot.Entities.TasksEntitiesss;
import com.springboot.dao.TaskManagerrRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRUDviewer {

    @Autowired
    TaskManagerrRepository repo;

    private static final Logger logger = LoggerFactory.getLogger(CRUDviewer.class);

    public List<TasksEntitiesss> getAllEntities() {
        return (List<TasksEntitiesss>) repo.findAll();
    }

    public Optional<TasksEntitiesss> getById(Integer id){
        
//        Optional.ofNullable(id)
//        .orElseThrow(() -> new IllegalStateException("ID not in DB!"));
        
        logger.info("Data Found in DB!");
        return repo.findById(id);
    }

    List<TasksEntitiesss> allTasksEntities;
    @PostConstruct
    private void initAllTasksEntities(){
        allTasksEntities = getAllEntities();
    }

    public List<TasksEntitiesss> getBeforeDueDate(LocalDate targetdate){
        // LocalDate targetdate = task.getDueDate();
        
        logger.info("Returning List of Tasks before Due Date!");
        List<TasksEntitiesss> filteredTasksEntities = allTasksEntities.stream()
            .filter(t -> ((t.getDueDate().isBefore(targetdate)) ? true : false))
            .collect(Collectors.toList()); 
        // For returning 2 different lists for before targetDate & after make use of 
        // Map<Boolean,List<Task>> in a single iteration.
        return filteredTasksEntities;
    }

    public List<TasksEntitiesss> getTitlePatternMatching(String s){
        List<TasksEntitiesss> filteredList = allTasksEntities.stream().filter(
            t-> (t.getTitle().contains(s) ? true :false)
        ).collect(Collectors.toList());
        return filteredList;
    }
}
