package com.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajax.dto.AjaxDTO;

@Controller
public class AjaxController {

	@GetMapping("/ex01")
	public String ex01() {

		System.out.println("AjaxController ex01요청 성공");

		return "index"; // index.html에 작성된 내용이 그대로 출력됨
		// <index.html>의 소스코드가 전송
	}

	@PostMapping("/ex02")
	public @ResponseBody String ex02() {

		System.out.println("AjaxController ex02요청 성공");

		return "안녕하세요"; // 리턴에 문자열을 그대로 전송하기 위해서는 @ResponsBody
	}

	@GetMapping("/ex03") // ajax에서 param1, param2를 넘겨준다.
	public @ResponseBody String ex03(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {

		System.out.println("AjaxController ex03요청 성공");
		System.out.println("param1 : " + param1 + ", param2 : " + param2);

		return "ex03 처리 완료"; // index.html에 작성된 내용이 그대로 출력됨
		// <index.html>의 소스코드가 전송
	}

	@PostMapping("/ex04") // ajax에서 param1, param2를 넘겨준다.
	public @ResponseBody String ex04(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {

		System.out.println("AjaxController ex04요청 성공");
		System.out.println("param1 : " + param1 + ", param2 : " + param2);

		return "ex04 처리 완료"; // index.html에 작성된 내용이 그대로 출력됨
		// <index.html>의 소스코드가 전송
	}

	@GetMapping("/ex05") // ajax에서 param1, param2를 넘겨준다.
							// @ModelAttribute : 클라이언트에서 넘긴 파라미터를 DTO에 저장 (생략)
							// 리턴을 DTO 객체를 return

	public @ResponseBody AjaxDTO ex05(@ModelAttribute AjaxDTO ajaxDTO) {

		System.out.println("AjaxController ex05요청 성공");
		System.out.println("ajaxDTO : " + ajaxDTO);

		// BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴

		return ajaxDTO;
	}

	@PostMapping("/ex06") // ajax에서 param1, param2를 넘겨준다.
	// @ModelAttribute : 클라이언트에서 넘긴 파라미터를 DTO에 저장 (생략)
	// 리턴을 DTO 객체를 return

	public @ResponseBody AjaxDTO ex06(@ModelAttribute AjaxDTO ajaxDTO) {

		System.out.println("AjaxController ex06요청 성공");
		System.out.println("ajaxDTO : " + ajaxDTO);

//BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴

		return ajaxDTO;
	}

	@PostMapping("/ex07") // ajax에서 param1, param2를 넘겨준다.
	// @RequestBody로 클라이언트에서 넘긴 파라미터가 JSON 형식이다라고 선언시 DTO에 저장 (생략)
	// 리턴을 DTO 객체를 return

	public @ResponseBody AjaxDTO ex07(@RequestBody AjaxDTO ajaxDTO) {

		System.out.println("AjaxController ex07요청 성공");
		System.out.println("ajaxDTO : " + ajaxDTO);

//BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴

		return ajaxDTO;
	}

	@PostMapping("/ex08") // ajax에서 param1, param2를 넘겨준다.
	// @RequestBody로 클라이언트에서 넘긴 파라미터가 JSON 형식이다라고 선언시 DTO에 저장 (생략)
	// 리턴을 List<DTO> 객체를 return

	public @ResponseBody List<AjaxDTO> ex08(@RequestBody AjaxDTO ajaxDTO) {

		System.out.println("AjaxController ex08요청 성공");
		System.out.println("ajaxDTO : " + ajaxDTO);

//BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴
		List<AjaxDTO> dtoList = new ArrayList();
		dtoList.add(ajaxDTO); // index 0
		dtoList.add(new AjaxDTO("data1", "data2"));
		dtoList.add(new AjaxDTO("data11", "data22"));

		return dtoList;
	}

	@PostMapping("/ex09") // ajax에서 param1, param2를 넘겨준다.
	// @RequestBody로 클라이언트에서 넘긴 파라미터가 JSON 형식이다라고 선언시 DTO에 저장 (생략)
	// 리턴을 List<DTO> 객체를 return : DATA + Http 상태코드를 리턴
	//		//클라이언트에서 좀 더 세밀한 컨트롤을 처리할 때 사용
	// @ResponsBody : 리턴되는 값이 String, Data(DTO), List<dto> <== Data만 전송

	
	public ResponseEntity ex09(@RequestBody AjaxDTO ajaxDTO) {

		System.out.println("AjaxController ex09요청 성공");
		System.out.println("ajaxDTO : " + ajaxDTO);

	//BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴	

		return new ResponseEntity<>(ajaxDTO, HttpStatus.OK);
		//return new ResponseEntity<>(ajaxDTO, HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/ex10") // ajax에서 param1, param2를 넘겨준다.
	// @RequestBody로 클라이언트에서 넘긴 파라미터가 JSON 형식이다라고 선언시 DTO에 저장 (생략)
	// 리턴을 List<DTO> 객체를 return : DATA + Http 상태코드를 리턴
	//		//클라이언트에서 좀 더 세밀한 컨트롤을 처리할 때 사용
	// @ResponsBody : 리턴되는 값이 String, Data(DTO), List<dto> <== Data만 전송

	
	public ResponseEntity ex10(@RequestBody AjaxDTO ajaxDTO) {

		System.out.println("AjaxController ex10요청 성공");
		System.out.println("ajaxDTO : " + ajaxDTO);

	//BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴
		List<AjaxDTO> dtoList = new ArrayList();
		dtoList.add(ajaxDTO); // index 0
		dtoList.add(new AjaxDTO("data1", "data2"));
		dtoList.add(new AjaxDTO("data11", "data22"));

		return new ResponseEntity<>(ajaxDTO, HttpStatus.OK);
		//return new ResponseEntity<>(ajaxDTO, HttpStatus.NOT_FOUND);
	}
	
	

}
