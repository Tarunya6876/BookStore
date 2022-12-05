package com.bookstoreapi.Services;

import java.util.List;

import com.bookstoreapi.Model.User;

public interface UserService {
	
	User createUser(User usr);
	User updateUser(User usr);
	
	List<User> getUser();
	
	User getUserById(long userId);
	
    /*User suspendUser(User usr);*/

}
