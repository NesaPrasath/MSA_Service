package com.example.msa.Config.Service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.msa.Config.Details.UserDetail;
import com.example.msa.Model.User;
import com.example.msa.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService{

    private UserRepository urepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=urepo.findByuName(username);
        return user.map(UserDetail::new).orElseThrow(()->new UsernameNotFoundException("UserName does not exists"));
    }
    
}
