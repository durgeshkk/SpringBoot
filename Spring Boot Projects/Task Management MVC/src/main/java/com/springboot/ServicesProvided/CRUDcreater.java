package com.springboot.ServicesProvided;

import com.springboot.Entities.TasksEntitiesss;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.TaskManagerrRepository;


@Service
public class CRUDcreater {
    
    @Autowired
    TaskManagerrRepository tamarepo;

    private static final Logger logger = LoggerFactory.getLogger(CRUDcreater.class);

    public void data_saved(TasksEntitiesss tasksEntitiesss){
        // Use Consumer : Accepts one parameter returns nothing

//        Optional.ofNullable(task.getId())
//        .orElseThrow(() -> new IllegalArgumentException("Enter ID re"));

        logger.info("Data Saved to Database");
        tamarepo.save(tasksEntitiesss);

        // if(task.getId() != null){
        // }else{
            // logger.info("Database Error");
            // Call DB Exception Error
        // }
    }
}
