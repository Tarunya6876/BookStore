package com.bookstoreapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreapi.Model.Inventory;
import com.bookstoreapi.Services.InventoryService;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/books/id/{bookId}")
    private Inventory getBookById(@PathVariable long bookId){
        return this.inventoryService.getBookById(bookId);
    }
    @GetMapping("/sortByLikes")
	private ResponseEntity<List<String>> sortByLikes(){
		return ResponseEntity.ok().body(this.inventoryService.sortByLikes());
	}

    @GetMapping("/books/name/{bookName}")
    private Inventory getBookByName(@PathVariable String bookName){
        return this.inventoryService.getBookByName(bookName);
    }

    @PostMapping("/books")
    private ResponseEntity<Inventory> addBook(@RequestBody Inventory inv){
        return ResponseEntity.ok().body(this.inventoryService.addBookInInventory(inv));
    }

}