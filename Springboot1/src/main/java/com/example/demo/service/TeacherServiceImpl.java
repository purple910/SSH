package com.example.demo.service;

import com.example.demo.dao.RubricDaoImpl;
import com.example.demo.dao.StudentDaoImpl;
import com.example.demo.dao.TeacherDaoIpml;
import com.example.demo.factory.RubricBean;
import com.example.demo.factory.TeacherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl {

    @Autowired
    private TeacherDaoIpml teacherDaoIpml ;
    @Autowired
    private StudentDaoImpl studentDao;
    @Autowired
    private RubricDaoImpl rubricDao;

    public int loginTeacherMain(String id,String password){
        if(teacherDaoIpml.getTeacherById(id)!=null){
            TeacherBean te = new TeacherBean(id,password);
            return teacherDaoIpml.loginTeacher(te);
        }
        return -1;
    }

    public int updateTeacherPassword(String id,String password){
        if(teacherDaoIpml.getTeacherById(id)!=null){
            TeacherBean te = new TeacherBean(id,password);
            return teacherDaoIpml.updateTeacherPassword(te);
        }
        return -1;
    }

    public TeacherBean queryTeacherInfo(String id){
        return teacherDaoIpml.getTeacherById(id);
    }

    public int updateStudentAck(String id){
        if(studentDao.getStudentById(id)!=null){
            return studentDao.updateStudentAck(id);
        }
        return -1;
    }

    public int insertRubricInfo(RubricBean r){
        if(rubricDao.getRubricById(r.getId())==null){
            return rubricDao.insertRubric(r);
        }
        return -1;
    }

    public int updateRubricInfo(RubricBean r){
        if(rubricDao.getRubricById(r.getId())!=null){
            if(studentDao.getStudentByRubric(r.getId())==null){
                return rubricDao.updateRubric(r);
            }else {
                return -2;
            }
        }
        return -1;
    }

    public int deleteRubricInfo(String id){
        if(rubricDao.getRubricById(id)!=null){
            if(studentDao.getStudentByRubric(id)==null) {
                return rubricDao.deleteRubric(id);
            }else {
                return -2;
            }
        }
        return -1;
    }

    public RubricBean queryRubricById(String id){
        return rubricDao.getRubricById(id);
    }

    public List<RubricBean> queryRubricByName(String name){
        return rubricDao.getRubricByName(name);
    }

    public List<RubricBean> queryRubricByName(int pageIndex,int pageSize,String name){
        return rubricDao.listPagedRubricByName(pageIndex, pageSize, name);
    }

    public int queryRubricCount(String name){
        return rubricDao.getRubricNameCount(name);
    }

    public int queryRubricCount(){
        return rubricDao.getRubricCount();
    }

    public List<RubricBean> queryRubricInfo(int pageIndex,int pageSize){
        return rubricDao.listPagedRubric(pageIndex, pageSize);
    }

    public List<RubricBean> queryRubricInfo(){
        return rubricDao.listAllRubric();
    }


}
