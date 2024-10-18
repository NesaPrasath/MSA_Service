package com.example.msa.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msa.Model.File;
import com.example.msa.Repository.FileRepository;
import com.example.msa.Service.FileService;

@Service
public class FileProvider implements FileService{

    @Autowired
    FileRepository repository;

    @Override
    public String createFile(File fl) {
        // TODO Auto-generated method stub
        repository.save(fl);
        return "success";
        // throw new UnsupportedOperationException("Unimplemented method 'createFile'");
    }

    
    
}
