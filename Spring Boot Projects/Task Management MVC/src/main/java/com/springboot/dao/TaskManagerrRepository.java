package com.springboot.dao;

import com.springboot.Entities.TasksEntitiesss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskManagerrRepository extends JpaRepository<TasksEntitiesss, Integer> {
//    public List<Task> findAll();
}
