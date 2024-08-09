package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component(value="IRctcBookingDetails")
public class IRctcBookingDetails extends BookingDetails{
	
	private String irctcSpecificProperty;
	public IRctcBookingDetails(String bookingId, String bookingType, String irctcSpecificProperty) {
		super(bookingId, bookingType);
		this.irctcSpecificProperty = irctcSpecificProperty;
	}

	public IRctcBookingDetails(String bookingId, String bookingType) {
		super(bookingId, bookingType);
	}
	public IRctcBookingDetails() {
        // Default constructor
    }

	public String getIrctcSpecificProperty() {
		return irctcSpecificProperty;
	}

	public void setIrctcSpecificProperty(String irctcSpecificProperty) {
		this.irctcSpecificProperty = irctcSpecificProperty;
	}

	@Override
	public String toString() {
		return "IRctcBookingDetails [irctcSpecificProperty=" + irctcSpecificProperty + "]";
	}

}
