package ticketSystemPackage;

/*
Represents one campus event.

Required data:
• String name (example: "Cybersecurity Guest Lecture")
• String location (example: "Engineering Building")

Required invariants:
• name is not null or blank
• location is not null or blank

Required behavior:
• Constructor enforces invariants (fail fast)
• Getters as needed (use intentionally)
• A toString() that prints a meaningful description, for example: Cybersecurity Guest Lecture @ Engineering Building

Design note: Consider making Event immutable.
*/

public class Event {

	//Define class variables w/ immutability
	private final String name; 
	private final String location; 

	//Class constructor
	public Event(String name, String location) {

		//Check invariants
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Event Name cannot be null"); 
		}
		if(location == null || location.isBlank()) {
			throw new IllegalArgumentException("Event Location cannot be null");
		}
		
		//Fill variables
		this.name = name; 
		this.location = location;
		
	}
	
	//Override toString
	@Override 
	public String toString() {
		return this.name + " @ " + this.location;
	}
	
	//Getters
	public String getName() {
		return this.name; 
	}
	
	public String getLocation() {
		return this.location;
	}
		
}
