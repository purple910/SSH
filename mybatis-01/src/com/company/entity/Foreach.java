package com.company.entity;

import java.util.List;

/**
 * @program: mybatis-01 com.company.entity.Foreach
 * @description: foreach
 * @author: fate
 * @create: 2019-09-24 12:41
 **/
public class Foreach {
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "Foreach{" +
                "ids=" + ids +
                '}';
    }
}