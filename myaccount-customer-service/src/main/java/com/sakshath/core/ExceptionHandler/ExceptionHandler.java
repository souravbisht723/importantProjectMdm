package com.sakshath.core.ExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sakshath.core.Exception.CustomerInfoException;
import com.sakshath.core.Exception.DataNotFoundException;
import com.sakshath.core.Exception.FormValidationException;
import com.sakshath.core.Exception.InvalidAuthenticationException;
import com.sakshath.core.response.Response;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@org.springframework.web.bind.annotation.ExceptionHandler(FormValidationException.class)
	public final ResponseEntity<Response<?>> handleFormValidationException(FormValidationException ex,
			WebRequest request) {
		logger.error(">>>>>>>>>>>>>>>Inside FormValidationException : " + ex.getMessage());
		logger.error(">>>>>>>>>>>>>>>Inside FormValidationException : ", ex);
		return new ResponseEntity<>(ex.getResponse(), HttpStatus.OK);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<Response> handleDataNotFoundException(DataNotFoundException ex, WebRequest request) {
		logger.error(">>>>>>>>>>>>>>>Inside DataNotFoundException : " + ex.getMessage());
		logger.error(" ", ex);
		return new ResponseEntity<>(ex.getResponse(), HttpStatus.OK);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidAuthenticationException.class)
	public final ResponseEntity<Response> handleInvalidAuthenticationException(InvalidAuthenticationException ex,
			WebRequest request) {
		logger.error(">>>>>>>>>>>>>>>Inside InvalidAuthenticationException : " + ex.getMessage());
		logger.error(" ", ex);
		return new ResponseEntity<>(ex.getResponse(), HttpStatus.OK);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(CustomerInfoException.class)
	public final ResponseEntity<Response> handleCustomerInfoException(CustomerInfoException ex, WebRequest request) {
		logger.error(">>>>>>>>>>>>>>>Inside CustomerInfoException : " + ex.getMessage());
		logger.error(" ", ex);
		return new ResponseEntity<>(ex.getResponse(), HttpStatus.OK);
	}
}