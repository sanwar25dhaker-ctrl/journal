package com.example.journal.Service;

import com.example.journal.Entity.Account;
import com.example.journal.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    // Open Account
    public Account openAccount(Account account) {
        return repo.save(account);
    }

    // View All Accounts
    public List<Account> getAllAccounts() {
        return repo.findAll();
    }

    // Check Balance
    public Double getBalance(Long accountNo) {
        Account acc = repo.findById(accountNo)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return acc.getBalance();
    }
}
