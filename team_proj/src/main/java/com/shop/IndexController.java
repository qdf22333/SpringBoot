package com.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class IndexController {
	
	@ResponseBody
	@GetMapping("/")
	private String main() {
	
		return "index 페이지 입니다.";
		
	}
	
	@GetMapping("/detail")
	private String detail() {
		return "/itemDtl";
	}
	

	 

}
