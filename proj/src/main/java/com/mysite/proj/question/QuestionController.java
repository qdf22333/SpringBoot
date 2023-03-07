package com.mysite.proj.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysite.proj.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;
	
	 @GetMapping("/notice")
	    public String list(Model model) {
	        List<Question> questionList = this.questionService.getList();
	        model.addAttribute("questionList", questionList);
	        return "notice";
	    }
	 
	 @GetMapping(value = "/notice/detail/{id}")
	 public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		 Question question = this.questionService.getQuestion(id);
		 model.addAttribute("question", question);
		 return "notice_detail";
	 }
	 
	 @GetMapping("/question/create")
	 public String questionCreate(QuestionForm questionForm) {
		 return "question_form";
	 }
	 
	 //질문 저장 후 질문 목록으로 이동
	 @PostMapping("/question/create")
	 public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "question_form";
	        }
	        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		 return "redirect:/notice";
	 }

}
