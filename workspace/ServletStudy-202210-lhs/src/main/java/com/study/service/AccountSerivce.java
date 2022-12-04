package com.study.service;

import com.study.domain.User;
import com.study.repository.UserRepository;

public class AccountSerivce {
	private static AccountSerivce instance = null;

	
	private AccountSerivce() {}

	public static AccountSerivce getInstance() {
		if(instance==null) {
			instance = new AccountSerivce();
		}
		return instance;
	}

	public boolean duplicateUsername(String username) {
		User user = UserRepository.getInstance().findUserByUsername(username);
		
		return user !=null;
	}
	public void register(User user) {
		UserRepository.getInstance().saveUser(user);
	}
	public User loadUserByUsername(String username) {
		return UserRepository.getInstance().findUserByUsername(username);
	}
	public boolean checkPassword(User user ,String password) {
		return user.getPassword().equals(password);
	}
}
