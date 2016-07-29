package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.User.User;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 16/7/29.
 */
@RunWith(DatabaseTestRunner.class)
public class UserDOTest {
    @Inject
    UserRepository userRepository;

    @Test
    public void find_user_by_userid() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        User user = userRepository.find_user_by_userid(userid);
        assertThat(user.getName(), is("zyl"));
    }

}
