package com.example.msa.Provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msa.Model.Folder;
import com.example.msa.Model.User;
import com.example.msa.Repository.FolderRepository;
import com.example.msa.Service.FolderService;

@Service
public class FolderProvider implements FolderService{

    @Autowired
    FolderRepository repository;

    @Override
    public List<Folder> getAllFolder(Integer u_id, String f_name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFolder'");
    }

    @Override
    public Folder createFolder(Folder folder) {
        // TODO Auto-generated method stub
        Folder resp=repository.save(folder);
        return resp;
        // throw new UnsupportedOperationException("Unimplemented method 'createFolder'");
    }

    @Override
    public String updateFolder(Integer f_id,Folder folder){
        // TODO Auto-generated method stub
        repository.save(folder);
        return "success";
        // throw new UnsupportedOperationException("Unimplemented method 'updateFolder'");
    }

    @Override
    public Folder getFolder(Integer f_id) {
        // TODO Auto-generated method stub
        return repository.findById(f_id).get();
        // throw new UnsupportedOperationException("Unimplemented method 'getFolder'");
    }

    @Override
    public List<Folder> findByUserandFParentId(User uid,Integer id) {
        // TODO Auto-generated method stub
        return repository.findByUserandFParentId(uid,id);
    }

    @Override
    public List<Folder> findByUserHome(User user_id) {
        // TODO Auto-generated method stub
        return repository.findByUserHome(user_id);
    }
    
}
