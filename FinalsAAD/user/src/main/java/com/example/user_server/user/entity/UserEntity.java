package com.example.user_server.user.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
@Entity
public class UserEntity implements UserDetails ,SuperEntity{

    private String userRole;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String name;

    private String userName;

    private String userPassword;

    private String userNIC;

    private String userNICImageLocation;

    private int userAge;
    @Enumerated(EnumType.STRING)

    private GENDER gender;

    private String userEmail;

    private String userPhone;

    private String userAddress;

    private String remarks;

    private String userImageLocation;

    private boolean isAuthenticated;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> packageDetailsIDList;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> paymentsIDList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
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
