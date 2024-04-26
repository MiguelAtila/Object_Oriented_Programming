package Flights;

import java.util.Random;

public class Ticket {
	private String ticketId;
	private Flight flight; 
	private String fullName;
	private String phoneNumber;
	private String email;
	private String country;
	private String date;
	private String gate;
	private String time;
	private double ticketPrice;
	
	public Ticket(String flighId, String fullName, String phoneNumber, String email, String country, double ticketPriece, double ticketPrice) {
		this.setTicketId(generateTicketId());
		this.setFullName(fullName);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
		this.setCountry(country);
		this.setTicketPrice(ticketPrice); 
}

	private String generateTicketId() {
		Random rand = new Random();
		int randomNum = rand.nextInt(10000);
		// TODO Auto-generated method stub
		return "RE-" + String.format("%04d", randomNum); 
	}

	public void setSeatNumber(String seatNumber) {
		// TODO Auto-generated method stub
		
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
