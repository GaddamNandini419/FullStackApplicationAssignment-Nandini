package com.example.nandini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "exchange_requests")
public class ExchangeRequest {

    @Id
    private String id; // MongoDB uses String for IDs

    private String bookId; // Reference to the book
    private String requesterName;
    private String deliveryMethod;
    private String exchangeDuration;
    private String message;
    private LocalDateTime requestDate = LocalDateTime.now();
    private String status; // PENDING, APPROVED, REJECTED
    
    
    
    
    
	public ExchangeRequest(String id, String bookId, String requesterName, String deliveryMethod,
			String exchangeDuration, String message, LocalDateTime requestDate, String status) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.requesterName = requesterName;
		this.deliveryMethod = deliveryMethod;
		this.exchangeDuration = exchangeDuration;
		this.message = message;
		this.requestDate = requestDate;
		this.status = status;
	}
	
	
	
	public ExchangeRequest() {
		
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getRequesterName() {
		return requesterName;
	}
	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getExchangeDuration() {
		return exchangeDuration;
	}
	public void setExchangeDuration(String exchangeDuration) {
		this.exchangeDuration = exchangeDuration;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    // Getters and Setters
    
    
    
}

