package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	
	private ApplicationContext context;

	public BookingService(ApplicationContext context) {
		super();
		this.context = context;
	}
	
	public List<Object> getBookingDetails() {
        List<String> bookingDetailBeanNames = List.of("IRctcBookingDetails", "BusBookingDetails", "HotelBookingDetails", "FlightBooking");
        List<Object> bookingDetails = new ArrayList<>();

        for (String beanName : bookingDetailBeanNames) {
            Object bookingDetail = context.getBean(beanName);
            bookingDetails.add(bookingDetail);
        }

        return bookingDetails;
    }

}
