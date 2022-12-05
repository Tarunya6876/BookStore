package com.bookstoreapi.Controller;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstoreapi.Model.User;
import com.bookstoreapi.Model.Wallet;
import com.bookstoreapi.Services.WalletService;
@RestController
public class WalletController{
    @Autowired
    private WalletService walletService;

    @GetMapping("/wallet/{userId}")
    private double getUserBalance(@PathVariable long userId){
        return this.walletService.checkBalance(userId);
    }
    @PostMapping("/wallet")
    private ResponseEntity<Wallet> saveUser(@RequestBody Wallet wal){
        return ResponseEntity.ok().body(this.walletService.createWal(wal));
    }
    @PutMapping("/wallet/add/{userId}")
    private ResponseEntity<Wallet> addMoneyInWallet(@PathVariable long userId, @RequestBody Wallet wallet){
        if(wallet.getWalletAmount() < 500)
            throw new NullPointerException();
        else
            return ResponseEntity.ok().body(this.walletService.addMoneyInWalletByAPi(userId,wallet.getWalletAmount()));
    }

    @PutMapping("/wallet/deduct/{userId}")
    private ResponseEntity<Wallet> deductMoneyInWallet(@PathVariable long userId, @RequestBody Wallet wallet){
        return ResponseEntity.ok().body(this.walletService.deductMoneyInWallet(userId,wallet.getWalletAmount()));
    }

}