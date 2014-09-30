package org.sample.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.model.User;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {
    
	@Autowired    UserDao userDao;
	@Transactional
	public User getUser(Long userId) throws InvalidUserException {
		User user = null;
		try{
		user = userDao.findOne(userId);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return user;
	}
	@Transactional
	public List<User> getAllUser(){
		List<User> allUser = new ArrayList<User>();
		System.out.println(userDao.count());
		for(User u : userDao.findAll()){
			allUser.add(u);
		}
		
		return allUser;
	}
}
