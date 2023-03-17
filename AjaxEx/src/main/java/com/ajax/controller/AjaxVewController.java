package com.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxVewController {

	@GetMapping("/ajax-ex-01")
	public String ajaxex01 () {
		
		return "ajax-ex-01";
	}
	
	@GetMapping("/ajax-ex-02")
	public String ajaxex02 () {
		
		return "ajax-ex-02";
	}
	
	@GetMapping("/ajax-ex-03")
	public String ajaxex03 () {
		
		return "ajax-ex-03";
	}
	
	@GetMapping("/ajax-ex-04")
	public String ajaxex04 () {
		
		return "ajax-ex-04";
	}
	
	@GetMapping("/ajax-ex-05")
	public String ajaxex05 () {
		
		return "ajax-ex-05";
	}
	
	@GetMapping("/ajax-ex-06")
	public String ajaxex06 () {
		
		return "ajax-ex-06";
	}
	
	@GetMapping("/ajax-ex-07")
	public String ajaxex07 () {
		
		return "ajax-ex-07";
	}
	
	@GetMapping("/ajax-ex-08")
	public String ajaxex08 () {
		
		return "ajax-ex-08";
	}
	
	@GetMapping("/ajax-ex-09")
	public String ajaxex09 () {
		
		return "ajax-ex-09";
	}
	
	@GetMapping("/ajax-ex-10")
	public String ajaxex10 () {
		
		return "ajax-ex-10";
	}
	
	@GetMapping("/ajax-lab")
	public String ajaxLab () {
		
		return "ajax_lab";
	}
			
}
