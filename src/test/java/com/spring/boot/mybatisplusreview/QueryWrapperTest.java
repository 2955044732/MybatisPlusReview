package com.spring.boot.mybatisplusreview;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.boot.mybatisplusreview.mapper.UserMapper;
import com.spring.boot.mybatisplusreview.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 21:56
 */
@SpringBootTest
public class QueryWrapperTest {
    /**
     * 条件构造器
     */
    @Autowired
    private UserMapper userMapper;

    @Test
    public void queryWapperselectListTest(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex,is_deleted
        // FROM t_user
        // WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ? AND age > ? AND qq_email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a").gt("age",24).lt("age",123).isNotNull("qq_email");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void queryWrapperOrderBy(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderByDesc("uid")
                .orderByAsc("age");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
    @Test
    public void queryQrapperdelete(){
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (qq_email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("qq_email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }
    @Test
    public void test01(){
        //UPDATE t_user SET user_name=?, qq_email=?
        // WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR qq_email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        queryWrapper.gt("age",20).like("user_name","a").or().isNull("qq_email");
        User user = new User();
        user.setName("0000000000000");
        user.setQqEmail("null");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(user);
    }
    @Test
    public void test02(){
        //UPDATE t_user SET user_name=?, qq_email=?
        // WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR qq_email IS NULL))
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("qq_email"));
        User user = new User();
        user.setName("牛牛");
        user.setQqEmail("6666666666.com");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }
    @Test
    public void QuerySelectTest(){
        //SELECT sex,user_name FROM t_user WHERE is_deleted=0
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("sex","user_name");
        List<Map<String,Object>> list = userMapper.selectMaps(queryWrapper);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }
    @Test
    public void zcx(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //SELECT uid AS id,user_name AS name,age,qq_email,sex,is_deleted
        // FROM t_user
        // WHERE is_deleted=0
        // AND
        // (uid IN (select uid from t_user where uid < 10))
        queryWrapper.inSql("uid","select uid from t_user where uid < 10");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
