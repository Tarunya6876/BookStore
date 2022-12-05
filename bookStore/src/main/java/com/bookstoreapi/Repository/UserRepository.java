package com.bookstoreapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreapi.Model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
