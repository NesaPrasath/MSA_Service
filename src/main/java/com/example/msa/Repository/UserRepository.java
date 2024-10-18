package com.example.msa.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.msa.Model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
    // public List<User> findAllByU_IdIn(List<Integer> userId);
    
    // public List<String> findU_NameByU_IdIn(List<Integer> userId);

    // public List<String> findUNameByUNameContaining(String uName);

    public List<User> findByuMail(String uMail);

    public List<User> findByuNameContains(String uName);

    public Optional<User> findByuName(String uName);

    // @Query("select friendid from userfriends where userid=:uId")
    // public List<Integer> getAllFriends(@Param("uId") Integer uId);
} 
