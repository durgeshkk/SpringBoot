package com.jpa.test.bootjpaexample.dao;

import com.jpa.test.bootjpaexample.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
We can use @Query to fire our own return query
Query can be of 2 types :
1. JPQL(Java Persistence Query Lang) : e.g. getAllUser
2. Native Query
 */

public interface UserRepository extends CrudRepository<User,Integer> {
//    Custom Finding
    public List<User> findByName(String name);
    public List<User> findByCity(String city);
    public List<User> findByNameAndCity(String name, String city);

//    JPQL
    @Query("select u FROM User u")
    public List<User> getAllUser();

    /*
    n is parameter;     param maps n to name
     */
    @Query("select u FROM User u WHERE u.name =:n")
    public List<User> getUserByName(@Param("n") String name);

    @Query("select u FROM User u WHERE u.name =:n and u.city =:c")
    public List<User> getUserByNameAndCity(@Param("n") String name,@Param("c") String city);

//    Native Query :
    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();

}
