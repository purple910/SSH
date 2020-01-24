package com.company.entity;

/**
 * @program: springMVC-02 com.company.entity.Dept
 * @description:
 * @author: fate
 * @create: 2019-10-02 11:54
 **/
public class Dept {
    private Integer id;
    private String name;

    public Dept() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Dept(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
