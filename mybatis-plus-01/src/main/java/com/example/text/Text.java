package com.example.text;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatis-plus-01 com.example.text.Text
 * @description:
 * @author: fate
 * @create: 2019-10-10 20:06
 **/
public class Text {
    private static final ClassPathXmlApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }
    public static StudentMapper getMapper(){
        return context.getBean("studentMapper", StudentMapper.class);
    }



    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        ComboPooledDataSource dataSource = (ComboPooledDataSource)context.getBean("dataSource");
//        System.out.println("dataSource = " + dataSource);
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("connection = " + connection);



        StudentMapper mapper = getMapper();

//        Student student = new Student("Salary", 20);
//        int insert = mapper.insert(student);
//        System.out.println("insert = " + insert);
//        System.out.println("student = " + student);

//        Student student = new Student(2, "zs", 20);
//        int i = mapper.updateById(student);
//        System.out.println("i = " + i);

//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        int i = mapper.deleteBatchIds(list);
//        System.out.println("i = " + i);

//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("stu_no",3);
//        map.put("stu_name","zs");
//        int i = mapper.deleteByMap(map);
//        System.out.println("i = " + i);

        //面向对象开发
//        QueryWrapper<Student> wrapper = new QueryWrapper<Student>();
        //... where stu_no between 2 and 5 and stu_age>=20
//        wrapper.between("stu_no",2,5).ge("stu_age",20);
        //... where stu_no between 2 and 5 or stu_age>=20
//        wrapper.between("stu_no",2,5).or().ge("stu_age",20);
        //... where stu_no between 2 and 5 or (stu_age>=20 and stu_age <=25)
//        wrapper.between("stu_no",2,5).or(i->i.ge("stu_age",20).le("stu_age",25));
//        List<Student> students = mapper.selectList(wrapper);
//        System.out.println("students = " + students);


        //分页
//        Page<Student> page = new Page<>(2,3);
//        IPage<Student> studentIPage = mapper.selectPage(page, null);
//        List<Student> records = studentIPage.getRecords();
//        System.out.println("records = " + records);
//        System.out.println("getTotal = " + studentIPage.getTotal());

        //性能优化 不能全删,全该
//        int delete = mapper.delete(null);
//        System.out.println("delete = " + delete);
//        int update = mapper.update(new Student("xy", 49), null);
//        System.out.println("update = " + update);


        //乐观锁 加一个version
//        Student u = new Student();
//        u.setVersion(1);
//        u.setStuNo(2);
//        u.setStuName("xxx");
//        int update = mapper.updateById(u);
//        System.out.println("update = " + update);


        //自定义注入器
//        int deleteAllStudents = mapper.deleteAllStudents();
//        System.out.println("deleteAllStudents = " + deleteAllStudents);


        //逻辑删除
//        int i = mapper.deleteById(1);
//        System.out.println("i = " + i);
//        List<Student> students = mapper.selectList(null);
//        System.out.println("students = " + students);

        //默认值
        Student student = new Student();
        student.setStuAge(88);
        int insert = mapper.insert(student);
        System.out.println("insert = " + insert);

    }

}
