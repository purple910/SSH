package com.company.test;


import com.company.entity.*;
import com.company.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * @program: mybatis-01 com.company.entity.TestMapper
 * @description: 测试
 * @author: fate
 * @create: 2019-09-21 17:35
 **/
public class TestMapper {

    public static SqlSessionFactory sessionFactory = null;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        SqlSession session = null;
        session = sessionFactory.openSession();
        return session;
    }

    public static void main(String[] args) {
        SqlSession session = getSession();
        PeopleMapper mapper = session.getMapper(PeopleMapper.class);

//        PeopleEntity peopleEntity = mapper.queryPeopleById(1);
//        System.out.println(peopleEntity);

//        List<PeopleEntity> list = mapper.queryAllPeople();
//        System.out.println(list);

//        PeopleEntity peopleEntity = new PeopleEntity(3,"Tom",10);
//        int insert = mapper.addPeople(peopleEntity);
//        session.commit(); //提交事务
//        System.out.println(insert);

//        int deletePeople = mapper.deletePeople(3);
//        session.commit();
//        System.out.println(deletePeople);

//        PeopleEntity peopleEntity = new PeopleEntity(3,"Salary",10);
//        final int one = mapper.updatePeople(peopleEntity);
//        session.commit();
//        System.out.println(one);




        //转换器
//        PeopleEntity entity = mapper.queryPeopleWithConverter(1);
//        System.out.println(entity);

//        PeopleEntity peopleEntity = new PeopleEntity(3, "Tom", 18, true);
//        int i = mapper.addPeopleWithConverter(peopleEntity);
//        session.commit();
//        System.out.println(i);



        // #{} ${}
//        PeopleEntity peopleEntity = mapper.queryPeopleByName("li");
//        System.out.println(peopleEntity);

//        List<PeopleEntity> peopleEntities = mapper.queryPeopleOrderByColumn("name");
//        System.out.println(peopleEntities);

//        List<PeopleEntity> entities = mapper.queryPeopleByIdOrName(new PeopleEntity(18, "o"));
//        System.out.println(entities);

//        List<PeopleEntity> peopleEntities = mapper.queryPeopleByIAddress(new AddressEntity("bj", "tj"));
//        for (PeopleEntity entity:peopleEntities){
//            System.out.println(entity);
//            System.out.println(entity.getAddress());
//        }
//        AddressEntity addressEntity = new AddressEntity("bj", "xm");
//        PeopleEntity peopleEntity = new PeopleEntity();
//        peopleEntity.setAddress(addressEntity);
//        List<PeopleEntity> peopleEntities = mapper.queryPeopleByIAddress(peopleEntity);
//        for (PeopleEntity entity:peopleEntities){
//            System.out.println(entity);
//            System.out.println(entity.getAddress());
//        }



        //HashMap
//        Map<String,Object> map= new HashMap<>();
//        map.put("age","18");
//        map.put("name","li");
//        List<PeopleEntity> peopleEntities = mapper.queryPeopleByIdOrNameWithHashMap(map);
//        System.out.println(peopleEntities);

//        List<HashMap<String, Object>> hashMaps = mapper.queryPeopleOutByHashMap();
//        System.out.println(hashMaps);
//        List<PeopleEntity> peopleEntities = mapper.queryPeopleByHashMap();
//        System.out.println(peopleEntities);



        //procedure ===  HashMap
//        Map<String,Object> map = new HashMap<>();
//        map.put("p_name","li");
//        mapper.queryPeopleCountBynameWithProcedure(map);
//        Object count = map.get("p_count");
//        System.out.println(count);

//        map.put("pno",6);
//        int i = mapper.deletePeopleByIdWithProcedure(map);
//        session.commit();
//        System.out.println(i);



//        PeopleEntity entity = new PeopleEntity();
//        entity.setName("li");
//        entity.setAge(18);
////        List<PeopleEntity> peopleEntities = mapper.queryPeopleWithSQLTag(entity);
//        List<PeopleEntity> peopleEntities = mapper.queryPeopleWithSQLTag1(entity);
//        System.out.println(peopleEntities);

//        Foreach foreach = new Foreach();
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,5));
//        foreach.setIds(list);
//        List<PeopleEntity> peopleEntities = mapper.queryPeopleForeach(foreach);

