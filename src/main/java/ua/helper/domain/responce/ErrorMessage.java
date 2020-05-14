package ua.helper.domain.responce;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

public class ErrorMessage {
	   private String message;
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private LocalDateTime timestamp;

	    public ErrorMessage(String message) {
	        this.message = message;
	        this.timestamp = LocalDateTime.now();
	    }

}
