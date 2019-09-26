package com.company.mapper;

import com.company.entity.Foreach;
import com.company.entity.PeopleBusinessEntity;
import com.company.entity.PeopleClassEntity;
import com.company.entity.PeopleEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatis-01 com.company.mapper.PeopleClassMapper
 * @description: mapper
 * @author: fate
 * @create: 2019-09-21 19:51
 **/
public interface PeopleClassMapper {

    public List<PeopleClassEntity> queryByIdWithOneToManyLazy();

}
