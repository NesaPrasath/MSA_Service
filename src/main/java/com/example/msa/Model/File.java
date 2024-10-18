package com.example.msa.Model;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class File {
    @Id
    @GeneratedValue
    @Column(unique = true,nullable = false)
    private Integer flId;
    @Column(nullable = false)
    @JsonProperty("flName")
    private String flName;
    @Column(nullable = false)
    @JsonProperty("flSize")
    private Long flSize;
    @Column(nullable = false)
    @JsonProperty("flType")
    private String flType;
    @Column(nullable = false)
    @JsonProperty("flLink")
    private String flLink;
    @ManyToOne
    @JsonBackReference
    private User flCreator;
    @OneToMany(mappedBy = "ffiles")
    @JsonIgnore
    private Set<Folder> folder=new HashSet<>();
    @ManyToOne
    @JoinColumn(nullable = true)
    private Group groupid;

    public void addFolder(Folder fldr){
        folder.add(fldr);
    }
}
