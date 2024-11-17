package com.example.nandini.repository;

import com.example.nandini.model.ExchangeRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ExchangeRequestRepository extends MongoRepository<ExchangeRequest, String> {
    // Custom query to find exchange requests by bookId
    List<ExchangeRequest> findByBookId(String bookId);
}
