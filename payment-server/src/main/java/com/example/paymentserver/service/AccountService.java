package com.example.paymentserver.service;

import com.example.paymentserver.domain.Account;

import java.util.List;

public interface AccountService {
    void addNewUser(Account account);
    List<Account> getAllAccount();
    boolean deductBalance(Long userId, Integer balance);
}
