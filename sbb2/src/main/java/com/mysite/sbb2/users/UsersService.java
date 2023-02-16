package com.mysite.sbb2.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

	private final UsersRepository usersRepository;
	
	/*
	public List<Users> getList(){
		return this.usersRepository.findAll();
	}
	*/
	
	public Page<Users> getList(int page){
		
		 List<Sort.Order> sorts = new ArrayList();
		 sorts.add(Sort.Order.desc("createDate"));
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return this.usersRepository.findAll(pageable);
	}
	
	public Users getUsers(Integer idx) {
		
		Optional<Users> op = this.usersRepository.findById(idx);
		
		if (op.isPresent()) {
			return op.get();
		}else {
			throw new DataNotFoundException("요청한 파일을 찾지 못했습니다.");
		}
		
		
	}
	
	public void create(String name, String pass, String email) {
		Users u = new Users();
		u.setName(name);
		u.setPass(pass);
		u.setEmail(email);
		
		this.usersRepository.save(u);
	
	}
	
	
}
