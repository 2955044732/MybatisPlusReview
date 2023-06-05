package com.spring.boot.mybatisplusreview;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.spring.boot.mybatisplusreview.mapper.UserMapper;
import com.spring.boot.mybatisplusreview.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 22:35
 */
@SpringBootTest
public class UpdateWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        ///将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        //UPDATE t_user SET age=?,qq_email=?
        // WHERE is_deleted=0
        // AND (user_name LIKE ? AND (age > ? OR qq_email IS NULL))

        //有bug

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper
                .set("age","22222")
                .set("qq_email","qqEmail")
                .like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("qq_email"));
        int update = userMapper.update(null, userUpdateWrapper);
        System.out.println(update);
    }
}
