package com.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: jpa com.example.domain.User
 * @description:
 * @author: fate
 * @create: 2019-10-19 11:26
 **/
@Entity
@Table(name = "jpa_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String uname;
    private Integer uage;

    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)
    @JoinTable(name = "jpa_ur",
            joinColumns = {@JoinColumn(name = "u_id",referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "rid")}
    )
    private Set<Role> roles = new HashSet<>();



    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }
}
