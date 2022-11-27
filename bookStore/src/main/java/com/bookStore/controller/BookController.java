package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.model.Book;
import com.bookStore.service.BookService;
@RestController
public class BookController {
	
	@Autowired
    private BookService bookService;

    @GetMapping("/book")
    private ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok().body(this.bookService.getBooks());
    }

    @GetMapping("/book/{bookId}")
    private Book getBookById(@PathVariable int bookId){
        return this.bookService.getBookById(bookId);
    }

    @PostMapping("/book")
    private ResponseEntity<Book> addBook(@RequestBody Book book){
    	System.out.println("inside controller");
        return ResponseEntity.ok().body(this.bookService.addBook(book));
    }

    @PutMapping("/book/{bookId}")
    private ResponseEntity<Book> updateBook(@PathVariable int bookId, @RequestBody Book book){
        book.setBookId(bookId);
        return ResponseEntity.ok().body(this.bookService.updateBook(book));
    }

}
