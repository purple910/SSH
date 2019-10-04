package com.example.demo.dao;

import com.example.demo.factory.StudentBean;
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
public class StudentDaoImpl {



        @Autowired
        JdbcTemplate jdbcTemplate;

        public List<StudentBean> listAllStudent() {
            List<StudentBean> user = jdbcTemplate.query("select * from Student",
                    new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
            return user;
        }

        public List<StudentBean> listPagedStudent(int pageIndex,int pageSize){
            String sql="select top "+pageSize+" * from Student where sid not in (select top ("+pageSize+" * ("+pageIndex+" -1)) id from Student)";

            List<StudentBean> user = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
            return user;
        }

        public int getStudentCount() {

            int result = jdbcTemplate.queryForObject("select count(*) from Student",Integer.class);
            return result;
        }

        public StudentBean getStudentById(String id) {
            String sql = "select * from administrator where aid = '"+id+"'";

            StudentBean user1=jdbcTemplate.queryForObject(sql, new RowMapper<StudentBean>(){
                @Override
                public StudentBean mapRow(ResultSet arg0, int arg1) throws SQLException {
                    StudentBean user=new StudentBean(arg0.getString(1),arg0.getString(2));

                    return user;
                }
            });
            return user1;
        }

        public List<StudentBean> getStudentByRubric(String id){
            List<StudentBean> user = jdbcTemplate.query("select * from Student where rid ='"+id+"'",
                    new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
            return user;
        }

        public int loginStudent(final StudentBean stu){
            String sql = "select * from administrator where aid =?";

            StudentBean user1=jdbcTemplate.queryForObject(sql, new RowMapper<StudentBean>(){
                @Override
                public StudentBean mapRow(ResultSet arg0, int arg1) throws SQLException {
                    StudentBean user=new StudentBean();
                    user.setId(arg0.getString(1));
                    user.setPassword(arg0.getString(2));
                    return user;
                }
            },stu.getId());

            return user1.getPassword().equals(stu.getPassword())?1:-1;
        }

        public int insertStudent(final StudentBean user) {
            int result = jdbcTemplate.update("insert into Student (sid,sname,spassword,smajor,sgrade,semail,sphone) VALUES (?,?,?,?,?,?,?)", new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1,user.getId());
                    ps.setString(2,user.getName());
                    ps.setString(3,user.getPassword());
                    ps.setString(4,user.getMajor());
                    ps.setString(5,user.getGrade());
                    ps.setString(6,user.getEmail());
                    ps.setString(7,user.getPhone());
                }
            });

            return result;
        }

        public int updateStudentPassword(final StudentBean stu) {
            int result = jdbcTemplate.update("UPDATE Student set spassword=?  where sid=?", new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1,stu.getPassword());
                    ps.setString(2,stu.getId());
                }
            });

            return result;
        }

        public int updateStudentAck(final String id) {
            int result = jdbcTemplate.update("UPDATE Student set schoose =1  where sid=?", new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1,id);

                }
            });

            return result;
        }

        public int updateStudentChoose(final String id) {
            int result = jdbcTemplate.update("UPDATE Student set rid =1  where sid=?", new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1,id);

                }
            });
            return result;
        }

        public int deleteStudent(String id) {
            int result = jdbcTemplate.update("delete from Student where sid='"+id+"'");
            return result;
        }

        public  List<int[] > getStudentExcellent(){
            String sql ="";
            List<int[] > user = jdbcTemplate.query("select * from Student",
                    new BeanPropertyRowMapper<int[] >(int[] .class));

            return user;
        }

}
