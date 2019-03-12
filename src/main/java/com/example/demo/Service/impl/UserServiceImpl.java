package com.example.demo.Service.impl;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void tranAction() {
        userMapper.updateUser("的哦122",1);

        userMapper.deleteUser(1);
    }
}
