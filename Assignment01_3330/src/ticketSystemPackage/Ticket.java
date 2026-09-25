package ticketSystemPackage;

/*
Represents one ticket issued to one student for one event.

Required data:
• int id (must be positive)
• Event event
• TicketType ticketType
• String studentName (not null or blank)
• boolean canceled
• boolean admitted

Required invariants:
• id > 0
• event and ticketType are not null
• studentName is not null or blank
• A ticket cannot be both canceled and admitted at the same time

Required behavior:
• Constructor validates invariants (fail fast)
• cancel() attempts to cancel the ticket according to your state rules
• admit() attempts to admit the ticket holder according to your state rules
• Methods that answer questions such as isCanceled(), isAdmitted(), or isActive() are
encouraged
• toString() prints a useful line including id, student, event, ticket type, and status

Testing/design requirement: Avoid unnecessary void methods. If an operation can return a
meaningful result that makes the behavior easier to test, return that result. For example, cancel()
or admit() may return boolean to indicate success or failure. Printing methods may be void.

Open design choice: Decide what should happen if someone tries to admit a canceled ticket,
cancel an admitted ticket, admit a ticket twice, or cancel a ticket twice. Pick clear rules and enforce
them consistently.
 */

public class Ticket {
	
	// Define class fields (id, event, ticketType, studentName, canceled, admitted):
	private final int id; 
	private final Event event; 
	private final TicketType ticketType; 
	private final String studentName; 
	private boolean canceled = false; 
	private boolean admitted = false; 
	
	// Class constructor with fail fast validation checking
	public Ticket(int id, Event event, TicketType ticketType, String studentName) {
		// Validation checking
		if(id <= 0) {
			throw new IllegalArgumentException(); 
		}
		if(event == null) {
			throw new IllegalArgumentException();
		}
		if(ticketType == null) {
			throw new IllegalArgumentException();
		}
		if(studentName == null || studentName.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		// Field assignment
		this.id = id; 
		this.event = event; 
		this.ticketType = ticketType; 
		this.studentName = studentName; 
		
	}
	
	// Methods for canceling and admitting tickets
		// Ticket admission: 
	public boolean admit() {
		// Check if ticket has already been canceled or admitted
		if(this.canceled == true) {
			System.out.println("ERROR: Ticket has been canceled.");
			return false;
		}
		if(this.admitted == true) {
			System.out.println("ERROR: Ticket has already been admitted.");
			return false;
		}
		
		// If validation passes, admit ticket and return true
		this.admitted = true; 
		return true; 
	}
	
		// Ticket Cancellation: 
	public boolean cancel() {
		// Check if ticket has already been canceled or admitted
		if(this.canceled == true) {
			System.out.println("ERROR: Ticket has already been canceled.");
			return false;
		}
		if(this.admitted == true) {
			System.out.println("ERROR: Ticket has already been admitted.");
			return false;
		}
		
		// If validation passes, cancel ticket and return true
		this.canceled = true; 
		return true; 
	}
	
	// isCanceled and isAdmitted methods to check the status of a ticket
		// isCanceled() method
	public boolean isCanceled() {
		// Return the boolean status of this.canceled
		return this.canceled; 
	}
	
		// isAdmitted method()
	public boolean isAdmitted() {
		// Return the boolean status of this.admitted
		return this.admitted; 
	}
	
	// Override toString() method
	@Override 
	public String toString() {
		String description = "ID: " + this.id + 
				"\nEvent: " + this.event + 
				"\nTicket Type: " + this.ticketType + 
				"\nStudent Name: " + this.studentName + 
				"\nCanceled: " + this.canceled + 
				"\nAdmitted: " + this.admitted;
		return description; 
	}
	
	// Getter for event to help TicketBook
	public Event getEvent() {
		return this.event;
	}
	
	// Getter for id to help TicketBook
	public int getID() {
		return this.id;
	}
}
