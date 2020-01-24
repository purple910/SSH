package com.code.service.impl;

import com.code.entity.MybatisPlusStudent;
import com.code.mapper.MybatisPlusStudentMapper;
import com.code.service.IMybatisPlusStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-10-11
 */
@Service
public class MybatisPlusStudentServiceImpl extends ServiceImpl<MybatisPlusStudentMapper, MybatisPlusStudent> implements IMybatisPlusStudentService {

}
