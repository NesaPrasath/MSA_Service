package com.example.msa.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class FrndRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer frId;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("reqId")
    private Integer reqId;
    @Column(nullable = true)
    @JsonProperty("status")
    private Boolean status;
}
