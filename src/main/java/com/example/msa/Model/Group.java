package com.example.msa.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "group_det")
public class Group {
    @Id
    @GeneratedValue
    @Column(unique = true,nullable = false)
    private Integer grpId;
    @Column(nullable = false)
    private String grpName;
    private String grpProfile;
    private String grpAccess;
    @ManyToOne
    private User grpCreator;
    @ManyToMany
    @JoinTable(name = "grpMemebers",joinColumns = @JoinColumn(name="grpid"),inverseJoinColumns =@JoinColumn(name="memberid"))
    private Set<User> grpMembers=new HashSet<>();
    @OneToMany(mappedBy = "groupid")
    private List<File> grpFiles;
}
