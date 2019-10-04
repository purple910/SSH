package com.example.demo.dao;

import com.example.demo.factory.MotifyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MotifyDaoImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MotifyBean> listAllMotify() {
        List<MotifyBean> user = jdbcTemplate.query("select * from Motify",
                new BeanPropertyRowMapper<MotifyBean>(MotifyBean.class));
        return user;
    }

    public List<MotifyBean> listPagedMotify(int pageIndex,int pageSize){
        String sql="select top "+pageSize+" * from Motify where mid not in (select top ("+pageSize+" * ("+pageIndex+" -1)) id from Motify)";

        List<MotifyBean> user = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<MotifyBean>(MotifyBean.class));
        return user;
    }

    public int getMotifyCount() {

        int result = jdbcTemplate.queryForObject("select count(*) from Motify",Integer.class);
        return result;
    }

    public MotifyBean getMotifyById(String id) {
        MotifyBean user = jdbcTemplate.queryForObject("select * from Motify where mid = ?",
                new BeanPropertyRowMapper<MotifyBean>(MotifyBean.class), id);
        return user;
    }

    public List<MotifyBean> getMotifyByName(String name) {
        List<MotifyBean> user = jdbcTemplate.query("select * from Motify where mname='"+name+"'",
                new BeanPropertyRowMapper<MotifyBean>(MotifyBean.class));
        return user;
    }

    public List<MotifyBean> listPagedMotifyByName(int pageIndex,int pageSize,String name){
        String sql="select top "+pageSize+" * from Motify where mid not in (select top ("+pageSize+" * ("+pageIndex+" -1)) id from Motify where mname like '%"+name+"%') and mname like '%"+name+"%'";

        List<MotifyBean> user = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<MotifyBean>(MotifyBean.class));
        return user;
    }

    public int getMotifyNameCount(String name) {

        int result = jdbcTemplate.queryForObject("select count(*) from Motify where mname like'%"+name+"%' ",Integer.class);
        return result;
    }




    public int insertMotify(final MotifyBean user) {
        int result = jdbcTemplate.update("insert into Motify (mid,mname,mgrade,mmajor,mstart,mend,mpublish,mtotal,mnumber,mexcellent, tid) VALUES (?,?,?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,user.getId());
                ps.setString(2,user.getName());
                ps.setString(3,user.getGrade());
                ps.setString(4,user.getMojor());
                ps.setDate(5,user.getStart());
                ps.setDate(6,user.getEnd());
                ps.setInt(7,user.getPublish());
                ps.setInt(8,user.getTotal());
                ps.setInt(9,user.getNumber());
                ps.setDouble(10,user.getExcellent());
                ps.setString(11,user.getTeacherId());
            }
        });

        return result;
    }

    public int updateMotify(final MotifyBean stu) {
        int result = jdbcTemplate.update("UPDATE Motify set mgrade=?,mmajor=?,mstart=?,mend=?,mpublish=?,tid=?,mname=?,mtotal=?,mnumber=?,mexcellent=? where mid=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,stu.getGrade());
                ps.setString(2,stu.getMojor());
                ps.setDate(3,stu.getStart());
                ps.setDate(4,stu.getEnd());
                ps.setInt(5,stu.getPublish());
                ps.setString(6,stu.getTeacherId());
                ps.setDouble(7,stu.getNumber());
                ps.setInt(8,stu.getTotal());
                ps.setInt(9,stu.getNumber());
                ps.setDouble(10,stu.getExcellent());
                ps.setString(11,stu.getId());
            }
        });

        return result;
    }

    public int deleteMotify(String id) {
        int result = jdbcTemplate.update("delete from Motify where mid='"+id+"'");
        return result;
    }
}
