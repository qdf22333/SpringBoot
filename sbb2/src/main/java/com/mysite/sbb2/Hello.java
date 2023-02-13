package com.mysite.sbb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {		//리턴 : String
		
		
		return "Hello World - 실습";
		
		
	}

}
