package com.api.book.bootrestbookdb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbookdb.entities.Book;
import com.api.book.bootrestbookdb.services.BookService;

// For Normal APIs
// @Controller

/*
CRUD Operation :
 * GET : Read the Data
 * POST : Create the Data
 * PUT : Update the Data
 * DELETE : Delete the Data
 */

// For RestAPIs we need to use RestController
/*
 * When we are using RestController we needn't to use Response Body
 */

 /*
  * No need to make any changes to controller when shifting to DB
  */

/*
      * Resources file is more imp to save any type of Data
      Template will save HTML,and static will keep CSS Files.
      */
  @RestController
public class BookController {
    /*
    The below fxn is not correct since it's sending String which is not in the 
    form of JSON
    public String getBooks(){
        return "this is testing Book first";
    }
    */
    
    // This will only work for Views
    /*
     * Abb bass jaise hi we will write ip/books we will get the O/p as 
     * this is testing Book first.
     * But now to pass this view as a String use ResponseBody
     */
    //  @RequestMapping(value = "/books",method = RequestMethod.GET)
    //  @ResponseBody
    //  public String getBooks(){
    //      return "this is testing Book first";
    // }
    
    /*
    @RequestMapping(value = "/books",method = RequestMethod.GET)
    @ResponseBody
    * This can directly be replaced by GetMapping
    Below Result will be send in form of JSON file
    */

    // @GetMapping("/books")
    // public Book getBooks(){
        //     //  return "this is testing Book first re";
        //     Book b= new Book();
        //     b.setId(1234);
        //     b.setTitle("CWH");
        //     b.setAuthor("Harry re");
        //     return b;
        // }

    /*
    No need of above code due to BookServices
        * We just make the obj of the BS class and just use functionalities of it
        */
    
    @Autowired
    private BookService bs;

    // W/o error Handling : 
    // @GetMapping("/books")
    // public List<Book> getBooks(){
        // return this.bs.getAllBooks();
        // }

    // With error Handling : 
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> l = bs.getAllBooks();
        if(l.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.of(Optional.of(l));
        }
    }

    // Connect the ID from the URL we need to define Path Var which will assign id to a
    // @GetMapping("/books/{id}")
    // public Book getBook(@PathVariable("id") int a){
    //     return bs.getBookById(a);
    // }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int a){
        Book b = bs.getBookById(a);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    // We need to convert the JSON File data again to normal file so we need to use 
    // Request Body
    // @PostMapping("/books")
    // public Book addBook(@RequestBody Book b){
    //     Book b1 = this.bs.addBook(b);
    //     System.out.println(b1);
    //     return b1;
    // }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book b){
        Book b1 = null;
        try{
            b1 = this.bs.addBook(b);
            System.out.println(b1);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // @DeleteMapping("/books/{bookID}")
    // public void deleteBook(@PathVariable("bookID") int bid){
    //     this.bs.deleteBook(bid);
    // }

    @DeleteMapping("/books/{bookID}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookID") int bid){
        try{
            this.bs.deleteBook(bid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update Book
    // @PutMapping("/books/{bookID}")
    // public Book updateBook(@RequestBody Book b,@PathVariable("bookID") int bid){
    //     this.bs.updateBook(b,bid);
    //     return b;
    // }

    @PutMapping("/books/{bookID}")
    public ResponseEntity<Book> updateBook(@RequestBody Book b,@PathVariable("bookID") int bid){
        try{
            this.bs.updateBook(b,bid);
            return ResponseEntity.ok().body(b);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
