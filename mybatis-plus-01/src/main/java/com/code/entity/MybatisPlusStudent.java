package com.code.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-10-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MybatisPlusStudent extends Model {

    private static final long serialVersionUID=1L;

    @TableId(value = "stu_no", type = IdType.AUTO)
    private Integer stuNo;

    private String stuName;

    private Integer stuAge;


}
