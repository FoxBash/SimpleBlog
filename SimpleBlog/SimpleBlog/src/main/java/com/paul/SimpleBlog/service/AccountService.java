package com.paul.SimpleBlog.service;

import com.paul.SimpleBlog.model.Account;
import com.paul.SimpleBlog.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Authority authority;

    public Account save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return repo.save(account);
    }

    public Optional<Account> findByUserName(String username) {
        return repo.findOneByUserName(username);
    }
}
