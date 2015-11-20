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

import com.epam.reshetnev.memory.core.entity.Code;
import com.epam.reshetnev.memory.core.service.CodeService;
import com.google.common.base.Preconditions;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * Created by Aleksandr_Reshetnev
 */

@Component
@Path("/v1/codes")
@Api(value = "/v1/codes", description = "Memory codes")
public class CodeResource extends BaseResource {

    private static final Logger LOG = Logger.getLogger(CodeResource.class);

    @Autowired
    private CodeService codeService;

    @GET
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Get list of codes", notes = "Returns all codes")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public List<Code> getAllCodes() throws Exception {

        List<Code> codes = codeService.getAll();

        return codes;
    }

    @GET
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Get code by id", notes = "Returns code with given id")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public Code getCodeById(@PathParam("id") Integer id) throws Exception {

        LOG.info("Getting code by id: [{}] " + id);

        Preconditions.checkNotNull(id, "Code id should not be null");

        Code code = codeService.getById(id);

        return code;
    }

    @POST
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Create code", notes = "Returns new code")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public Response createCode(Code code) throws Exception {

        LOG.info("Creating code: [{}] " + code.toString());

        Preconditions.checkNotNull(code.getName(), "Code Name should not be null");
        Preconditions.checkNotNull(code.getPassword(), "Code Password should not be null");
        Preconditions.checkNotNull(code.getGroup(), "Code Group should not be null");
        Preconditions.checkNotNull(code.getUser(), "Code User should not be null");

        return Response.ok(codeService.add(code)).build();
    }

    @PUT
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Update code", notes = "Returns updated code")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public Code updateCode(@PathParam("id") Integer id, Code newCode) throws Exception {

        LOG.info("Updating code with id: [{}] "+ id);

        Preconditions.checkNotNull(id, "Code id should not be null");

        return codeService.update(id, newCode);
    }

    @DELETE
    @Path("/{id : (\\d+)}")
    @Produces({JSON_UTF_8})
    @ApiOperation(value = "Delete code", notes = "Returns all codes")
    @ApiResponses(value = {
            @ApiResponse(code = ERROR_400, message = ERROR_400_MESSAGE),
            @ApiResponse(code = ERROR_404, message = ERROR_404_MESSAGE),
            @ApiResponse(code = ERROR_503, message = ERROR_503_MESSAGE)})
    public List<Code> deleteCode(@PathParam("id") Integer id) {

        LOG.info("Deleting code with id: [{}] " + id);

        Preconditions.checkNotNull(id, "Code id should not be null");

        codeService.delete(id);

        List<Code> codes = codeService.getAll();

        return codes;
    }

}
