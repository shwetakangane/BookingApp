package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component(value="HotelBookingDetails")
public class HotelBookingDetails extends BookingDetails{
	private String hotelSpecificProperty;
	public HotelBookingDetails(String bookingId, String bookingType, String hotelSpecificProperty) {
		super(bookingId, bookingType);
		this.hotelSpecificProperty = hotelSpecificProperty;
	}

	public HotelBookingDetails(String bookingId, String bookingType) {
		super(bookingId, bookingType);
	}
	
	public HotelBookingDetails() {
        // Default constructor
    }

	public String getHotelSpecificProperty() {
		return hotelSpecificProperty;
	}

	public void setHotelSpecificProperty(String hotelSpecificProperty) {
		this.hotelSpecificProperty = hotelSpecificProperty;
	}

	@Override
	public String toString() {
		return "HotelBookingDetails [hotelSpecificProperty=" + hotelSpecificProperty + "]";
	}

}
