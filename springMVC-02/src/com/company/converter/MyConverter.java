package com.company.converter;

import com.company.entity.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * @program: springMVC-02 com.company.converter.MyConverter
 * @description: 转换器
 * @author: fate
 * @create: 2019-10-01 09:25
 **/
public class MyConverter implements Converter<String, Student> {

    @Override
    public Student convert(String s) {
        String[] split = s.split("-");
        Student student = new Student();
        student.setId(Integer.parseInt(split[0]));
        student.setName(split[1]);
        student.setAge(Integer.parseInt(split[2]));
        return student;
    }
}
