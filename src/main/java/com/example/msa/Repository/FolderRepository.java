package com.example.msa.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.msa.Model.Folder;
import com.example.msa.Model.User;

public interface FolderRepository extends JpaRepository<Folder,Integer>{
    
    @Query("SELECT f FROM Folder f WHERE f.user = :user_id AND  f.fParentId = :id")
    public List<Folder> findByUserandFParentId(User user_id,Integer id);

    @Query("SELECT f FROM Folder f WHERE f.user = :user_id AND  f.fParentId IS NULL")
    public List<Folder> findByUserHome(User user_id);
    // public List<Folder> findF_NameByUser(Integer user_id);

    // public List<Folder> findAllByUserAndF_Name(Integer user_id,String fd_name);

    // public String createFolder(Folder folder);

    // @Modifying
    // @Transactional
    // public String updateFolderByF_Id(Integer f_id);
}
