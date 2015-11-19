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

import com.epam.reshetnev.memory.core.entity.Group;
import com.epam.reshetnev.memory.core.service.GroupService;
import com.google.common.base.Preconditions;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * Created by Aleksandr_Reshetnev
 */

@Component
@Path("/v1/groups")
@Api(value = "/v1/groups", description = "Memory groups")
public class GroupResource extends BaseResource {

    private static final Logger LOG = Logger.getLogger(GroupResource.class);

    @Autowired
    private GroupService groupService;

    @GET
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Get list of groups", notes = "Returns all groups")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public List<Group> getAllGroups() throws Exception {

        List<Group> groups = groupService.getAll();

        return groups;
    }

    @GET
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Get group by id", notes = "Returns group with given id")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public Group getGroupById(@PathParam("id") Integer id) throws Exception {

        LOG.info("Getting group by id: [{}] " + id);

        Preconditions.checkNotNull(id, "Group id should not be null");

        Group group = groupService.getById(id);

        return group;
    }

    @POST
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Create group", notes = "Returns new group")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public Response createGroup(Group group) throws Exception {

        LOG.info("Creating group: [{}] " + group.toString());

        Preconditions.checkNotNull(group.getName(), "group Name should not be null");

        return Response.ok(groupService.add(group)).build();
    }

    @PUT
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Update group", notes = "Returns updated group")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public Group updateGroup(@PathParam("id") Integer id, Group newGroup) throws Exception {

        LOG.info("Updating group with id: [{}] "+ id);

        Preconditions.checkNotNull(id, "Group id should not be null");

        return groupService.update(id, newGroup);
    }

    @DELETE
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Delete group", notes = "Returns all groups")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public List<Group> deleteCode(@PathParam("id") Integer id) {

        LOG.info("Deleting group with id: [{}] " + id);

        Preconditions.checkNotNull(id, "Group id should not be null");

        groupService.delete(id);

        List<Group> groups = groupService.getAll();

        return groups;
    }

}
