package com.example.nandini.service;

import com.example.nandini.model.ExchangeRequest;
import com.example.nandini.repository.ExchangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRequestService {

    @Autowired
    private ExchangeRequestRepository exchangeRequestRepository;

    // Create a new exchange request
    public ExchangeRequest createExchangeRequest(ExchangeRequest exchangeRequest) {
        return exchangeRequestRepository.save(exchangeRequest);
    }

    // Get all requests for a specific book by bookId
    public List<ExchangeRequest> getRequestsForBook(String bookId) {
        return exchangeRequestRepository.findByBookId(bookId);
    }

    // Update the status of an exchange request
    public void updateExchangeRequestStatus(String requestId, String status) {
        Optional<ExchangeRequest> requestOptional = exchangeRequestRepository.findById(requestId);
        if (requestOptional.isPresent()) {
            ExchangeRequest request = requestOptional.get();
            request.setStatus(status);
            exchangeRequestRepository.save(request);
        }
    }
    
 // Method to get all requested books for exchange
    public List<ExchangeRequest> getAllRequestedBooks() {
        return exchangeRequestRepository.findAll();
    }

    public ExchangeRequest findById(String id) {
        return exchangeRequestRepository.findById(id).orElse(null);
    }


	public void save(ExchangeRequest request) {
	    exchangeRequestRepository.save(request);
	}


}
