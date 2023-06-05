package com.spring.boot.mybatisplusreview;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.boot.mybatisplusreview.mapper.UserMapper;
import com.spring.boot.mybatisplusreview.pojo.User;
import com.sun.corba.se.impl.encoding.CDROutputObject;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 22:48
 */
@SpringBootTest
public class ConditionTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isBlank(username)){
            queryWrapper.like("user_name","a");
        }
        if(ageBegin != null){
            queryWrapper.ge("age", ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age", ageEnd);
        }
        //SELECT uid AS id,user_name AS name,age,qq_email,sex,is_deleted
        // FROM t_user
        // WHERE is_deleted=0 AND (user_name LIKE ? AND age >= ? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void test1(){
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(ageEnd != null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd)
                .like(StringUtils.isBlank(username),"user_name","a");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
