package com.bookStore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookStore.model.User;
import com.bookStore.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User usr) {
	        return userRepository.save(usr);
	    }

	@Override
	public User updateUser(User usr) {
		Optional<User> usrObj = this.userRepository.findById((long) usr.getUserId());

        if(usrObj.isPresent()){
            User userUpdate = usrObj.get();
            userUpdate.setUserId(usr.getUserId());
            userUpdate.setUserName(usr.getUserName());
            userUpdate.setEmailId(usr.getEmailId());
            userUpdate.setUserContact(usr.getUserContact());
            userUpdate.setStatus(usr.getStatus());
            return this.userRepository.save(userUpdate);
        }
        else {
            throw new NullPointerException();
        }
	}

	@Override
	public List<User> getUser() {
		return this.userRepository.findAll();
	}
	
	
	public User suspendUser(User usr){
        Optional<User> userObj = this.userRepository.findById((long) usr.getUserId());

        if(userObj.isPresent()){
            User userUpdate = userObj.get();
            userUpdate.setUserId(usr.getUserId());
            userUpdate.setUserName(usr.getUserName());
            userUpdate.setEmailId(usr.getEmailId());
            userUpdate.setUserContact(usr.getUserContact());
            userUpdate.setStatus(1);
            return this.userRepository.save(userUpdate);
        }
        else {
            throw new NullPointerException();
        }
    }
	

	public User getUserById(long userID) {
		Optional<User> usrObj = this.userRepository.findById(userID);

        if(usrObj.isPresent()){
            return usrObj.get();
        }else{
            throw new NullPointerException();
        }
	}

			
}


