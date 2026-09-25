package ticketSystemPackage;

/*
Represents a type of ticket for an event.
Required data:
• String name (examples: "Student", "General", "VIP")
• double price (must not be negative)

Required invariants:
• name is not null or blank
• price >= 0

Required behavior:
• Constructor validates invariants (fail fast)
• Getters as needed
• toString() that prints the ticket type and price in a meaningful way
Design note: This is a strong candidate for an immutable class.
 */
public class TicketType {
	
	// Define class fields (name, price):
	private final String name; 
	private final double price; 
	
	// Class constructor with fail fast validation checking
	public TicketType(String name, double price) {
		// Validation checking
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException(); 
		}
		if(price < 0) {
			throw new IllegalArgumentException();
		}
		
		// Assign fields
		this.name = name; 
		this.price = price;
	}
	
	// Getter methods for name and price
	public String getName() {
		return this.name; 
	}
	
	public double getPrice() {
		return this.price;
	}
	
	// Override toString() method
	@Override 
	public String toString() {
		String description = "Ticket Type: " + this.name + ", Ticket Price: $" + this.price;
		return description;
	}
}
