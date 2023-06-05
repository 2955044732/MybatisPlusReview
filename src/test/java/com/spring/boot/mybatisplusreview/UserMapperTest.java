package com.spring.boot.mybatisplusreview;

import com.spring.boot.mybatisplusreview.enums.SexEnum;
import com.spring.boot.mybatisplusreview.mapper.UserMapper;
import com.spring.boot.mybatisplusreview.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 19:30
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex FROM t_user
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void insertTest(){
        User user = new User();
        user.setAge(123);
        user.setName("qwe");
        user.setQqEmail("qq.com.email");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
    @Test
    public void deleteByIdTest(){
//        DELETE FROM t_user WHERE uid=?
        int delete = userMapper.deleteById(12);
    }
    @Test
    public void deleteByBeanIdTest(){
        //DELETE FROM t_user WHERE uid=?
        User user = new User();
        user.setId(4L);
        int delete = userMapper.deleteById(user);
        System.out.println(delete);
    }
    @Test
    public void deleteByMap(){
        //DELETE FROM t_user WHERE uid = ? AND user_name = ?
        //设置逻辑删除后----->
        // UPDATE t_user SET is_deleted=1 WHERE uid = ? AND is_deleted=0
        Map<String,Object> map = new HashMap<>();
        map.put("uid",20);
        int delete = userMapper.deleteByMap(map);
        System.out.println(delete);
    }
    @Test
    public void deleteBatchIdsTest(){
        //DELETE FROM t_user WHERE uid IN ( ? , ? , ? )
        List<Long> idList = Arrays.asList(5L,7L,9L);
        int deleteBatchIds = userMapper.deleteBatchIds(idList);
        System.out.println(deleteBatchIds);
    }
    @Test
    public void updateByIdTest(){
        //UPDATE t_user SET user_name=?, age=?, qq_email=?, sex=? WHERE uid=?
        User user=new User(1L,"123qwe",111,"qweads", SexEnum.MALE,1);
        int update = userMapper.updateById(user);
        System.out.println(user);
    }
    @Test
    public void selectListTest(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex FROM t_user
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    public void selectByIdTest(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex FROM t_user WHERE uid=?
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void selectBatchIdsTest(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex FROM t_user WHERE uid IN ( ? , ? , ? , ? )
        List<Integer> idList = Arrays.asList(1,2,3,4);
        List<User> users = userMapper.selectBatchIds(idList);
        System.out.println(users);
    }
    @Test
    public void selectByMapTest(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex FROM t_user WHERE user_name = ? AND age = ?
        Map<String,Object> map = new HashMap<>();
        map.put("user_name","qwe");
        map.put("age",123);
        List<User> users = userMapper.selectByMap(map);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void selectCountTest(){
        //SELECT COUNT( * ) FROM t_user
        Long count = userMapper.selectCount(null);
        System.out.println(count);
    }


}
