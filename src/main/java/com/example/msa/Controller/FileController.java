package com.example.msa.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msa.Model.File;
import com.example.msa.Service.FileService;
import com.example.msa.Service.FolderService;
import com.example.msa.Service.UserService;
import com.example.msa.common.FileHandling;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/file")
public class FileController {
    
    @Autowired
    FileService fl_Service;

    @Autowired
    FileHandling handlefile;

    @Autowired
    FolderService f_Service;

    @Autowired 
    UserService u_Service;

    @PostMapping("/")
    public String createFile(@RequestBody Map<String,Object> entity) {
        //TODO: process POST request
        System.out.println(entity);
        System.out.println(entity.get("flData").getClass());
        handlefile.setData(entity.get("flData").toString());
        handlefile.setFolder(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        handlefile.generateFolder();
        handlefile.storeFile();
        // entity.setFlCreator(u_Service.findUser(id));
        // entity.addFolder(f_Service.getFolder(folder));
        // fl_Service.createFile(entity);
        return "success";
    }
    
}
