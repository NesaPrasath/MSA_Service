package com.example.msa.Model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Folder{
    @Id
    @GeneratedValue
    private Integer fId;
    @Column(nullable = false)
    @JsonProperty("fName")
    private String fName;
    @ToString.Exclude
    private String fAccess;
    @JsonProperty("fParentId")
    private Integer fParentId;
    @Column(unique = true)
    private String fPath;
    @ManyToOne
    @JsonBackReference
    private User user;
    @ManyToMany
    @JoinTable(name = "folderfiles",joinColumns = @JoinColumn(name="folderid"),inverseJoinColumns = @JoinColumn(name="fileid"))
    @ToString.Exclude
    @JsonIgnore
    private Set<File> ffiles=new HashSet<>();
    @Column(columnDefinition = "boolean default false")
    @JsonProperty("isDelete")
    private Boolean isDelete;
}
