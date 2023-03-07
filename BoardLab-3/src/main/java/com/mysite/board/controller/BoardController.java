package com.mysite.board.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysite.board.Board;
import com.mysite.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		
		
		
		List<Board> boardList = this.boardService.getboardList();
		
		
		model.addAttribute("boardList",boardList);
		
		return "mainPage";
		
	}
	@PreAuthorize("isAuthenticated()")	//Spring Security에서 인증된 사용자만 접근
										//Spring Security Configuration 에서 
	@GetMapping("/board/write")
	public String mainPage(Board board) {
		return "boardWrite";
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/board/write")
	public String mainPage(Board board,Principal principal) {
		
		try {
			
			this.boardService.save(board, principal.getName());
			
		}catch(Exception e) {
			return "redirect:/board/write";
		}
		
		
		return "redirect:/";
	}
	
}
