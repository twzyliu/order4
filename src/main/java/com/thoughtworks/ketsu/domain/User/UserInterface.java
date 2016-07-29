package com.thoughtworks.ketsu.domain.User;

import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
public interface UserInterface {
    void createUser(Map<String ,Object>userinfo);

    User find_user_by_userid(int userid);
}
