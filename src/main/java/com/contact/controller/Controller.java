package com.contact.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Details;
import com.contact.service.UserService;


@RestController
@RequestMapping("/users")
public class Controller {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("")
	public List<Details> list()
	{
		return userService.listAllUser();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Details> get(@PathVariable Integer id) {
        try {
            Details user = userService.getUser(id);
            return new ResponseEntity<Details>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Details>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@PostMapping("/")
	public void add(@RequestBody Details user) {
        userService.saveUser(user);
    }
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Details user, @PathVariable Integer id) {
        try {
            Details existUser = userService.getUser(id);
            user.setId(id);            
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {

        userService.deleteUser(id);
    }
	
	
	
	
	
	
	

}
