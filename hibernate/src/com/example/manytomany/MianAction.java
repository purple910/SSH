package com.example.manytomany;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: hibernate-01 com.example.manytomany
 * @description: main
 * @author: fate
 * @create: 2019-09-18 20:19
 **/
public class MianAction {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(String[] args) {

        /**
         * 1.同增
         * 主表：课程
         * 子表：学生
         */
//        CourseEntity course = new CourseEntity();
//        course.setCname("python");
//
//        StuEntity stu1 = new StuEntity();
//        stu1.setSname("Bob");
//        StuEntity stu2 = new StuEntity();
//        stu2.setSname("Tom");
//
//        Set<StuEntity> stu = new HashSet<StuEntity>();
//        stu.add(stu1);
//        stu.add(stu2);
//
//        course.setStu(stu);
//        saved(course);

        /**
         * 课程绑定
         */
        StuEntity stu = new StuEntity();
        stu.setSname("ww");

        List<CourseEntity> list = queryed("Salary");
        Set<CourseEntity> course = new HashSet<CourseEntity>();

        for(CourseEntity courseEntity:list){
            course.add(courseEntity);
        }
        stu.setCourse(course);
        saved(stu);

    }

    public static final List<CourseEntity> queryed(String sname){
        Session session = getSession();
        Query query = session.createQuery("select s.course from StuEntity s where s.sname=:sname");
        query.setParameter("sname",sname);
        List<CourseEntity> list = query.list();
        session.close();
        return list;
    }

    public static final void saved(Object entity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

}
