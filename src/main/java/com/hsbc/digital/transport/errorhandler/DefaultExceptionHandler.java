package com.hsbc.digital.transport.errorhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {

		ErrorMessage error = new ErrorMessage(ex.getMessage(), "Server error");
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex) {
		ErrorMessage error = new ErrorMessage(ex.getMessage(), "Employee not found");
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage error = new ErrorMessage(ex.getMessage(), "Employee not found");
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

	class ErrorMessage {
		private String message;

		private String details;

		public ErrorMessage(String message, String details) {
			super();
			this.message = message;
			this.details = details;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

	}

}
