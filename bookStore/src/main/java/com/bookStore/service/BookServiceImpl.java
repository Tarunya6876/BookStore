package com.bookStore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.model.Book;
import com.bookStore.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book bk) {
		System.out.println("inside service");
		return bookRepository.save(bk);
	}

	@Override
	public Book updateBook(Book bk) {
		Optional<Book> bookObj = this.bookRepository.findById(bk.getBookId());

        if(bookObj.isPresent()){
            Book bookUpdate = bookObj.get();
            bookUpdate.setBookId(bk.getBookId());
            bookUpdate.setBookName(bk.getBookName());
            bookUpdate.setAuthor(bk.getAuthor());
            bookUpdate.setCategory(bk.getCategory());
            bookUpdate.setPrice(bk.getPrice());
            return this.bookRepository.save(bookUpdate);
        }
        else {
            throw new NullPointerException();
        }
	}

	@Override
	public List<Book> getBooks() {
		return this.bookRepository.findAll();
	};

	@Override
	public Book getBookById(int bookId) {
		
		 Optional<Book> bookObj = this.bookRepository.findById(bookId);

	        if(bookObj.isPresent()){
	            return bookObj.get();
	        }else{
	            throw new NullPointerException();
	        }
	}


}
