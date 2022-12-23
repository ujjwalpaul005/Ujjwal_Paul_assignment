package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(EntryDataException.class)
	public ResponseEntity<ErrorTemplate> driverExceptionHandlr(EntryDataException ex, WebRequest req){
		ErrorTemplate myErr = new ErrorTemplate();
		
		myErr.setDateTime(LocalDateTime.now());
		myErr.setMessage(ex.getMessage());
		myErr.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorTemplate>(myErr, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorTemplate> methodArgumentNotValidExceptionHandlr(MethodArgumentNotValidException ex, WebRequest req){
		ErrorTemplate myErr = new ErrorTemplate();
		
		myErr.setDateTime(LocalDateTime.now());
		
		String error = "";
		int i = 1;
		for(ObjectError x: ex.getBindingResult().getAllErrors()){
			error += ( (i++) + " -> " + x.getDefaultMessage() + ";  ");
		}
		
		myErr.setMessage(error);
		myErr.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorTemplate>(myErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorTemplate> notFoundExceptionHandlr(NotFoundException ex, WebRequest req){
		ErrorTemplate myErr = new ErrorTemplate();
		
		myErr.setDateTime(LocalDateTime.now());
		myErr.setMessage(ex.getMessage());
		myErr.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorTemplate>(myErr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorTemplate> exceptionHandlr(Exception ex, WebRequest req){
		ErrorTemplate myErr = new ErrorTemplate();
		
		myErr.setDateTime(LocalDateTime.now());
		myErr.setMessage(ex.getMessage());
		myErr.setDescription(req.getDescription(false));
		
		return new ResponseEntity<ErrorTemplate>(myErr, HttpStatus.BAD_REQUEST);
	}
}

