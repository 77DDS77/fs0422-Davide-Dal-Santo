package Banca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApplicationError> NotFoundException(NotFoundException exception) {

		ApplicationError message = new ApplicationError(HttpStatus.NOT_FOUND, exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}

	@ExceptionHandler(NotAllowedException.class)
	public ResponseEntity<ApplicationError> NotAllowedException(NotAllowedException exception) {

		ApplicationError message = new ApplicationError(HttpStatus.UNAUTHORIZED, exception.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
	}
}
