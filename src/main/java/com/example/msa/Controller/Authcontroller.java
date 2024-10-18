package com.example.msa.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msa.Config.Details.LoginDetail;
import com.example.msa.Config.Details.UserDetail;
import com.example.msa.Config.Service.AuthenticateService;
import com.example.msa.Config.Service.JwtService;
import com.example.msa.Model.User;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class Authcontroller {
    
    @Autowired
    private final AuthenticateService authService;

    @Autowired
    private final JwtService jwtService;
    
    @PostMapping("/signup")
    public User Signup(@RequestBody Map<String,String> user){
        User reguser=new User();
        reguser.setUName(user.get("uname"));
        reguser.setUPass(user.get("upass"));
        reguser.setUMail(user.get("email"));
        return authService.signup(reguser);
    }

    @PostMapping("/login")
    public Map<String,String> Login(@RequestBody LoginDetail logdet) {
        Map<String,String> res=new HashMap<>();
        UserDetail loguser=authService.authenticate(logdet);
        res.put("status", "Ok");
        res.put("token", jwtService.generateToken(loguser));
        return res;
    }
    

}
