package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class BookingDetails {
	private String bookingId;
    private String bookingType;
	public BookingDetails(String bookingId, String bookingType) {
		super();
		this.bookingId = bookingId;
		this.bookingType = bookingType;
	}
	public BookingDetails() {
		super();
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingType() {
		return bookingType;
	}
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", bookingType=" + bookingType + "]";
	}
    
}
