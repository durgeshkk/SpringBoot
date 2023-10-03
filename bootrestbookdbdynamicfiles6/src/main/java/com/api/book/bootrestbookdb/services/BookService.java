package com.api.book.bootrestbookdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbookdb.dao.BookRepository;
import com.api.book.bootrestbookdb.entities.Book;

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

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();
    // static{
    //     list.add(new Book(12, "Villian", "Durgesh"));
    //     list.add(new Book(14, "Villian2", "Durgesh1"));
    //     list.add(new Book(18, "Villian3", "Durgesh2"));
    // }

    // Get All Books
    // public List<Book> getAllBooks(){
    //     return list;
    // }
    public List<Book> getAllBooks(){
        // Typecasting
        List<Book> l = (List<Book>)this.bookRepository.findAll();
        return l;
    }

    // Get single Book
    public Book getBookById(int id){
        // We can also use foreach loop to do so bt stream is easy to do 
        Book b = null;
        try{
            // b = list.stream().filter(e->e.getId()==id).findFirst().get();
            b = this.bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    // Add Book
    public Book addBook(Book b){
        // list.add(b);
        Book res = bookRepository.save(b);
        return res;
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
        // list = list.stream().filter(book->book.getId() != bid).
        // collect(Collectors.toList());

        bookRepository.deleteById(bid);

    }

    // Update Book
    public void updateBook(Book bk, int bid) {
        // map returns all the elements of Book 1 by 1
        // every time just perform changes and return each book and store it in list
        bk.setId(bid);
        // list = list.stream().map(b->{
        //     if(b.getId()==bid){
        //         b.setTitle(bk.getTitle());
        //         b.setAuthor(bk.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        bookRepository.save(bk);
    }
}
