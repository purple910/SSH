package com.example.demo.dao;

import com.example.demo.factory.AdministratorBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AdministratorDaoImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int loginTeacher(final AdministratorBean stu){
       /*
         System.out.println(jdbcTemplate);
        AdministratorBean user=null;
                  try{
                    // 使用JdbcTemplate访问数据库
                     user = jdbcTemplate.queryForObject("select * from administrator where aid = 1",
                                    new BeanPropertyRowMapper<AdministratorBean>(AdministratorBean.class));
                     System.out.println(user.getId()+"+++++"+user.getPassword());
                }catch (InvalidResultSetAccessException e){
                    throw new RuntimeException(e);
                }catch (DataAccessException e){
                    throw new RuntimeException(e);
                }
        */
        String sql = "select * from administrator where aid = ?";

        AdministratorBean user1=jdbcTemplate.queryForObject(sql, new RowMapper<AdministratorBean>(){
            @Override
            public AdministratorBean mapRow(ResultSet arg0, int arg1) throws SQLException {
                AdministratorBean user=new AdministratorBean();
                user.setId(arg0.getString(1));
                user.setPassword(arg0.getString(2));
                return user;
            }
        },stu.getId());
        //System.out.println(user1.getId()+"++"+user1.getPassword()+"++++"+stu.getPassword());
        //System.out.println(user1.getPassword().equals(stu.getPassword()));
        return user1.getPassword().equals(stu.getPassword())?1:-1;
    }
}
