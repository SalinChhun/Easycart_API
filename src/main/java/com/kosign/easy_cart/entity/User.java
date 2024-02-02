package com.kosign.easy_cart.entity;

import com.kosign.easy_cart.security.token.Token;
import com.kosign.easy_cart.security.user.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tb")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private LocalDateTime createdDate;

    private String phoneNumber;

    private String profilePhoto;

    private Boolean status;

    private String address;

    private String googleLink;

    private String mapLink;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Product> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Bookmark> bookmarks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Address> deliveryAddresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Purchase> purchases;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    List<Notification> notifications;

    private String pinCode;

    private LocalDateTime pinCodeGenerateTime;

    private Boolean isPinCodeEnable;


    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
}
