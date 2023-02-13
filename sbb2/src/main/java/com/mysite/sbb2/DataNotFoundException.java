package com.mysite.sbb2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "요청한 레코드를 찾지 못했습니다.")
public class DataNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException (String message) {
		super(message);
	}

}
