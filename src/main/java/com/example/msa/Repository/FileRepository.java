package com.example.msa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.msa.Model.File;
import com.example.msa.Model.User;


public interface FileRepository extends JpaRepository<File,Integer>{
    // public List<File> findByFl_Creator(Integer fl_UserId);
    public List<File> findByFlCreator(User flCreator);
    // public List<File> findByFolderIn(Integer fd_Id);
    // public List<File> findByFlCreatorAndFlFolder()

    // public String createFile(File file);

    // @Modifying
    // @Transactional
    // public String updateFile(Integer f_id);
}
