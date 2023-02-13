package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	//JPA에서 Question 테이블을 Select, Insert, update, delete
	//JPA의 CRUD 메소드 :
		// save() : Insert, Update, Delete
		// findAll()
		// findById
		// 정의해서 사용 :  findBySubject() ...
	
	
	// Question 테이블을 SQL 쿼리를 사용하지 않고 JPA 메소드를 사용해서  CRUD 하는 Repository 
		//JpaRepository<Question, Integer>
				//Question : JPA 메소드에서 쿼리할 엔티티 클래스 
				//Integer : 엔티티 클래스의 Primary Key 컬럼의 데이터 타입
	
	//하나의 컬럼을 조건으로 처리된 값 가져오기
	//	findById() : Question 테이블의 Primary Key 컬럼이므로 기본 제공됨
	
	//select * from question where subject = ?		검색 결과가 1개일 때 처리
	Question findBySubject(String subject);
	//select * from question where content = ?		검색 결과가 1개일 때 처리
	Question findByContent(String content);
	
	//select * from question where subject like '%sbb%'
	List<Question> findBySubjectLike(String subject);
	
	//content 컬럼을 조건으로 검색
	//select * from question where content like '%내용%'
	List<Question> findByContentLike(String content);
	
	//select * from question where subject like '%sbb%' and content like '%내용%'	
	List<Question> findBySubjectOrContentLike(String subject, String content);
	
	//조건을 사용해서 출력후 정렬해서 출력 : Order By
	//select * from question order by createDate asc	:오름차순 정렬
	//select * from question order by createDate desc	:내림차순 정렬
	List<Question> findBySubjectLikeOrderByCreateDateAsc(String subject);
	List<Question> findBySubjectLikeOrderByCreateDateDesc(String subject);
	
	//모든 레코드를 정렬해서 출력
	//select * from question order by create_date asc
	//select * from question order by create_date desc
	List<Question> findAllByOrderByCreateDateAsc();
	List<Question> findAllByOrderByCreateDateDesc();
	
	
	//Update : save()
	
	
	
	//Delete : save()
	

	
}