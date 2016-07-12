package com.epam.reshetnev.memory.rest.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.reshetnev.memory.core.entity.User;
import com.epam.reshetnev.memory.core.service.UserService;
import com.google.common.base.Preconditions;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * Created by Aleksandr_Reshetnev
 */

@Component
@Path("/v1/users")
@Api(value = "/v1/users", description = "Memory users")
public class UserResource extends BaseResource {

    private static final Logger LOG = Logger.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @GET
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Get list of users", notes = "Returns all users")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public List<User> getAllUsers() throws Exception {

        List<User> users = userService.findAll();

        return users;
    }

    @GET
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Get user by id", notes = "Returns user with given id")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public User getUserById(@PathParam("id") Integer id) throws Exception {

        LOG.info("Getting user by id: [{}] " + id);

        Preconditions.checkNotNull(id, "User id should not be null");

        User user = userService.findById(id);

        return user;
    }

    @GET
    @Path("/{login}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Get user by login", notes = "Returns user with given login")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public User getUserByLogin(@PathParam("login") String login) throws Exception {

        LOG.info("Getting user by login: [{}] " + login);

        Preconditions.checkNotNull(login, "User id should not be null");

        User user = userService.findByEmail(login);

        return user;
    }

    @POST
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Create user", notes = "Returns new user")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public Response createUser(User user) throws Exception {

        LOG.info("Creating user: [{}] " + user.toString());

        Preconditions.checkNotNull(user.getName(), "User Name should not be null");
        Preconditions.checkNotNull(user.getEmail(), "User Email should not be null");
        Preconditions.checkNotNull(user.getPassword(), "User Password should not be null");

        return Response.ok(userService.save(user)).build();
    }

    @PUT
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Update user", notes = "Returns updated user")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public User updateUser(@PathParam("id") Integer id, User newUser) throws Exception {

        LOG.info("Updating user with id: [{}] "+ id);

        Preconditions.checkNotNull(id, "User id should not be null");

        return userService.update(id, newUser);
    }

    @DELETE
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Delete user", notes = "Returns all users")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public List<User> deleteUser(@PathParam("id") Integer id) {

        LOG.info("Deleting user with id: [{}] " + id);

        Preconditions.checkNotNull(id, "User id should not be null");

        userService.delete(id);

        List<User> groups = userService.findAll();

        return groups;
    }

}
