package ticketSystemPackage;

/*
Coordinates the system at a higher level.
Required behavior:
• Stores a TicketBook
• Generates ticket IDs using a private counter field (do not use a static field for application
state)
• Provides high-level operations such as:
– createTicket(Event event, TicketType type, String studentName)
– cancelTicket(int id)
– admitTicket(int id)
5
• High-level operation methods should return meaningful values when appropriate so they can
be tested directly
Design requirements:
• Avoid reaching through objects to manipulate internals
• Avoid long chains like a.getB().getC().doSomething()
• Delegate behavior to the class that owns the relevant data
• Do not duplicate ticket-state rules in the manager. The Ticket class should be responsible
for its own state transitions.
 */

public class TicketManager {

	// Define class fields (nextId, ticketBook):
	// For ID generator ('nextId'), a private int is defined at 1 and increased for every 
	// additional ticket added to the TicketBook.
	private int nextId = 1; 
	private TicketBook ticketBook; 
	
	// Class constructor
	public TicketManager(TicketBook ticketBook) {
		this.ticketBook = ticketBook;
	}
	
	// Provide access to high-level operation methods
	// createTicket() method: 
	public int createTicket(Event event, TicketType type, String studentName) {
		
		// Call createTicket from TicketBook with the current 'nextId' value
		this.ticketBook.createTicket(nextId, event, type, studentName);
		
		// If successful, increase the count of 'nextId' and return
		// the value of 'nextId' minus one to represent the current ticket ID 
		nextId = nextId + 1; 
		return nextId - 1;
		
	}
	
	// cancelTicket() method:
	public boolean cancelTicket(int ticketId) {
		
		// Call findById() method from TicketBook class to
		// find ticket in ticketBook given ticketId
		Ticket ticketToCancel = this.ticketBook.findById(ticketId);
		
		// Check that ticketToCancel is not null
		if(ticketToCancel == null) {
			return false;
		}
		else {
			// if ticketId exists, call cancel() method from Ticket class to
			// change 'canceled' state to true and return ticketCanceled 
				boolean ticketCanceled = ticketToCancel.cancel();
				return ticketCanceled;
		}
	}
	
	// admitTicket() method: 
	public boolean admitTicket(int ticketId) {
		
		// Call findById() method from TicketBook class to 
		// find ticket in ticketBook given ticketId
		Ticket ticketToAdmit = this.ticketBook.findById(ticketId);
		
		// Check that ticketToAdmit is not null
		if(ticketToAdmit == null) {
			return false;
		}
		else {
			// if ticketId exists, call admit() method from Ticket class to
			// change 'admitted' state to true and return ticketAdmitted 
			boolean ticketAdmitted = ticketToAdmit.admit();
			return ticketAdmitted;
		}
	}
	
	// printAll() method: 
	public void printAll() {
		//Call printAll() method from TicketBook class to print all tickets in the ticketBook
		this.ticketBook.printAll();
	}
	
	// printForEvent() method():
	public void printForEvent(Event event) {
		// Call printForEvent() method from TicketBook class to print all tickets pertaining to an event
		this.ticketBook.printForEvent(event);
	}
}	
