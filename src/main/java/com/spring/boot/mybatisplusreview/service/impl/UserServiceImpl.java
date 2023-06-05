package com.spring.boot.mybatisplusreview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.boot.mybatisplusreview.mapper.UserMapper;
import com.spring.boot.mybatisplusreview.pojo.User;
import com.spring.boot.mybatisplusreview.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @auther qwh
 * @create 2023-05-2023/5/18 21:04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
