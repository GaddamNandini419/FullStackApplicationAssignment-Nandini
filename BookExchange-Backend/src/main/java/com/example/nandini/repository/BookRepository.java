package com.example.nandini.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nandini.model.Book;


@Repository
public interface BookRepository extends MongoRepository<Book, String>{

	List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByGenreContainingIgnoreCase(String genre);
    List<Book> findByAvailable(Boolean available);



}
