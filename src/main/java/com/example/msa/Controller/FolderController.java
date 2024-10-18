package com.example.msa.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msa.Model.Folder;
import com.example.msa.Model.User;
import com.example.msa.Service.FolderService;
import com.example.msa.Service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path="/folder/")
public class FolderController {

    @Autowired
    FolderService f_service;

    @Autowired
    UserService u_service;

    // @GetMapping("")
    // public String getAllFiles(@RequestParam String param) {
    //     return new String();
    // }
    
    @PostMapping("/")
    public Folder createFolder(@RequestBody Folder entity) {
        //TODO: process POST request
        Optional<User> c_user=u_service.getUser((Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        entity.setUser(c_user.get());
        Folder res=f_service.createFolder(entity);
        return res;
    }

    @GetMapping("/{id}")
    public Folder getFolder(@PathVariable Integer id) {
        return f_service.getFolder(id);
    }
    
    @GetMapping("/all/{id}")
    public List<Folder> getChildFolder(@PathVariable Integer id){
        Optional<User> c_user=u_service.getUser((Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return f_service.findByUserandFParentId(c_user.get(),id);
    }

    @GetMapping("/home")
    public List<Folder> getAllHomeFolder(){
        Optional<User> c_user=u_service.getUser((Integer)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return f_service.findByUserHome(c_user.get());
    }
}
