package ua.helper.exceptions;

public class NewsServiceException extends RuntimeException{

	private static final long serialVersionUID = 4866286351299394270L;
	
	public NewsServiceException(String message) {
		super(message);
	}

}
