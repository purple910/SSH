package com.company.test;

import com.company.entity.Student;
import com.company.mapper.StudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static SqlSessionFactory sessionFactory = null;
    static {
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        SqlSession session = null;
//        session = sessionFactory.openSession();   //手动
//        session = sessionFactory.openSession(true);     //自动
        session = sessionFactory.openSession(ExecutorType.BATCH);    //批量插入
        return session;
    }

    public static void main(String[] args) {
	// write your code here
        SqlSession session = getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

//        Student student = mapper.queryStudentById(1);
//        System.out.println(student);
//
//        List<Student> list = mapper.queryStudentAll();
//        System.out.println(list);


        /**
         * 自增
         * id 不要int 用Interger
         */
//        Student student = new Student("aa",5);
//        mapper.addStudentWithEcho(student);
////        session.commit();
//        Integer id = student.getId();
//        System.out.println(student);
//        System.out.println(id);


        /**
         * 传递多参
         */
//        Integer lsls = mapper.addStudentWithParametes(null, "lsls", 12);
//        Integer lsls = mapper.addStudentWithParametes2(null, "zs", 15);
//        Student student = new Student(null, "as", 10);
//        Integer lsls = mapper.addStudentWithParametes3(null, student);
//        System.out.println(lsls);


        /**
         * hashmap
         */
//        HashMap<String, Object> hashMap = mapper.queryStudentWithMap(2);
//        System.out.println(hashMap);
//        HashMap<String, Student> studentHashMap = mapper.queryStudentWithMap1();
//        System.out.println(studentHashMap);


        /**
         * discriminator---case
         */
//        List<Student> student = mapper.queryStudentsWithCase();
//        System.out.println(student);


//        List<Student> list = mapper.queryStudentsWithONGL(new Student("s", 18, "a"));
//        System.out.println(list);


//        Student student = new Student();
//        student.setAge(18);
//        List<Student> list = mapper.queryStudentWith(student);
//        System.out.println(list);


//        List<Student> list = mapper.queryStudentWithSee(new Student("%s%",10));
//        List<Student> list = mapper.queryStudentWithSee2(new Student("s",10));
//        System.out.println(list);

//        List<Student> list = mapper.queryStudentsWithInterceptor(2);
//        System.out.println("list = " + list);


//        List<Student> list = new ArrayList<>();
//        long start = System.currentTimeMillis();
//        for(int i=1;i<10;i++){
//            Student student = new Student(i,"ll"+i,i,"X"+i);
//            list.add(student);
//        }
//        mapper.addStudentWithMany(list);
//        session.commit();
//        long end = System.currentTimeMillis();
//        System.out.println(end-start);


        /**
         * page
         */
        //第二种，Mapper接口方式的调用，推荐这种使用方式。pageNum:第几页,pageSize:页数大小
//        PageHelper.startPage(2, 3);
        //第三种，Mapper接口方式的调用，推荐这种使用方式。offset:偏移量,limit:数量
//        PageHelper.offsetPage(2, 3);
//        List<Student> list = mapper.queryStudentWithPage();
//        System.out.println("list = " + list);
        
        //jdk8 lambda用法
//        Page<Student> page = PageHelper.startPage(1, 3).doSelectPage(()-> mapper.queryStudentWithPage());
//        List<Student> list = page.getResult();
        //对应的lambda用法   
//        PageInfo<Student> pageInfo = PageHelper.startPage(2, 3).doSelectPageInfo(() -> mapper.queryStudentWithPage());
//        System.out.println("pageInfo.getList() = " + pageInfo.getList());
//        System.out.println("pageInfo.getPageNum() = " + pageInfo.getPageNum());
//        System.out.println("pageInfo.getNavigatepageNums() = " + Arrays.toString(pageInfo.getNavigatepageNums()));



    }
}

