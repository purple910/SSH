package com.example.test.mapper;

import com.example.test.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: SSM-02 StudentMapper
 * @description: mapper
 * @author: fate
 * @create: 2019-10-01 18:04
 **/

public interface StudentMapper {

    public Student queryStudentById(int id);
    public int addStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(Student student);
    public List<Student> queryAllStudent();
}
