package com.springboot.Entities;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TaskEntity")
public class TasksEntitiesss {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Task ID")
    private Integer id;

//    @Value("${your.cntr:10}")
    private Integer cntr;

//    @Value("task")
    private String title;
    
//    @Value("task_desc")
    private String title_description;
    
//    @Value("${your.dueDate:2023-01-01}")
    private LocalDate dueDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCntr() {
        return cntr;
    }

    public void setCntr(Integer cntr) {
        this.cntr = cntr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_description() {
        return title_description;
    }

    public void setTitle_description(String title_description) {
        this.title_description = title_description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
