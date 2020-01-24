package com.example.onetomany;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: hibernate-01 com.example.onetomany
 * @description: main
 * @author: fate
 * @create: 2019-09-18 19:16
 **/
public class Many {
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
         * 主表：部门
         * 子表：员工
         */
//        DeptEntity dept = new DeptEntity();
//        dept.setDname("c++");
//
//        Set<EmpEntity> emp = new HashSet<EmpEntity>();
//        EmpEntity emp1 = new EmpEntity();
//        emp1.setEname("zs");
//        emp.add(emp1);
//        EmpEntity emp2 = new EmpEntity();
//        emp2.setEname("ls");
//        emp.add(emp2);
//
//        dept.setEmp(emp);
//        saves(dept);

        /**
         * 2.同该
         */
//        DeptEntity dept = getDept("297ed2ed6d4431bc016d4431c2a30000");
////        System.out.println(dept.getEmp());
//        dept.setDname(dept.getDname()+"+++");
//        for(EmpEntity emp:dept.getEmp()){
//            emp.setEname(emp.getEname()+"----");
//        }
//        updated(dept);

        /**
         * 3.同删
         */
//         DeptEntity dept = getDept("297ed2ed6d4431bc016d4431c2a30000");
//         deleted(dept);

        /**
         *4.单删
         * 会清除其被占用的主键，但其外键者不会被删除，只删出与主键相关联的外键
         */
        DeptEntity dept = new DeptEntity();
        dept.setDid("297ed2ed6d44460c016d44460e1c0000");
        deleted(dept);

    }

    public static void deleted(DeptEntity deptEntity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(deptEntity);
        transaction.commit();
        session.close();
    }


    public static void updated(DeptEntity deptEntity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(deptEntity);
        transaction.commit();
        session.close();
    }

    public static DeptEntity getDept(String did){
        Session session = getSession();
        DeptEntity entity = session.get(DeptEntity.class, did);
        session.close();
        return entity;
    }

    public static void saves(DeptEntity deptEntity){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(deptEntity);
        transaction.commit();
        session.close();
    }
}
