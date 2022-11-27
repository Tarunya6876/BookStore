package com.bookStore.service;

import java.util.List;

import com.bookStore.model.User;

public interface UserService {
	
	User createUser(User usr);
	User updateUser(User usr);
	
	List<User> getUser();
	
	User getUserById(long userID);
	
    User suspendUser(User usr);

}