//        int[] ints = {1,3,5};
//        List<PeopleEntity> peopleEntities = mapper.queryPeopleArrary(ints);

//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,5));
//        List<PeopleEntity> peopleEntities = mapper.queryPeopleList(list);

//        PeopleEntity[] entities = new PeopleEntity[]{new PeopleEntity(1),new PeopleEntity(3)};
//        mapper.queryPeopleObjectArrary(entities);

//        PeopleEntity[] entities = new PeopleEntity[]{new PeopleEntity(1),new PeopleEntity(3)};
//        mapper.queryPeopleSQL(entities);



        //one to one
//        PeopleBusinessEntity peopleBusinessEntity = mapper.queryByIdWithOneToOne(1);
//        System.out.println(peopleBusinessEntity);

//        HashMap<String, Object> map = mapper.queryByIdWithOneToOneWithHashmap(1);
//        System.out.println(map);

//        PeopleEntity entity = mapper.queryByIdWithOneToOneWithMap(1);
//        System.out.println(entity);


        //one to many
//        List<PeopleClassEntity> peopleClassEntities = mapper.queryByIdWithOneToMany(1);
//        System.out.println(peopleClassEntities);


        //lazey
//        List<PeopleEntity> peopleEntities = mapper.queryByIdWithLazey();
//        for (PeopleEntity peopleEntity:peopleEntities){
//            System.out.println(peopleEntity.getAge()+","+peopleEntity.getId());
//
//        }
//        System.out.println("-----------------------------------");
//        for (PeopleEntity peopleEntity:peopleEntities){
//            PeopleCardEntity cardEntity = peopleEntity.getCardEntity();
//            System.out.println(cardEntity);
//        }

//        PeopleClassMapper classMapper = session.getMapper(PeopleClassMapper.class);
//        List<PeopleClassEntity> peopleClassEntities = classMapper.queryByIdWithOneToManyLazy();
//        for(PeopleClassEntity classEntity:peopleClassEntities){
//            System.out.println(classEntity);
//        }
//        System.out.println("---------------------");
//        for(PeopleClassEntity classEntity:peopleClassEntities){
//            List<PeopleEntity> peopleEntity = classEntity.getPeopleEntity();
//            System.out.println(peopleClassEntities);
//        }


        /**
         * 二级缓存
         * 1.config.xml
         *  <setting name="cacheEnabled" value="true"/>
         * 2.*Mapper.xml
         *  <cache/>
         * 3.实现接口
         *  public class PeopleEntity implements Serializable
         * 4.其父类与级联都要被序列化
         * 5.注意：
         *      Reader reader = Resources.getResourceAsReader("config.xml");
         *      SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
         *      只可以被调用一次,否则会产生不同的SqlSessionFactory,而其产生SqlSession也将不同,则session.getMapper(PeopleMapper.class)也会不同
         */
        PeopleEntity entities = mapper.queryPeopleById(1);
        System.out.println(entities);
        session.close();    //创建缓存
//        session.commit();   //查询的commit()不会清理缓存，增删改的commit()会清理缓存，防止脏数据
        System.out.println("第二次缓存：");
        session = getSession();
        PeopleMapper mapper1 = session.getMapper(PeopleMapper.class);
        PeopleEntity entities2 = mapper1.queryPeopleById(1);
        System.out.println("第3次缓存：");
        PeopleMapper mapper2 = session.getMapper(PeopleMapper.class);
        PeopleEntity entities3 = mapper2.queryPeopleById(1);


        session.close();

    }
}
