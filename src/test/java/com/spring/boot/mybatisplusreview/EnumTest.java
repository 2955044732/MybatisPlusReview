package com.spring.boot.mybatisplusreview;

import com.spring.boot.mybatisplusreview.enums.SexEnum;
import com.spring.boot.mybatisplusreview.mapper.UserMapper;
import com.spring.boot.mybatisplusreview.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 23:24
 */
@SpringBootTest
public class EnumTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        User user = new User();
        user.setName("qwe");
        user.setAge(123);
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}
