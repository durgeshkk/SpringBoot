package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

// Component mean we have a class of who we need to create the object

/*
 * Error Handling :
 * POST = 201
 * PUT = 200
 * GET = 200
 * DELETE = 204
 * GET(Retrieve all) = 200,204,206
 */

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();
    static{
        list.add(new Book(12, "Villian", "Durgesh"));
        list.add(new Book(14, "Villian2", "Durgesh1"));
        list.add(new Book(18, "Villian3", "Durgesh2"));
    }

    // Get All Books
    public List<Book> getAllBooks(){
        return list;
    }

    // Get single Book
    public Book getBookById(int id){
        // We can also use foreach loop to do so bt stream is easy to do 
        Book b = null;
        try{
            b = list.stream().filter(e->e.getId()==id).findFirst().get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    // Add Book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    public void deleteBook(int bid){
        // Use foreach to delete or 
        // list = list.stream().filter(book->{
        //     if(book.getId() != bid){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }).collect(Collectors.toList());
        
        /*
        * The above code will filter : 
        * If ID is equal to bid it will not add it to collection/list
        * Then finally update the list
        */
        
        //  Shortcut : 
        list = list.stream().filter(book->book.getId() != bid).
        collect(Collectors.toList());

    }

    // Update Book
    public void updateBook(Book bk, int bid) {
        // map returns all the elements of Book 1 by 1
        // every time just perform changes and return each book and store it in list
        bk.setId(bid);
        list = list.stream().map(b->{
            if(b.getId()==bid){
                b.setTitle(bk.getTitle());
                b.setAuthor(bk.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
