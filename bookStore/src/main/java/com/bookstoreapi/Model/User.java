package com.bookstoreapi.Model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

@Entity
@Table(name="User")
public class User {
	
	/*public User() {
	}*/
	
	
	/*public User(int userId, String userName, String emailId, int userContact, int status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.userContact = userContact;
		Status = status;
	}*/

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@NotNull
    private String userName;
	@NotNull
    private String emailId;
	@NotNull
    private int userContact;
	
	@Column(name="userStatus")
    private int Status;
	 @CreationTimestamp
	    private Date createdAt;

	    @UpdateTimestamp
	    private Date updatedAt;

	/*public User(int userId, String userName, String emailId, int userContact,int Status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.userContact = userContact;
		this.Status=Status;
	}*/
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getUserContact() {
		return userContact;
	}
	public void setUserContact(int userContact) {
		this.userContact = userContact;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + emailId + '\'' +
                ", userPhone='" + userContact + '\'' +
                ", isSuspended=" + Status +
                '}';
    }
	
}
