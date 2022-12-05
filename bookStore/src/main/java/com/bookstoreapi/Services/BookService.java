package com.bookstoreapi.Services;

import java.util.List;

import com.bookstoreapi.Model.Book;

public interface BookService {
	Book addBook(Book bk);
	Book updateBook(Book bk);
	
	List<Book> getBooks();
		
	Book getBookById(int bookId);
	
	

}
