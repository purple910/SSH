package com.example.demo.dao;

import com.example.demo.factory.RubricBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RubricDaoImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<RubricBean> listAllRubric() {
        List<RubricBean> user = jdbcTemplate.query("select * from Rubric",
                new BeanPropertyRowMapper<RubricBean>(RubricBean.class));
        return user;
    }

    public List<RubricBean> listPagedRubric(int pageIndex,int pageSize){
        String sql="select top "+pageSize+" * from Rubric where rid not in (select top ("+pageSize+" * ("+pageIndex+" -1)) id from Rubric)";

        List<RubricBean> user = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<RubricBean>(RubricBean.class));
        return user;
    }

    public int getRubricCount() {

        int result = jdbcTemplate.queryForObject("select count(*) from Rubric",Integer.class);
        return result;
    }


    public RubricBean getRubricById(String id) {
        RubricBean user = jdbcTemplate.queryForObject("select * from Rubric where rid = ?",
                new BeanPropertyRowMapper<RubricBean>(RubricBean.class), id);
        return user;
    }

    public List<RubricBean> getRubricByName(String id) {
        List<RubricBean> user = jdbcTemplate.query("select * from Rubric where rname ='"+id+"'",
                new BeanPropertyRowMapper<RubricBean>(RubricBean.class));
        return user;
    }

    public List<RubricBean> listPagedRubricByName(int pageIndex,int pageSize,String name){
        String sql="select top "+pageSize+" * from Rubric where rid not in (select top ("+pageSize+" * ("+pageIndex+" -1)) id from Rubric where rname like  '%"+name+"%') and rname like  '%"+name+"%'";

        List<RubricBean> user = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<RubricBean>(RubricBean.class));
        return user;
    }

    public int getRubricNameCount(String name) {

        int result = jdbcTemplate.queryForObject("select count(*) from Rubric where rname like '%"+name+"%'",Integer.class);
        return result;
    }

    public int insertRubric(final RubricBean user) {
        int result = jdbcTemplate.update("insert into Rubric VALUES (?,?,?,?,?,?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,user.getId());
                ps.setString(2,user.getName());
                ps.setString(3,user.getType());
                ps.setString(4,user.getSource());
                ps.setString(5,user.getTool());
                ps.setString(6,user.getContent());
                ps.setString(7,user.getMotifyId());

            }
        });

        return result;
    }

    public int updateRubric(final RubricBean user) {
        int result = jdbcTemplate.update("UPDATE Rubric set  rtype=?, rsource=?, rtool=?, rcontent=?, name=? ,mid=? where rid=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,user.getType());
                ps.setString(2,user.getSource());
                ps.setString(3,user.getTool());
                ps.setString(4,user.getContent());
                ps.setString(5,user.getName());
                ps.setString(6,user.getMotifyId());
                ps.setString(7,user.getId());
            }
        });

        return result;
    }

    public int deleteRubric(String id) {
        int result = jdbcTemplate.update("delete from Rubric where rid='"+id+"'");
        return result;
    }
}
