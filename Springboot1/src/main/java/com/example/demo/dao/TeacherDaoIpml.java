package com.example.demo.dao;

import com.example.demo.factory.TeacherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherDaoIpml {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TeacherBean> listAllTeacher() {
        List<TeacherBean> user = jdbcTemplate.query("select * from Teacher",
                new BeanPropertyRowMapper<TeacherBean>(TeacherBean.class));
        return user;
    }

    public List<TeacherBean> listPagedTeacher(int pageIndex,int pageSize){
        String sql="select top "+pageSize+" * from Teacher where tid not in (select top ("+pageSize+" * ("+pageIndex+" -1)) id from Teacher)";

        List<TeacherBean> user = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<TeacherBean>(TeacherBean.class));
        return user;
    }

    public int getTeacherCount() {

        int result = jdbcTemplate.queryForObject("select count(*) from Teacher",Integer.class);
        return result;
    }


    public TeacherBean getTeacherById(String id) {
        TeacherBean user = jdbcTemplate.queryForObject("select * from Teacher where tid = ?",
                new BeanPropertyRowMapper<TeacherBean>(TeacherBean.class), id);
        return user;
    }
    public int loginTeacher(final TeacherBean stu){
        String sql = "select * from administrator where aid =?";

        TeacherBean user1=jdbcTemplate.queryForObject(sql, new RowMapper<TeacherBean>(){
            @Override
            public TeacherBean mapRow(ResultSet arg0, int arg1) throws SQLException {
                TeacherBean user=new TeacherBean();
                user.setId(arg0.getString(1));
                user.setPassword(arg0.getString(2));
                return user;
            }
        },stu.getId());

        return user1.getPassword().equals(stu.getPassword())?1:-1;
    }

    public int insertTeacher(final TeacherBean user) {
        int result = jdbcTemplate.update("insert into Teacher (tid,tname,tpassword,tjob) VALUES (?,?,?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,user.getId());
                ps.setString(2,user.getName());
                ps.setString(3,user.getPassword());
                ps.setString(4,user.getJob());
            }
        });

        return result;
    }

    public int updateTeacherPassword(final TeacherBean user) {
        int result = jdbcTemplate.update("UPDATE Teacher set tpassword=?  where tid=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,user.getPassword());
                ps.setString(2,user.getId());
            }
        });

        return result;
    }

    public int deleteTeacher(String id) {
        int result = jdbcTemplate.update("delete from Teacher where tid='"+id+"'");
        return result;
    }
}
