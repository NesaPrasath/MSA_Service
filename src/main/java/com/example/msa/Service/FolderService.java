package com.example.msa.Service;

import java.util.List;

import com.example.msa.Model.Folder;
import com.example.msa.Model.User;

public interface FolderService {
    public List<Folder> getAllFolder(Integer u_id,String f_name);
    public Folder createFolder(Folder folder);
    public String updateFolder(Integer f_id,Folder folder);
    public Folder getFolder(Integer f_id);
    public List<Folder> findByUserandFParentId(User uid,Integer id);
    public List<Folder> findByUserHome(User user_id);
}
