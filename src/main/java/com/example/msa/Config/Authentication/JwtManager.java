package com.example.msa.Config.Authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class JwtManager implements AuthenticationManager{

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        if("JwtProvider".equals(authentication.getName())){
            return new JwtProvider().authenticate(authentication);
        }
        return authentication;
    }
    
}
