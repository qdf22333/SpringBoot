package com.mysite.sbb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		return "Test 코드 블락입니다. - MyWebSite - 추가된 내용입니다. - 추가 항목 입니다.";
	}

}
