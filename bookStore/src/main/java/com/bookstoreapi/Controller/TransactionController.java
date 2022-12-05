package com.bookstoreapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstoreapi.Model.Transactions;
import com.bookstoreapi.Model.Wallet;
import com.bookstoreapi.Services.TransactionService;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    private ResponseEntity<List<Transactions>> getAllTransactions(){
        return ResponseEntity.ok().body(this.transactionService.getAllTransactions());
    }
    @PostMapping("/transac")
    private ResponseEntity<Transactions> saveUser(@RequestBody Transactions tran){
        return ResponseEntity.ok().body(this.transactionService.createTransaction(tran));
    }

    @GetMapping("/transactions/{userId}")
    private ResponseEntity<List<Transactions>> getAllTransactionsByUser(@PathVariable long userId){
        return ResponseEntity.ok().body(this.transactionService.getAllTransactionsOfUser(userId));
    }


}