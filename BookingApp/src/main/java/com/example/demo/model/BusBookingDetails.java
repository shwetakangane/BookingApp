package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;


@Component(value="BusBookingDetails")
@XmlRootElement
public class BusBookingDetails extends BookingDetails{
	private String busSpecificProperty;
	public BusBookingDetails(String bookingId, String bookingType, String busSpecificProperty) {
		super(bookingId, bookingType);
		this.busSpecificProperty = busSpecificProperty;
	}

	public BusBookingDetails(String bookingId, String bookingType) {
		super(bookingId, bookingType);
	}
	public BusBookingDetails() {
        // Default constructor
    }

	public String getBusSpecificProperty() {
		return busSpecificProperty;
	}

	public void setBusSpecificProperty(String busSpecificProperty) {
		this.busSpecificProperty = busSpecificProperty;
	}

	@Override
	public String toString() {
		return "BusBookingDetails [busSpecificProperty=" + busSpecificProperty + "]";
	}

}
