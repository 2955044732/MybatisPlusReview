package com.spring.boot.mybatisplusreview.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.spring.boot.mybatisplusreview.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 18:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")//将数据库中的表名与javabean中的实体类相对应
public class User {
    @TableId(value = "uid",type = IdType.AUTO)//主键自增类型
    private Long id;
    @TableField("user_name")//因为实体类属性与数据库的字段不匹配设置为匹配的
    private String name;
    private Integer age;
    private String qqEmail;//数据库中表为qq_email mybatisplus可以匹配上
    private SexEnum sex;
    @TableLogic//逻辑删除
    private Integer isDeleted;

}
