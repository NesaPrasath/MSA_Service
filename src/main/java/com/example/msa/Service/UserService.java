package com.example.msa.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.msa.Model.FrndRequest;
import com.example.msa.Model.User;

public interface UserService {
    public User createUser(User user);
    public void getAllFriends(Integer u_id);
    public void getUserSearch(String u_name);
    public Optional<User> getUser(Integer u_id);
    public List<User> chckUser(String user,String pass);
    public String deleteUSer(Integer u_id);
    public User findUser(Integer u_id);
    public void addFrndRequest(FrndRequest frndreq);
    public List<Map<String,String>> getFrndRequest(Integer u_id); 
}
