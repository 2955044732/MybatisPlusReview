package com.spring.boot.mybatisplusreview;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.boot.mybatisplusreview.mapper.UserMapper;
import com.spring.boot.mybatisplusreview.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 23:02
 */
@SpringBootTest
public class PageTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);
        /**
         * 当前页：1
         * 每页显示的条数：5
         * 总记录数：11
         * 总页数：3
         * 是否有上一页：false
         * 是否有下一页：true
         */
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());




    }
}
