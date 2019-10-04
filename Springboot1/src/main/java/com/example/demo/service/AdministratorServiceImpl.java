package com.example.demo.service;


import com.example.demo.dao.*;
import com.example.demo.factory.AdministratorBean;
import com.example.demo.factory.MotifyBean;
import com.example.demo.factory.StudentBean;
import com.example.demo.factory.TeacherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl {

    @Autowired
    private AdministratorDaoImpl administratorDao;
    @Autowired
    private StudentDaoImpl studentDao;
    @Autowired
    private TeacherDaoIpml teacherDaoIpml;
    @Autowired
    private RubricDaoImpl rubricDao;
    @Autowired
    private MotifyDaoImpl motifyDao;


    public int loginAdministratorMain(String name,String password){
        AdministratorBean a =new AdministratorBean(name,password);
       // System.out.println("2222");
        return administratorDao.loginTeacher(a);
    }

    public int updateStudentPassword(StudentBean stu){
        if(studentDao.getStudentById(stu.getId())!=null){
            return studentDao.updateStudentPassword(stu);
        }
        return -1;
    }

    public int updateTeacherPassword(TeacherBean t){
        if(teacherDaoIpml.getTeacherById(t.getId())!=null){
            return teacherDaoIpml.updateTeacherPassword(t);
        }
        return -1;
    }

    public int insertMotifyInfo(MotifyBean m){
        if(motifyDao.getMotifyById(m.getId())==null){
            return motifyDao.insertMotify(m);
        }
        return -1;
    }

    public int updateMotifyInfo(MotifyBean m){
        if(motifyDao.getMotifyById(m.getId())==null){
            return motifyDao.updateMotify(m);
        }
        return -1;
    }

    public int deleteMotifyInfo(String id){
        if(motifyDao.getMotifyById(id)!=null){
            return motifyDao.deleteMotify(id);
        }
        return -1;
    }

    public MotifyBean queryMotifyById(String id){
        return motifyDao.getMotifyById(id);
    }

    public int queryMotifyCount(String name){
        return motifyDao.getMotifyNameCount(name);
    }

    public List<MotifyBean> queryMotifyInfoByName(String name){
        return motifyDao.getMotifyByName(name);
    }

    public List<MotifyBean> queryMotifyInfoByName(int pageIndex,int pageSize ,String name){
        return motifyDao.listPagedMotifyByName(pageIndex, pageSize, name);
    }

    public int queryMotifyCount(){
        return motifyDao.getMotifyCount();
    }

    public List<MotifyBean> queryMotifyInfo(){
        return motifyDao.listAllMotify();
    }

    public List<MotifyBean> queryMotifyInfo(int pageIndex,int pageSize ){
        return motifyDao.listPagedMotify(pageIndex, pageSize);
    }

    //查询分类统计
    public List<String[]> queryExcellte(){
        List<String[]> list =null;

        return list;
    }

    //进度查询
    public int[] querySpeed(){
        int[] ints=null;


        return ints;
    }


}
