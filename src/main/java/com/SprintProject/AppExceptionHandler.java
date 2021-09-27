package com.SprintProject;



import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(value={IllegalArgumentException.class, NoSuchElementException.class, UsernameNotFoundException.class})
	 public ResponseEntity<Object> IAExceptionHandler(Exception ex, WebRequest request) {
		 String msg = "Error in operation " + ex.getMessage();
		 return handleExceptionInternal(ex, msg, new HttpHeaders(), 
				 HttpStatus.CONFLICT, request);

	 }
	 
	 @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Entity not found")
	 @ExceptionHandler(EntityNotFoundException.class)
	 public void SQLExceptionHandler(Exception ex) {
	  
	 }
	 @ExceptionHandler(HouseFullException.class)
	 public ResponseEntity<Object> HouseFullExceptionHandler(Exception ex, WebRequest request) {
		 String msg = "Sorry for Inconvience The Screen is HouseFull \uD83D\uDE15";
		 return handleExceptionInternal(ex, msg, new HttpHeaders(), 
				 HttpStatus.CONFLICT, request);
	 }
	 @Override
	 public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    List<String> errorList = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
	    System.out.println("In Exception ..." + errorList);
        return handleExceptionInternal(ex, errorList, headers, HttpStatus.BAD_REQUEST, request);
	 }

}
