package com.example.msa.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_det")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false,columnDefinition="int")
    @JsonProperty("uId")
    private Integer uId;
    @Column(unique = true,nullable = false)
    @JsonProperty("uName")
    private String uName;
    @Column(columnDefinition = "varchar",nullable = false)
    @JsonProperty("uPass")
    private String uPass;
    @Column(unique = true,nullable = false)
    @JsonProperty("uMail")
    private String uMail;
    @JsonProperty("uPlan")
    private String uPlan;
    @JsonProperty("uProfPic")
    private String uProfPic;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude
    @JsonProperty("uFolders")
    private List<Folder> uFolders;
    @OneToMany(mappedBy = "grpCreator")
    @ToString.Exclude
    private List<Group> uCrtGroups;
    @OneToMany(mappedBy = "flCreator") 
    @ToString.Exclude
    @JsonManagedReference
    @JsonProperty("uFiles")
    private List<File> uFiles;
    @ManyToMany(mappedBy = "grpMembers")
    @ToString.Exclude
    private Set<Group> uPresGroup=new HashSet<>();
    @ManyToMany
    @JoinTable(name = "userfriends",joinColumns = @JoinColumn(name="userid"),inverseJoinColumns = @JoinColumn(name="friendid"))
    @ToString.Exclude
    private Set<User> uFriends=new HashSet<>();
    @Column(columnDefinition = "int default 0")
    private Integer friendsCount;
    @Column(columnDefinition = "boolean default false")
    @JsonProperty("isDelete")
    private Boolean isDelete;
}
