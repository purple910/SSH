package com.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: jpa com.example.domain.Role
 * @description:
 * @author: fate
 * @create: 2019-10-19 11:26
 **/
@Entity
@Table(name = "jpa_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;
    private String rname;

//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "jpa_ur",
//            joinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "rid")},
//            inverseJoinColumns = {@JoinColumn(name = "u_id",referencedColumnName = "uid")}
//    )
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
