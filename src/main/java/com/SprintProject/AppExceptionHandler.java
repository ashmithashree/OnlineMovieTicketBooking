package com.SprintProject;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(value= {IllegalArgumentException.class,NoSuchElementException.class,EntityNotFoundException.class,DataIntegrityViolationException.class})
public ResponseEntity<Object> IAExceptionHandler(Exception ex,WebRequest request)
{
	String msg="Error in operation \uD83E\uDD2A " +ex.getMessage();
	return handleExceptionInternal(ex, msg,new HttpHeaders(),
			HttpStatus.CONFLICT,request);
}
@Override
public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders header,HttpStatus status,WebRequest request)
{
	List<String> errorList= ex.getBindingResult().getFieldErrors().stream().map(fieldError->fieldError.getDefaultMessage()).collect(Collectors.toList());
	System.out.println("In Exception.........\uD83E\uDD2A "+errorList);
	return handleExceptionInternal(ex,errorList,header,HttpStatus.BAD_REQUEST,request);
}
}