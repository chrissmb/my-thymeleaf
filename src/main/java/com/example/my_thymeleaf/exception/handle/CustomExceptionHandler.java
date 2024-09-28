package com.example.my_thymeleaf.exception.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.my_thymeleaf.exception.BusinessException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(BusinessException.class)
	public ModelAndView handle(BusinessException ex, HttpServletRequest request) {
		LOGGER.error(ex.getMessage(), ex);
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage", ex.getMessage());
		return modelAndView;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handle(Exception ex, HttpServletRequest request) {
		LOGGER.error(ex.getMessage(), ex);
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage", "Unknow error.");
		return modelAndView;
	}
}
