package com.example.paymentserver.repository;

import com.example.paymentserver.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Optional<Account> findByUserId(Long userId);
}
