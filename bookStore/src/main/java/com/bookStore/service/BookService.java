package com.bookStore.service;

import java.util.List;

import com.bookStore.model.Book;

public interface BookService {	
	Book addBook(Book bk);
	Book updateBook(Book bk);
	
	List<Book> getBooks();
		
	Book getBookById(int bookId);

}
