package com.example.nandini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nandini.model.Book;
import com.example.nandini.repository.BookRepository;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
	
	
	    @Autowired
	    private BookRepository bookRepository;

	    
	    
	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();
	        
	    }
	    
	    public Optional<Book> getBookById(String id) {
	        return bookRepository.findById(id);
	    }
	        
	    public Book addBook(Book book) {
	        return bookRepository.save(book);
	    }
	    
	    public void deleteBook(String id) {
	        bookRepository.deleteById(id);
	    }
	    
	    public Book updateBook(String bookId, Book book) {
	        book.setBookId(bookId);
	        return bookRepository.save(book);
	    }

	    // Search method using repository
	    public List<Book> searchBooks(String title, String author, String genre, Boolean available) {
	        // Create an empty list for storing search results
	        List<Book> books = bookRepository.findAll();

	        // Apply filters based on input
	        if (title != null && !title.isEmpty()) {
	            books = bookRepository.findByTitleContainingIgnoreCase(title);
	        }
	        if (author != null && !author.isEmpty()) {
	            books = bookRepository.findByAuthorContainingIgnoreCase(author);
	        }
	        if (genre != null && !genre.isEmpty()) {
	            books = bookRepository.findByGenreContainingIgnoreCase(genre);
	        }
	        if (available != null) {
	            books = bookRepository.findByAvailable(available);
	        }

	        return books;
	    }
	    

}
