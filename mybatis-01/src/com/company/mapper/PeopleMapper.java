package com.company.mapper;

import com.company.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatis-01 com.company.mapper.PeopleMapper
 * @description: mapper
 * @author: fate
 * @create: 2019-09-21 19:51
 **/
public interface PeopleMapper {
    /**
     * 方法名与PeopleEntityMapper.xml文件中标签的id一样
     * 方法的输入参数与PeoEntityMapper.xml文件的标签的parameterType类型一样
     * @param id
     * @return
     */
    public PeopleEntity queryPeopleById(int id);
    public List<PeopleEntity> queryAllPeople();
    public int addPeople(PeopleEntity entity);
    public int updatePeople(PeopleEntity entity);
    public int deletePeople(int id);

    public PeopleEntity queryPeopleWithConverter(int id);
    public int addPeopleWithConverter(PeopleEntity entity);

    public PeopleEntity queryPeopleByName(String name);
    public List<PeopleEntity> queryPeopleOrderByColumn(String name);
    public List<PeopleEntity> queryPeopleByIdOrName(PeopleEntity entity);
//    public List<PeopleEntity> queryPeopleByIAddress(AddressEntity entity);
    public List<PeopleEntity> queryPeopleByIAddress(PeopleEntity entity);

    public List<PeopleEntity> queryPeopleByIdOrNameWithHashMap(Map<String,Object> map);
    public List<HashMap<String,Object>> queryPeopleOutByHashMap();
    public List<PeopleEntity> queryPeopleByHashMap();

    public void queryPeopleCountBynameWithProcedure(Map<String,Object> map);
    public int deletePeopleByIdWithProcedure(Map<String,Object> map);

    public List<PeopleEntity> queryPeopleWithSQLTag(PeopleEntity peopleEntity);
    public List<PeopleEntity> queryPeopleWithSQLTag1(PeopleEntity peopleEntity);
    public List<PeopleEntity> queryPeopleForeach(Foreach foreach);
    public List<PeopleEntity> queryPeopleArrary(int[] ids);
    public List<PeopleEntity> queryPeopleList(List<Integer> list);
    public List<PeopleEntity> queryPeopleObjectArrary(PeopleEntity[] entities);
    public List<PeopleEntity> queryPeopleSQL(PeopleEntity[] entities);


    public PeopleBusinessEntity queryByIdWithOneToOne(int id);
    public HashMap<String,Object> queryByIdWithOneToOneWithHashmap(int id);
    public PeopleEntity queryByIdWithOneToOneWithMap(int id);

    public List<PeopleClassEntity> queryByIdWithOneToMany(int id);

    public List<PeopleEntity> queryByIdWithLazey();

    public List<PeopleEntity> queryByIdWithHuancun();
    public List<PeopleEntity> queryByIdWithHuancunFalse();



}
