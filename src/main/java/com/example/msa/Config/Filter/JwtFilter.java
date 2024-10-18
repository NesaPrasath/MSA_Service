package com.example.msa.Config.Filter;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.msa.Config.Authentication.JwtAuthentication;
import com.example.msa.Config.Service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter{


    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                final String authHeader=request.getHeader("Authorization");

                if(authHeader==null){
                    filterChain.doFilter(request, response);
                    return ;
                }
                try{
                    final String jwt=authHeader.substring(7);
                    final Integer uid=jwtService.extractUserId(jwt);
                    final String uname=jwtService.extractUserName(jwt);
                    Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
                    if(uid!=null&&authentication==null){
                        var auth_p=new JwtAuthentication(uname,uid,true);
                        SecurityContextHolder.getContext().setAuthentication(auth_p);
                    }
                    filterChain.doFilter(request, response);

                }catch(Exception e){
                    System.out.println(e);
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
    }
}
