package com.company.test;


import com.company.entity.PeopleEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @program: mybatis-01 com.company.entity.Test
 * @description: 测试
 * @author: fate
 * @create: 2019-09-21 17:35
 **/
public class Test {

    public static SqlSession getSession(){
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            // 可以通过build的第二个参数可以强行指定数据库的运行环境
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static void main(String[] args) {
        SqlSession session = getSession();

//        String statement = "com.company.entity.PeopleEntityMapper.queryPeopleById";
//        PeopleEntity one = session.selectOne(statement,2);
//        System.out.println(one);

        String statement = "com.company.entity.PeopleEntityMapper.queryAllPeople";
        List<PeopleEntity> list = session.selectList(statement);
        System.out.println(list);

//        PeopleEntity peopleEntity = new PeopleEntity(3,"Tom",10);
//        String statement = "com.company.entity.PeopleEntityMapper.addPeople";
//        int insert = session.insert(statement,peopleEntity);
//        session.commit(); //提交事务
//        System.out.println(insert);

//        int delete = session.delete("com.company.entity.PeopleEntityMapper.deletePeople", 3);
//        session.commit();
//        System.out.println(delete);

//        String statement = "com.company.entity.PeopleEntityMapper.updatePeople";
//        PeopleEntity peopleEntity = new PeopleEntity(3,"Salary",10);
//        int one = session.update(statement,peopleEntity);
//        session.commit();
//        System.out.println(one);

        session.close();
    }
}
