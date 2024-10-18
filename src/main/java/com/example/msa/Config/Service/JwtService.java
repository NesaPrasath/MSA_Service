package com.example.msa.Config.Service;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.msa.Config.Details.UserDetail;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    
    @Value("${security.jwt.secret-key}")
    private String secretkey;

    public Integer extractUserId(String token){
        return (Integer)extractClaims(token).get("id");
    }

    public String extractUserName(String token){
        return extractClaims(token).getSubject();
    }

    public String generateToken(UserDetail loguser){
        return buildToken(loguser.getUserid(), loguser.getUsername());
    }

    private String buildToken(Integer id,String UserName){
        return Jwts
        .builder()
        .claim("id", id)
        .setSubject(UserName)
        .signWith(getSignInKey(),SignatureAlgorithm.HS256)
        .compact();
    }

    public Boolean validToken(String token){
        extractClaims(token).getSubject();
        return true;
    }

    private Claims extractClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }

    public Key getSignInKey(){
        byte[] keybyte=Decoders.BASE64.decode(secretkey);
        return Keys.hmacShaKeyFor(keybyte);
    }
}
