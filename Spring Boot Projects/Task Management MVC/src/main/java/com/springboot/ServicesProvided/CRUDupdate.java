package com.springboot.ServicesProvided;

import com.springboot.Entities.TasksEntitiesss;
import com.springboot.dao.TaskManagerrRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRUDupdate {
    
    @Autowired
    TaskManagerrRepository tamarepo;

    private static final Logger logger = LoggerFactory.getLogger(CRUDupdate.class);


    public TasksEntitiesss updateById(TasksEntitiesss tasksEntitiesss){
        
//        Optional.ofNullable(task.getId())
//            .orElseThrow(() -> new IllegalStateException("Update Unsuccessful!! has No ID"));

        logger.info("ID is not NULL");
        
        tamarepo.findById(tasksEntitiesss.getId())
            .map(t -> {
//                t.setCntr(tasksEntitiesss.getCntr());
                t.setTitle(tasksEntitiesss.getTitle());
                t.setTitle_description(tasksEntitiesss.getTitle_description());
                t.setDueDate(tasksEntitiesss.getDueDate());
                logger.info("ID Found, Data Saved to DB!");
                return tamarepo.save(t);
            });

        logger.info("ID Not Found, New Data Saved to DB!");
        return tamarepo.save(tasksEntitiesss);
    }
}
        /*
        Integer id = task.getId();
        Optional<Task> optional = tManagementRepository.findById(id);

        if(optional.isPresent()){
            Task t = optional.get();
            t.setCntr(task.getCntr());
            t.setTitle(task.getTitle());
            t.setTitle_description(task.getTitle());
            t.setDueDate(task.getDueDate());
            return tManagementRepository.save(t);
        }else{

        }

        optional.ifPresentOrElse(Consumer<Task>, Runnable eRunnable);
        return task;*/
