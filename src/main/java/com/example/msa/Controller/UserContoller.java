package com.example.msa.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msa.Model.FrndRequest;
import com.example.msa.Service.UserService;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(path = "/user")
public class UserContoller {
    @Autowired
    private UserService u_service;

    // @Autowired
    // private Fr

    // @GetMapping("/{id}")
    // public Map<String,String> getUser(@PathVariable Integer id) {

    //     return u_service.getUser(id);
    // }

    // @PostMapping("/")
    // public String createUser(@RequestBody User entity) {
    //     //TODO: process POST request
    //     User Status=u_service.createUser(entity);

    //     if(Status.getUId()!=null)
    //     {
    //         return "success";
    //     }
    //     else{
    //         return "Error";
    //     }
    // }

    // @PostMapping("/login")
    // public User chckUser(@RequestBody Map<String,Object> entity) {
    //     //TODO: process POST request]
    //     List<User> ul=u_service.chckUser((String)entity.get("user"), (String)entity.get("password"));
    //     System.out.println(ul.size());
    //     System.out.println(ul);
    //     return ul.get(0);
    // }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id){
        return u_service.deleteUSer(id);
    }

    @PostMapping("/frndreq")
    public FrndRequest addFrndRequest(@RequestBody FrndRequest entity) {
        //TODO: process POST request
        u_service.addFrndRequest(entity);
        return entity;
    }

    @GetMapping("/{id}/frndreq")
    public List<Map<String,String>> getFrndRequest(@PathVariable Integer id) {
        return u_service.getFrndRequest(id);
        // return new String();
    }
    
    
}
