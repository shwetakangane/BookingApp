package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component(value="FlightBooking")
public class FlightBooking extends BookingDetails{
	
	private String flightSpecificProperty;
	public FlightBooking(String bookingId, String bookingType, String flightSpecificProperty) {
		super(bookingId, bookingType);
		this.flightSpecificProperty = flightSpecificProperty;
	}

	public FlightBooking(String bookingId, String bookingType) {
		super(bookingId, bookingType);
	}
	public FlightBooking() {
        // Default constructor
    }

	public String getFlightSpecificProperty() {
		return flightSpecificProperty;
	}

	public void setFlightSpecificProperty(String flightSpecificProperty) {
		this.flightSpecificProperty = flightSpecificProperty;
	}

	@Override
	public String toString() {
		return "FlightBooking [flightSpecificProperty=" + flightSpecificProperty + "]";
	}

}
