package com.mysite.sbb2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor

public class HelloLombok {
	
	private final String hello;
	private int lombok;

	public static void main(String[] args) {
//		@RequiredArgsConstructor 테스트
		HelloLombok lombok = new HelloLombok("안녕하세요.실습중");
		
//		toString() 메소드 호출
		System.out.println(lombok);
		
		

	

	}

}
