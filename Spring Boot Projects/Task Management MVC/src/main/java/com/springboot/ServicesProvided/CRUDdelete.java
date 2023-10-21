package com.springboot.ServicesProvided;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.Entities.TasksEntitiesss;
import com.springboot.dao.TaskManagerrRepository;

@Service
public class CRUDdelete {
    
    @Autowired
    TaskManagerrRepository tamarepo;
    
    private static final Logger logger = LoggerFactory.getLogger(CRUDdelete.class);

    public void deleteByIntId(Integer id){
//        Optional.ofNullable(tamarepo.findById(id))
//        .orElseThrow(() -> new IllegalStateException("ID Not Found!!"));

        logger.info("ID Found to Delete");
        tamarepo.deleteById(id);
    }

    @Autowired
    private CRUDviewer v;

    List<TasksEntitiesss> allTasksEntities =  v.getAllEntities();
    public void deleteByTitlePattern(String s){
        List<TasksEntitiesss> filterTasksEntities = allTasksEntities.stream()
        .filter(t -> (t.getTitle().contains(s) ? true : false))
        .collect(Collectors.toList());

        logger.info("Deleting Filtered Tasks!!");
        tamarepo.deleteAll(filterTasksEntities);
    }
    
    public void deleteAll(){
        logger.info("Deleting Complete DB Data!!");
        tamarepo.deleteAll();
    }
}
