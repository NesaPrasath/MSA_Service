package com.example.msa.Config.Details;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.msa.Model.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetail implements UserDetails{

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->"read");
    }

    @Override
    public String getPassword() {
        return user.getUPass();
    }

    @Override
    public String getUsername() {
        return user.getUName();
    }
    
    public Integer getUserid(){
        return user.getUId();
    }
}
