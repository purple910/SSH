package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Student;
import org.apache.ibatis.annotations.Delete;

/**
 * @program: mybatis-plus-01 com.example.mapper.StudentMappler
 * @description:
 * @author: fate
 * @create: 2019-10-10 20:15
 **/
public interface StudentMapper extends BaseMapper<Student> {


//    injector
    public int deleteAllStudents();
}
