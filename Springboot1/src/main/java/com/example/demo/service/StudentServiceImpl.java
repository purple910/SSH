package com.example.demo.service;

import com.example.demo.dao.RubricDaoImpl;
import com.example.demo.dao.StudentDaoImpl;
import com.example.demo.factory.RubricBean;
import com.example.demo.factory.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDaoImpl studentDao;
    @Autowired
    private RubricDaoImpl rubricDao;

    public StudentBean queryStudentInfo(String id){
        return studentDao.getStudentById(id);
    }

    public int updateStudentPassword(StudentBean stu){
        if(studentDao.getStudentById(stu.getId())!=null){
            return studentDao.updateStudentPassword(stu);
        }
        return -1;
    }

    public int quqeryRubricAck(String id){
        StudentBean stu = studentDao.getStudentById(id);
        if("1".equals(stu.getRubricId())){
            return 1;
        }
        return -1;
    }

    public int updateRubricChoose(String id){
        if(studentDao.getStudentById(id)!=null){
            return studentDao.updateStudentChoose(id);
        }
        return -1;
    }

    public int loginStudentMain(String id,String password){
        if(studentDao.getStudentById(id)!=null){
            StudentBean te = new StudentBean(id,password);
            return studentDao.loginStudent(te);
        }
        return -1;
    }

    public int queryRubricCount(){
        return rubricDao.getRubricCount();
    }

    public List<RubricBean> queryRubricInfo(int pageIndex,int pageSize){
       return rubricDao.listPagedRubric(pageIndex, pageSize);
    }

}
