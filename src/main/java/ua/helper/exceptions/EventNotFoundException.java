package ua.helper.exceptions;

public class EventNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1620698323114718366L;
	
	public EventNotFoundException(String message) {
		super(message);
	}

}
