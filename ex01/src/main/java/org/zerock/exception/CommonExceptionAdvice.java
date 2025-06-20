package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;
@Log4j
@ControllerAdvice  //평소엔 가만 있다가 서버에 문제 생기면 동작
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception........................." + ex.getMessage());
		
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handler404(NoHandlerFoundException ex) {
		
		return "custom404";
	}
}
