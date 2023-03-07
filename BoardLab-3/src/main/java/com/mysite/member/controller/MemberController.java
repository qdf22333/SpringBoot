package com.mysite.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.member.dto.MemberFormDto;
import com.mysite.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "memberLogin";
	}
	
	@GetMapping("/inroll")
	public String inroll( MemberFormDto memberFormDto ) {
		return "memberInroll";
	}
	
	@PostMapping("/inroll")
	public String inroll(Model model, @Valid MemberFormDto memberFormDto,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "memberInroll";
		}
		
		if(!memberFormDto.getMPassword().equals(memberFormDto.getMPasswordConf())) {
			bindingResult.rejectValue("mPasswordConf", "notSamePass","비밀번호가 일치하지 않습니다.");
			return "memberInroll";
		}
		
		try {
			
			this.memberService.save(memberFormDto);
			
		}catch(Exception e) {
			model.addAttribute("save_error", "아이디 혹은 이메일 중복.");
			return "memberInroll";
		}
		
		return "redirect:/";
	}
	
	
}
