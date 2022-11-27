package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
