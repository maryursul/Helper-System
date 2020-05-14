package ua.helper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import ua.helper.domain.responce.ErrorMessage;

@ControllerAdvice
public class ServerExceptionHandler {
	
	  @ExceptionHandler(value = Exception.class)
	    public ResponseEntity<ErrorMessage> handlerExceptions(Exception ex , WebRequest req ){
	        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
	        return new ResponseEntity<>(errorMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  @ExceptionHandler(value = EventNotFoundException.class)
	  public ResponseEntity<ErrorMessage> handlerEventExceptions(Exception ex , WebRequest req){
		  ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		  return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	  }
	  @ExceptionHandler(value = EventsServiceException.class)
	  public ResponseEntity<ErrorMessage> handlerEventsServiceException(Exception ex , WebRequest req){
		  ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		  return new ResponseEntity<ErrorMessage>(errorMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  @ExceptionHandler(value = NewsServiceException.class)
	  public ResponseEntity<ErrorMessage> handlerNewsServiceException(Exception ex , WebRequest req){
		  ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		  return new ResponseEntity<ErrorMessage>(errorMessage , HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  @ExceptionHandler(value = UserServiceException.class)
	  public ResponseEntity<ErrorMessage> handlerUserServiceException(Exception ex , WebRequest req){
		  ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());
		  return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  

}
