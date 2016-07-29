package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.User.User;
import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/29.
 */
@Path("users")
public class UserApi {
    @Context
    UserRepository userRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Map<String,Object> userinfo) {
        if (userinfo.get("name") != null) {
            userRepository.createUser(userinfo);
            return Response.status(201).build();
        }else
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @Path("{userid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User find_user_by_userid(@PathParam("userid") int userid) {
        User user =  userRepository.find_user_by_userid(userid);
        if(user!=null)
            return user;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }


}
