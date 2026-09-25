package ticketSystemPackage;

/*
Your Main must demonstrate functionality with hardcoded data.

Minimum demo requirements:
• Create at least 2 events
• Create at least 2 ticket types
• Create at least 5 tickets across different events and ticket types
• Cancel at least 1 ticket
• Admit at least 1 ticket
• Demonstrate at least 1 invalid operation and show how your design handles it (for example,
trying to admit a canceled ticket)
• Print all tickets
• Print tickets for one specific event
 */

public class Main {

	public static void main(String[] args) {
		
		//Creating TicketManager
		TicketBook ticketBook = new TicketBook();
		TicketManager ticketManager = new TicketManager(ticketBook);
		
		//Creating 3 Events
		System.out.println("Event Creation: -----\n");
		
		Event raveEvent = new Event("Finals Week Rave", "The Columns");
		Event conferenceEvent = new Event("Engineers' Conference", "1000 Smith Hall");
		Event concertEvent = new Event("Math Department Concert", "The Missouri Theatre");
		System.out.println(raveEvent.toString());
		System.out.println(conferenceEvent.toString());
		System.out.println(concertEvent.toString());
		
		//Creating 3 TicketTypes
		System.out.println("\nTicketType Creation: -----\n");
		
		TicketType studentTicketType = new TicketType("Student", 6.99);
		TicketType staffTicketType = new TicketType("Staff", 5.99);
		TicketType freeTicketType = new TicketType("Free", 0.00);
		System.out.println(studentTicketType.toString());
		System.out.println(staffTicketType.toString());
		System.out.println(freeTicketType.toString());
		
		//Creating 5 Tickets		
		ticketManager.createTicket(raveEvent, studentTicketType, "Alice");
		ticketManager.createTicket(raveEvent, staffTicketType, "Bob");
		ticketManager.createTicket(conferenceEvent, freeTicketType, "Charlie");
		ticketManager.createTicket(concertEvent, studentTicketType, "David");
		ticketManager.createTicket(concertEvent, staffTicketType, "Eve");
		
		//Print all Tickets
		System.out.println("\nTicket Creation: -----\n");
		ticketManager.printAll();
		
		//Print all raveEvent Tickets
		System.out.println("Tickets for Event: -----\n");
		ticketManager.printForEvent(raveEvent);
		
		//Show cancellation of specific Ticket
		System.out.println("Ticket Cancellation: -----\n");
		ticketManager.cancelTicket(2);
		ticketManager.printForEvent(raveEvent);
		
		//Show admission of specific Ticket
		System.out.println("Ticket Admission: -----\n");
		ticketManager.admitTicket(1);
		ticketManager.printForEvent(raveEvent);
		
		//Demonstrate invalid operation handling
		System.out.println("Invalids Handling: -----\n");
		//Event fakeEvent = new Event("Crash Party", null);
		//TicketType fakeTicketType = new TicketType("Free Money", -20.00);
		//ticketManager.createTicket(fakeEvent, fakeTicketType, "Sybil");
		//ticketManager.printForEvent(fakeEvent);
		ticketManager.admitTicket(12);
		
	}

}
