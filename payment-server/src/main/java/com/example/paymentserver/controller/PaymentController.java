package com.example.paymentserver.controller;

import com.example.paymentserver.domain.Account;
import com.example.paymentserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    public AccountService accountService;
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addNewCustomer(@RequestBody Account account){
        accountService.addNewUser(account);
        return new ResponseEntity<>("Successfully Inserted", HttpStatus.OK);
    }
    @PutMapping("/update/{userId}/{cost}")
    public ResponseEntity<Boolean> updateBalance(@PathVariable Long userId, @PathVariable Integer cost){
        return new ResponseEntity<>(accountService.deductBalance(userId,cost),HttpStatus.OK);
    }
}
