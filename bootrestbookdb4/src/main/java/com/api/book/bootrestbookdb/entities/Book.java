package com.api.book.bootrestbookdb.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "booooks") //this will create the table Book by name boooks
public class Book {

    @Id//notify the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")//ID in table will be named as book_id
    private int id;

    private String title;

    /*
    private String author;
    * Now assume if author is object of some another class or is non-primitive data
    type
    Keep 1-1 maping b/w author and book
    Mapping is unidirectional as we are moving from Book to Author
    */
    
    // We need to use cascade with OnetoOne since we need to take field I/p for both
    // author as well as books table
    // Via Cascade pehle author table save honga then book table 
    // Also deleting book will delete it's ultimate author
    // For more clarity look into the Incremented values while adding the datA TO 
    // the table

    /*25. Bidirectional Mapping 
     * Lastly we did Uni Mapping Book->Author
     * We can get Author only from Book
     * Bi means we can fetch data from each other as we want!!
     * But normal BiD mapping will create prblm since harr baar Book will call Author
     * and vice-versa(DeadLoop)
     * It will treat the mapping column/Foreign Key differently
     * author_author_id for Book and book_id for Author 
     * This will create a Deadloop mappedBy and column name
     * It's solved by JSON manage ref & back ref 
     * Manage is the Super and back is subclass
     * By this we will always get only Parents data and not child's data in JSON 
     * format..
     */

     
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
    
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
    public Book() {
    }
    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

}
