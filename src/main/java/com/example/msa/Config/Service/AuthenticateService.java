package com.example.msa.Config.Service;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.msa.Config.Details.LoginDetail;
import com.example.msa.Config.Details.UserDetail;
import com.example.msa.Model.User;
import com.example.msa.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticateService {
    private final UserRepository urepo;

    private final PasswordEncoder passencoder;

    private final AuthenticationManager authManager;

    public User signup(User reguser){
        reguser.setUPass(passencoder.encode(reguser.getUPass()));
        return urepo.save(reguser);
    }

    public UserDetail authenticate(LoginDetail logdetail){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(logdetail.getUserName(), logdetail.getUserPass()));
        Optional<User> usr=urepo.findByuName(logdetail.getUserName());
        return usr.map(UserDetail::new).orElseThrow(()->new UsernameNotFoundException("UserName does not exists"));
    }
}
