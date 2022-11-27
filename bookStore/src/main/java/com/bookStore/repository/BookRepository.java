package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
