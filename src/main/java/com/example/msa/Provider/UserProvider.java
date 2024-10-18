package com.example.msa.Provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msa.Model.FrndRequest;
import com.example.msa.Model.User;
import com.example.msa.Repository.FrndRequestRepository;
import com.example.msa.Repository.UserRepository;
import com.example.msa.Service.UserService;

@Service
public class UserProvider implements UserService{

    @Autowired
    UserRepository repository;

    @Autowired
    FrndRequestRepository frrepository;

    @Override
    public void getAllFriends(Integer u_id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllFriends'");
        User usr=repository.findById(u_id).get();
        if(usr.getUFriends().size()>0)
        {
            System.out.println("User friends are "+usr.getUFriends());
        }
        else
        {
            System.out.println("User Has no friends");
        }
    }

    @Override
    public void getUserSearch(String u_name) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getUserSearch'");
        List<User> srch_res=repository.findByuNameContains(u_name);
        for(User us:srch_res)
        {
            System.out.println(us);
        }
    }

    @Override
    public Optional<User> getUser(Integer u_id) {
        // TODO Auto-generated method stub
        return repository.findById(u_id);
        // throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public List<User> chckUser(String user, String pass) {
        // TODO Auto-generated method stub
        List<User> chck_user=repository.findByuMail(user);
        return chck_user;
        // throw new UnsupportedOperationException("Unimplemented method 'chckUser'");
    }

    @Override
    public User createUser(User user) {
        // TODO Auto-generated method stub
        User new_user=repository.save(user);
        return new_user;
        // throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public String deleteUSer(Integer entity) {

        repository.deleteById(entity);
        return "Success";
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteUSer'");
    }

    @Override
    public User findUser(Integer u_id) {
        // TODO Auto-generated method stub
        return repository.findById(u_id).get();
        // throw new UnsupportedOperationException("Unimplemented method 'findUser'");
    }

    @Override
    public void addFrndRequest(FrndRequest frndreq) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'addFrndRequest'");
        frrepository.save(frndreq);
        System.out.println("friend request is sent successfully");
    }

    @Override
    public List<Map<String, String>> getFrndRequest(Integer u_id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getFrndRequest'");
        List<Map<String,String>> frndReq=new ArrayList<>();

        List<FrndRequest> reqList=frrepository.findByReqId(u_id);

        for(FrndRequest req:reqList){
            Map<String,String> frnd=new HashMap<>();
            User usr=repository.findById(req.getUserId()).get();
            frnd.put("Id", usr.getUId().toString());
            frnd.put("uname",usr.getUName());
            frnd.put("prf-pic", usr.getUProfPic());

            frndReq.add(frnd);
        }

        System.out.println("No of friend request user recieve is "+frndReq.size());

        return frndReq;
    }

}
