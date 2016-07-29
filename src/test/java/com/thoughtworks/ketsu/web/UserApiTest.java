package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 16/7/29.
 */
@RunWith(ApiTestRunner.class)
public class UserApiTest extends ApiSupport{
    @Inject
    UserRepository userRepository;

    @Test
    public void return_201_when_POST_users_with_parameters() {
        Response post = post("/users", TestHelper.userMap());
        assertThat(post.getStatus(),is(201));
    }

    @Test
    public void return_400_when_POST_fails() {
        Response post = post("/users", TestHelper.userfailMap());
        assertThat(post.getStatus(),is(400));
    }

    @Test
    public void return_user_when_GET_user_by_userid() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Response get = get("/users/" + userid);
        Map user = get.readEntity(Map.class);
        assertThat(user.get("name"),is("zyl"));
    }

    @Test
    public void return_404_when_GET_user_by_id_fails() {
        Response get = get("/users/a");
        assertThat(get.getStatus(),is(404));
    }

}
