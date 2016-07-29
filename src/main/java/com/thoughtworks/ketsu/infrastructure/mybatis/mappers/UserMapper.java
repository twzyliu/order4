package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.User.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public interface UserMapper {
    void createUser(@Param("info") Map<String ,Object> userinfo);

    User find_user_by_userid(@Param("id") int userid);
}
