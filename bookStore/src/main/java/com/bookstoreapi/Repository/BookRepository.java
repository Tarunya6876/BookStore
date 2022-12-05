package com.bookstoreapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstoreapi.Model.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
