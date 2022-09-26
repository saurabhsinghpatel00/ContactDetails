package com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contact.entity.Details;
import com.contact.repo.Repo;


@Service
@Transactional
public class UserService {
	
	@Autowired
    private Repo userRepository;

	public List<Details> listAllUser() {
		return userRepository.findAll();
	}
	
	public Details getUser(Integer id) {
		return userRepository.findById(id).get();
	}

	public void saveUser(Details user) {
		userRepository.save(user);
		
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		
	}

}
