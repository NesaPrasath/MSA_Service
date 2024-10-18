package com.example.msa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.msa.Model.FrndRequest;

public interface FrndRequestRepository extends JpaRepository<FrndRequest,Integer>{

    public List<FrndRequest> findByReqId(Integer reqId);
} 
