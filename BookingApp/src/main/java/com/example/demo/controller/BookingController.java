package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.BookingDetails;
import com.example.demo.service.BookingService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
@RequestMapping("/booking")
public class BookingController {
	private BookingService service;

	public BookingController(BookingService service) {
		super();
		this.service = service;
	}

	@GetMapping
	private ResponseEntity<List<Object>> getBeans() {
		List<Object> bookingDetails = service.getBookingDetails();

		return new ResponseEntity<>(bookingDetails, HttpStatus.OK);

	}

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String handleFileUpload(@RequestPart("bookingDetails") BookingDetails bookingDetails,@RequestPart("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			long fileSize = file.getSize();
			String contentType = file.getContentType();
			System.out.println("filename: "+fileName +" have file size: "+fileSize);
		}
		return "File uploaded successfully";
	}
	
	@GetMapping(value = "/generateTicket", produces = MediaType.APPLICATION_PDF_VALUE)
	public void generateBookingTicket() {
	    try {
	        ClassPathResource resource = new ClassPathResource("booking_details.xml");
	        File xmlFile = resource.getFile();
	        BookingDetails bookingDetails = parseBookingDetails(xmlFile);
	        generatePdfBookingTicket(bookingDetails);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private BookingDetails parseBookingDetails(File xmlFile) {
	    BookingDetails bookingDetails = null;
	    try {
	        JAXBContext context = JAXBContext.newInstance(BookingDetails.class);
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        bookingDetails = (BookingDetails) unmarshaller.unmarshal(xmlFile);
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	    return bookingDetails;
	}

	private void generatePdfBookingTicket(BookingDetails bookingDetails) throws IOException {
	    Document document = new Document();
	    try {
	        PdfWriter.getInstance(document, new FileOutputStream("bookingTicket.pdf"));
	        document.open();
	        document.add(new Paragraph("Booking ID: " + bookingDetails.getBookingId()));
	        document.add(new Paragraph("Booking Type: " + bookingDetails.getBookingType()));
	    } catch (DocumentException e) {
	        e.printStackTrace();
	    } finally {
	        document.close();
	    }
	}
	
//	@GetMapping(value = "/generateTicket", produces = MediaType.APPLICATION_PDF_VALUE)
//	public void generateBookingTicket() {
//	    try {
//	        ClassPathResource resource = new ClassPathResource("booking_details.xml");
//	        File xmlFile = resource.getFile();
//	        List<BookingDetails> bookingDetails = parseBookingDetails(xmlFile);
//	        generatePdfBookingTicket(bookingDetails);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	private List<BookingDetails> parseBookingDetails(File xmlFile) {
//	    List<BookingDetails> bookingDetails = null;
//	    try {
//	        JAXBContext context = JAXBContext.newInstance(BookingDetails.class);
//	        Unmarshaller unmarshaller = context.createUnmarshaller();
//	        bookingDetails = (List<BookingDetails>) unmarshaller.unmarshal(xmlFile);
//	    } catch (JAXBException e) {
//	        e.printStackTrace();
//	    }
//	    return bookingDetails;
//	}
//
//	private void generatePdfBookingTicket(List<BookingDetails> bookingDetails) throws IOException {
//	    Document document = new Document();
//	    try {
//	        PdfWriter.getInstance(document, new FileOutputStream("bookingTickets.pdf"));
//	        document.open();
//	        for(BookingDetails bookingdetails:bookingDetails) {
//	        	document.add(new Paragraph("Booking ID: " + bookingdetails.getBookingId()));
//		        document.add(new Paragraph("Booking Type: " + bookingdetails.getBookingType()));
//	        }
//	        
//	    } catch (DocumentException e) {
//	        e.printStackTrace();
//	    } finally {
//	        document.close();
//	    }
//	}

}
