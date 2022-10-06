package com.paul.SimpleBlog.service;

import com.paul.SimpleBlog.model.Account;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private AccountService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = service.findByUserName(username);
        if (!optionalAccount.isPresent()){
            throw new UsernameNotFoundException("Account not found");
        }


     Account account = optionalAccount.get();
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
            }
            @Override
            public String getPassword() {
                return account.getPassword();
            }

            @Override
            public String getUsername() {
                return account.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }


}
