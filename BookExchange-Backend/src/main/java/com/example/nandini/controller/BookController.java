package com.example.nandini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import com.example.nandini.model.Book;
import com.example.nandini.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {
	
	

	    @Autowired
	    private BookService bookService;

	    //get list of books
	    @GetMapping("/allbooks")
	    public List<Book> getAllBooks() {
	        return bookService.getAllBooks();
	 
	    }
	    
	    //create book
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Book addBook(@RequestBody Book book) {
	        return bookService.addBook(book);
	    }
	    
	    //get book by id
	    @GetMapping("/{bookId}")
	    public Optional<Book> getbookBybookId(@PathVariable String bookId) {
	        return bookService.getBookById(bookId);
	    }
	    
	    //Delete Book
	    @DeleteMapping("/{bookId}")
	    public void deleteBook(@PathVariable String bookId) {
	        bookService.deleteBook(bookId);
	    }
	    
	    //update book
	    @PutMapping("/{bookId}")
	    public Book updateBook(@PathVariable String bookId, @RequestBody Book book) {
	        return bookService.updateBook(bookId, book);
	    }

	    
	    
	 // Search books based on various criteria
	    @GetMapping("/search")
	    public List<Book> searchBooks(
	            @RequestParam(required = false) String title,
	            @RequestParam(required = false) String author,
	            @RequestParam(required = false) String genre,
	            @RequestParam(required = false) Boolean available) {
	        return bookService.searchBooks(title, author, genre, available);
	    }

}
