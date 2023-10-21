package com.springboot.controller;
import java.time.LocalDate;

import com.springboot.ServicesProvided.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entities.TasksEntitiesss;

@RestController
@Data
public class TaskManageeerController {
   
//    @Autowired
    private CRUDcreater Bana;

//    @Autowired
    private CRUDviewer Dikha;
    
//    @Autowired
    private CRUDupdate Karname;
    
//    @Autowired
    private CRUDdelete Uddda;

    @PostMapping("/api/request/CRUDcreater")
    public void tamarepoeqCreate(@RequestBody TasksEntitiesss tasksEntitiesss){
        Bana.data_saved(tasksEntitiesss);
    }
    
    @PostMapping("/api/request/CRUDupdate")
    public void tamarepoeqUpdate(@RequestBody TasksEntitiesss tasksEntitiesss){
        Karname.updateById(tasksEntitiesss);
    }

    @PostMapping("/api/request/viewerdb")
    public void tamarepoeqViewDB(){
        Dikha.getAllEntities();
    }
    
    @PostMapping("/api/request/viewerid")
    public void tamarepoeqViewByID(@RequestBody Integer id){
        Dikha.getById(id);
    }
    
    @PostMapping("/api/request/viewerBeforeDueDate")
    public void tamarepoeqViewBeforeDueDate(@RequestBody LocalDate localDate){
        Dikha.getBeforeDueDate(localDate);
    }

    @PostMapping("/api/request/viewerTitlePatternMatching")
    public void tamarepoeqViewTitlePatternMatching(@RequestBody String s){
        Dikha.getTitlePatternMatching(s);
    }

    @PostMapping("/api/request/deleteAll")
    public void tamarepoeqDeleteAll(){
        Uddda.deleteAll();
    }
    
    @PostMapping("/api/request/deleteId")
    public void tamarepoeqDeleteByIntId(@RequestBody Integer id){
        Uddda.deleteByIntId(id);
    }

    @PostMapping("/api/request/deleteByTitleMatch")
    public void tamarepoeqDeleteByTitleMatch(@RequestBody String s){
        Uddda.deleteByTitlePattern(s);
    }

}
