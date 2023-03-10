package com.mysite.sbb2;

import java.time.LocalDateTime;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb2.users.Users;
import com.mysite.sbb2.users.UsersRepository;


@SpringBootTest
class Sbb2ApplicationTests {

	@Autowired    //객체 자동 주입 , JPA의 CRUD할수 있는 메소드가 적용되어 있음. 
	private UsersRepository usersRepository;

	/* Question 테이블에 for 문을 사용해서 더미값 1000개 insert */
	@Test
	public void insert1000() {
		Users u = null;
		
		//for문을 사용해서 레코드 1000개 insert 
		for (int i = 1; i<=1000; i++) {
			u = new Users();
			u.setName("박예림 - " + i);
			u.setPass("pass1");
			u.setEmail("aaa@naver.com - " + i);
			u.setCreateDate(LocalDateTime.now());
			u.setCnt(null);
			
			this.usersRepository.save(u);
		}
		
	}
	
	
	
	
	/* Insert JUnit Test  , JPA 인터페이스에 정의 된 save() 
	@Test
	void contextLoads() {
		Users u1 = new Users(); 
		u1.setName("예림");
		u1.setPass("1234");
		u1.setEmail("aaa@hanmail.net");
		u1.setCreateDate(LocalDateTime.now());   // 현재 시간을 setter에 저장 
		this.usersRepository.save(u1);  	//첫번째 질문 저장 
		
		Users u2 = new Users(); 
		u2.setName("예림2");
		u2.setPass("12345");
		u2.setEmail("bbb@hanmail.net");
		u2.setCreateDate(LocalDateTime.now());   // 현재 시간을 setter에 저장 
		this.usersRepository.save(u2);  	//첫번째 질문 저장 
		
		Users u3 = new Users(); 
		u3.setName("예림3");
		u3.setPass("123456");
		u3.setEmail("ccc@hanmail.net");
		u3.setCreateDate(LocalDateTime.now());   // 현재 시간을 setter에 저장 
		this.usersRepository.save(u3);  	//첫번째 질문 저장
		
		Users u4 = new Users(); 
		u4.setName("예림4");
		u4.setPass("1234567");
		u4.setEmail("ddd@hanmail.net");
		u4.setCreateDate(LocalDateTime.now());   // 현재 시간을 setter에 저장 
		this.usersRepository.save(u4);  	//첫번째 질문 저장 
		
		Users u5 = new Users(); 
		u5.setName("예림5");
		u5.setPass("12345678");
		u5.setEmail("eee@hanmail.net");
		u5.setCreateDate(LocalDateTime.now());   // 현재 시간을 setter에 저장 
		this.usersRepository.save(u5);  	//첫번째 질문 저장 
				
	}
	
	*/
	
}