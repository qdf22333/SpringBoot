package com.mysite.proj.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.proj.DataNotFoundException;
import com.mysite.proj.question.Question;
import com.mysite.proj.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	
	
	public void create(Question question, String content, SiteUser author) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		this.answerRepository.save(answer);
	
		
		
	}
	
	
	//답변 수정
	   public Answer getAnswer(Integer id) {
	        Optional<Answer> answer = this.answerRepository.findById(id);
	        if (answer.isPresent()) {
	            return answer.get();
	        } else {
	            throw new DataNotFoundException("answer not found");
	        }
	    }

	    public void modify(Answer answer, String content) {
	        answer.setContent(content);
	      
	        this.answerRepository.save(answer);
	    }
	    
	    //답변 삭제
	    public void delete(Answer answer) {
	        this.answerRepository.delete(answer);
	    }
	    
	    //답변 추천
	    public void vote(Answer answer, SiteUser siteUser) {
	        answer.getVoter().add(siteUser);
	        this.answerRepository.save(answer);
	    }
	
}