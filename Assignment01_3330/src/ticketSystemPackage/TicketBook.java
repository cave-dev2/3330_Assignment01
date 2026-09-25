package ticketSystemPackage;

/*
This class stores tickets and owns them. It should not coordinate the whole application. Its
responsibility is ticket storage, creation, and basic queries.

Constraints: You must store tickets using a plain Java array, for example:
• private Ticket[] tickets;
• private int count;

Required behavior:
• Constructor creates an empty book with a fixed maximum capacity (must be positive)
• A method such as createTicket(int id, Event event, TicketType type, String studentName)
creates the Ticket object internally and stores it if space exists; otherwise it throws an ex-
ception
• findById(int id) returns the matching ticket or null if not found
• printAll() prints all stored tickets (one per line)
• printForEvent(Event event) prints tickets for that event

Design requirements:
• Fields must be private
• Do not expose the internal array directly
• TicketBook should create the Ticket objects it owns. Do not create a Ticket in Main and
pass it into the book.
• Keep methods focused. Avoid turning this into a god class.

Open design choice: Decide how printForEvent determines whether a ticket belongs to
the requested event without implementing equals. You may compare references or use another
approach that stays within the topics covered. Document your choice in a short comment.
*/

public class TicketBook {

	//Define class variables
	private Ticket[] tickets; 
	private int count; 
	
	//Max ticket array capacity
	private final int maxCount = 100;

	//Class constructor
	public TicketBook() {
		
		//Fill variables
		this.tickets = new Ticket[maxCount]; 
		this.count = 0;
		
	}
	
	//Creates ticket if space in tickets
	public int createTicket(int id, Event event, TicketType type, String studentName) {
		
		if (count < maxCount) {
			
			Ticket ticket = new Ticket(id, event, type, studentName);
			tickets[count] = ticket;
			count+=1;
			return 0;
		}
		throw new IllegalStateException("Ticket Array is full");
		
	}
	
	//Return ticket by id
	public Ticket findById(int id) {

		for (Ticket ticket : tickets) {
			if (ticket.getID() == id) {
				return ticket;
			}
		}
		return null; 
		
	}
	
	//Prints all tickets
	public int printAll() {
		
		for (Ticket printTicket : tickets) {
			if (printTicket != null) System.out.println(printTicket + "\n");
		}
		return 0;
		
	}
	
	//Prints all tickets connected to event
	public int printForEvent(Event event) {
		
		if (event == null) {
			throw new IllegalArgumentException("Event cannot be null for print");
		}
		
		for (Ticket printTicket : tickets) {
			if (printTicket != null) {
				if (printTicket.getEvent() == event) System.out.println(printTicket + "\n");
			}
		}
		return 0;
		
	}
	
}
