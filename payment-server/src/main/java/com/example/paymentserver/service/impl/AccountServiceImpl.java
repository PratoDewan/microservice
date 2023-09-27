package com.example.paymentserver.service.impl;

import com.example.paymentserver.domain.Account;
import com.example.paymentserver.repository.AccountRepository;
import com.example.paymentserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void addNewUser(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public boolean deductBalance(Long userId,Integer balance) {
        Optional<Account> optionalAccount = accountRepository.findByUserId(userId);
        if(optionalAccount.isPresent()){
            Account account=optionalAccount.get();
            if(balance<account.getBalance()) {
                account.setBalance(account.getBalance() - balance);
                accountRepository.save(account);
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
