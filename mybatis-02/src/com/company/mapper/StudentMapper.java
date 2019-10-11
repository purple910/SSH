package com.company.mapper;

import com.company.entity.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @program: mybatis-02 com.company.mapper.StudentMapper
 * @description:
 * @author: fate
 * @create: 2019-10-08 13:20
 **/
public interface StudentMapper {


    public Student queryStudentById(int id);

    public int addStudentWithEcho(Student student);

    public Integer addStudentWithParametes(Integer id, String name, Integer age);
    public Integer addStudentWithParametes2(@Param("a") Integer id, @Param("b") String name, @Param("age") Integer age);
    public Integer addStudentWithParametes3(@Param("a") Integer id, @Param("stu") Student student);

    public boolean addStudentWithNull(Student student);

    public HashMap<String,Object> queryStudentWithMap(int id);
    @MapKey("id")
    public HashMap<String,Student> queryStudentWithMap1();

    public List<Student> queryStudentsWithCase();

    public List<Student> queryStudentsWithONGL(Student student);

    public List<Student> queryStudentWith(Student student);

    public List<Student> queryStudentWithSee(Student student);
    public List<Student> queryStudentWithSee1(Student student);
    public List<Student> queryStudentWithSee2(Student student);

    public List<Student> queryStudentsWithInterceptor(int id);

    public int addStudentWithMany(List<Student> students);

    public List<Student> queryStudentWithPage();

    @Select("select * from mybatis_student")
    public List<Student> queryStudentAll();
}
