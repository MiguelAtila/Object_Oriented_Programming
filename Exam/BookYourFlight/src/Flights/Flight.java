package Flights;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Flight {
	private String id;
	private List<List<Character>> seatLayout;
	private double ticketPrice;
	private LocalDateTime dateTime;
	private char gate;
	private Map<String, Ticket> soldTickets;
	private Map<String, Character> planeMap;
	
	public Flight(String origin, String destination) {
		this.id = generateFlightId(origin, destination);
		this.seatLayout = generateSeatLayout();
		this.ticketPrice = generateRandomTicketPrice();
		this.dateTime = LocalDateTime.now();
		this.gate = generateRandomGate();
		this.soldTickets = new HashMap<>();
		this.planeMap = generatePlaneMap ();		
	}
	public void buyTicket(String ticketId, String fullName, String phoneNumber, String email, String country, String seatNumber) {
		if(soldTickets.containsKey(ticketId)) {
			System.out.println("Seat " + seatNumber + " is already occupied");
			return;
		}
		int row = seatNumber.charAt(0) - 'A';
		int column = Integer.parseInt(seatNumber.substring(2)) -1;
		if (seatLayout.get(row).get(column) == 'X') {
            System.out.println("Seat " + seatNumber + " is already occupied.");
            return;
        }
        Ticket ticket = new Ticket(ticketId, fullName, phoneNumber, email, country, ticketPrice, ticketPrice);
        ticket.setSeatNumber(seatNumber);
        soldTickets.put(ticketId, ticket);
        seatLayout.get(row).set(column, 'X'); 
        System.out.println("Ticket with ID " + ticketId + " sold successfully.");
    }

    private List<List<Character>> generateSeatLayout() {
        List<List<Character>> layout = new ArrayList<>();
        for (int i = 0; i < 2; i++) { 
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < 6; j++) { 
                row.add('O'); 
            }
            layout.add(row);
        }
        return layout;
    }

    private Map<String, Character> generatePlaneMap() {
        Map<String, Character> map = new HashMap<>();
        char row = 'A';
        for (int i = 0; i < seatLayout.size(); i++) {
            for (int j = 0; j < seatLayout.get(i).size(); j++) {
                map.put(row + "-" + (j + 1), seatLayout.get(i).get(j));
            }
            row++;
        }
        return map;
    }

    private String generateFlightId(String origin, String destination) {
        Random rand = new Random();
        int randomNum = rand.nextInt(10000);
        return origin.substring(0, 2).toUpperCase() + destination.substring(0, 2).toUpperCase() + "-" + String.format("%04d", randomNum);
    }

    private double generateRandomTicketPrice() {
        Random rand = new Random();
        return rand.nextInt(1001) + 1000; 
    }

    private char generateRandomGate() {
        Random rand = new Random();
        return (char) (rand.nextInt(2) + 'A'); 
    }
}
