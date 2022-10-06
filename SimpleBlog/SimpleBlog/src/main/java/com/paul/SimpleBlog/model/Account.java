package com.paul.SimpleBlog.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_authority",joinColumns = {@JoinColumn(name = "account_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", posts=" + posts +
                ", authority=" + authorities +
                '}';
    }
}
