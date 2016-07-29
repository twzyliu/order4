package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.User.User;
import com.thoughtworks.ketsu.domain.User.UserInterface;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public class UserRepository implements UserInterface {
    @Inject
    UserMapper userMapper;

    @Override
    public void createUser(Map<String, Object> userinfo) {
        userMapper.createUser(userinfo);
    }

    @Override
    public User find_user_by_userid(int userid) {
        return userMapper.find_user_by_userid(userid);
    }
}
