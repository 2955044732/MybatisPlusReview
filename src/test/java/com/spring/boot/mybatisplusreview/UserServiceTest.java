package com.spring.boot.mybatisplusreview;

import com.spring.boot.mybatisplusreview.pojo.User;
import com.spring.boot.mybatisplusreview.service.UserService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 21:10
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void saveTest(){
        //INSERT INTO t_user ( user_name, age, qq_email ) VALUES ( ?, ?, ? )
        User user = new User();
        user.setName("zxc");
        user.setAge(123);
        user.setQqEmail("123zxc.com");
        boolean save = userService.save(user);
        System.out.println(save);
    }
    @Test
    public void saveBatchTest(){
        //INSERT INTO t_user ( user_name, age, qq_email, sex ) VALUES ( ?, ?, ?, ? )
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        for (int i = 0; i < 5; i++) {
            user.setAge(10+i);
            user.setName("aaa"+i);
            user.setQqEmail("qq.com"+i);
            users.add(user);
        }
        boolean batch = userService.saveBatch(users);
        System.out.println(batch);
    }
    @Test
    public void removeByIdTest(){
        //DELETE FROM t_user WHERE uid=?
        boolean remove = userService.removeById(1);
        System.out.println(remove);
    }
    @Test
    public void removeBatchIdsTest(){
        //DELETE FROM t_user WHERE uid=?
        List<Integer> list = Arrays.asList(16,17,19);
        boolean batch = userService.removeBatchByIds(list);
        System.out.println(batch);
    }
    @Test
    public void removeByMapTest(){
        //DELETE FROM t_user WHERE user_name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("user_name","qwe");
        map.put("age",123);
        boolean remove = userService.removeByMap(map);
        System.out.println(remove);
    }
    @Test
    public void updateByIdTest(){
        //PDATE t_user SET user_name=? WHERE uid=?
        User user = new User();
        user.setId(2L);
        user.setName("8888888888888");
        boolean update = userService.updateById(user);
        System.out.println(update);
    }
    @Test
    public void countTest(){
        //SELECT COUNT( * ) FROM t_user
        long count = userService.count();
        System.out.println(count);
    }
    @Test
    public void getByIdTest(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex FROM t_user WHERE uid=?
        User byId = userService.getById(2);
        System.out.println(byId);
    }
    @Test
    public void listTest(){
        //SELECT uid AS id,user_name AS name,age,qq_email,sex FROM t_user
        List<User> list = userService.list();
        System.out.println(list);//user(.....)
    }
    @Test
    public void MapTest(){
        List<Map<String, Object>> maps = userService.listMaps();
        for (Map<String, Object> map : maps) {
            System.out.println(map);//{name=zxc, id=15, age=123, qq_email=123zxc.com}
        }
    }

}