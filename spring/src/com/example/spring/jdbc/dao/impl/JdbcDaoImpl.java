package com.example.spring.jdbc.dao.impl;

import com.example.spring.jdbc.dao.JdbcDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @program: spring-01 com.example.spring.jdbc.dao.impl.JdbcDaoImpl
 * @description: impl
 * @author: fate
 * @create: 2019-09-21 11:49
 **/
public class JdbcDaoImpl implements JdbcDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void execute() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select dname as a from stu");
//        for(Map<String,Object> map:maps){
//            System.out.println(map.get("a"));
//        }

//        jdbcTemplate.execute("insert into stu values ('1111111','jdbc')");

//        jdbcTemplate.update("delete from stu where did = ?",new String[]{"1111111"});

        int update = jdbcTemplate.update("update stu set dname=? where did=?", new String[]{"jdbcTemplate", "11111111"});
        System.out.println(update);

    }
}
