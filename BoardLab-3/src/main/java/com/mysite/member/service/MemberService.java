package com.mysite.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.constant.MemberRole;
import com.mysite.member.Member;
import com.mysite.member.dto.MemberFormDto;
import com.mysite.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	// 회원가입을 저장하는 메소드
	public void save(MemberFormDto memberFormDto) {
		
		Member member = new Member();
		
		member.setMName(memberFormDto.getMName());
		member.setMPassword(this.passwordEncoder.encode(memberFormDto.getMPassword()));
		member.setEmail(memberFormDto.getEmail());
		member.setAddr(memberFormDto.getAddr());
		
		this.memberRepository.save(member);
		
	}
	
	//로그인을 처리하는 메소드 
	//User : 
	
	@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		log.info(" Email 변수 값=====>" + email);
		
		System.out.println(email);	//콘솔에 정보를 출력함 : 개발 완료시는 제거함.
		
		Optional<Member> _Member=this.memberRepository.findByEmail(email);
		
		if(_Member.isEmpty()) {
			
			System.out.println("비어있음");
			throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
			
		}
		
		Member member = _Member.get();
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if("admin".equals(email)) {
			authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
		}else {
			authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));
		}
		
		// User 클래스 : Spring Security에 존재하는 클래스
		// User 를 Entity 클래스로 사용하면 여러가지 문제가 발생됨. Member를 사용. 
		
		//User 클래스는 3개의 항목이 반드시 매개변수로 적용되어야 한다. ID, Pass, Authorize(권한) 
		
		return new User(member.getEmail(),member.getMPassword(),authorities);
	}
	
}
