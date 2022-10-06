package com.paul.SimpleBlog.service;

import com.paul.SimpleBlog.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    Optional<Account> findOneByUserName(String username);
}
