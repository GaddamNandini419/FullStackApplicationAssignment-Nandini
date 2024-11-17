package com.example.nandini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.nandini.model.ExchangeRequest;
import com.example.nandini.service.ExchangeRequestService;

import java.util.List;

@RestController
@RequestMapping("/exchange-requests")
@CrossOrigin(origins = "*")
public class ExchangeRequestController {

    @Autowired
    private ExchangeRequestService exchangeRequestService;

    // Endpoint to create a new exchange request
    @PostMapping
    public ResponseEntity<ExchangeRequest> createExchangeRequest(@RequestBody ExchangeRequest exchangeRequest) {
        ExchangeRequest createdRequest = exchangeRequestService.createExchangeRequest(exchangeRequest);
        return ResponseEntity.ok(createdRequest);
    }

    // Endpoint to get all exchange requests for a specific book
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<ExchangeRequest>> getRequestsForBook(@PathVariable String bookId) {
        List<ExchangeRequest> requests = exchangeRequestService.getRequestsForBook(bookId);
        return ResponseEntity.ok(requests);
    }

    // Endpoint to update the status of an exchange request
    @PutMapping("/{requestId}/status")
    public ResponseEntity<Void> updateRequestStatus(@PathVariable String requestId, @RequestParam String status) {
        exchangeRequestService.updateExchangeRequestStatus(requestId, status);
        return ResponseEntity.ok().build();
    }
    
 // Endpoint to get all requested books for exchange
    @GetMapping("/requested-books")
    @CrossOrigin
    public ResponseEntity<List<ExchangeRequest>> getAllRequestedBooks() {
        List<ExchangeRequest> requestedBooks = exchangeRequestService.getAllRequestedBooks();
        return ResponseEntity.ok(requestedBooks);
    }
    
    @PutMapping("/exchange-requests/{id}/approve")
    @CrossOrigin
    public ResponseEntity<?> approveRequest(@PathVariable String id) {
        ExchangeRequest request = exchangeRequestService.findById(id);
        if (request == null) {
            return ResponseEntity.notFound().build();
        }
        request.setStatus("Approved");
        exchangeRequestService.save(request);
        return ResponseEntity.ok().build();
    }
}
