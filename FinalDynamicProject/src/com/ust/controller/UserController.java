package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IUserDao;
import com.ust.model.User;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private IUserDao dao;
	
	@RequestMapping(value="/userdetails",method = RequestMethod.GET)
	public List getUserDetails(){
		List list;
		System.out.println("Getting the details");
		list = dao.getAllDetails();
		return list;
	}
	
	@RequestMapping(value="/searchByName/{searchstring}",method = RequestMethod.GET)
	public User getUserDetails(@PathVariable("searchstring")String searchString){
		
		System.out.println("Getting single user details");
		User user= (User)dao.searchUserDetails(searchString);
		return user;
		
	}
	@RequestMapping(value="/searchById/{uId}",method = RequestMethod.GET)
	public User getUserByID(@PathVariable("uId")int uId ){
		
		System.out.println("Getting single user details");
		User user= (User)dao.getUserById(uId);
		return user;
	}
	@RequestMapping(value="/insertuser",method = RequestMethod.POST)
	public void insertDetails(@RequestBody User user){
			dao.insertUserDetails(user);
	}
	
	@RequestMapping(value="/updateuser",method = RequestMethod.PUT)
	public void updateDetails(@RequestBody User user){
			dao.updateUserDetails(user);
	}

}
