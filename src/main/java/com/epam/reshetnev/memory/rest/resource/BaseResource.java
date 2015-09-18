package com.epam.reshetnev.memory.rest.resource;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ParamException;

import com.epam.reshetnev.memory.rest.util.HtmlApiUtil;

public class BaseResource {

    protected static final String JSON_UTF_8 = MediaType.APPLICATION_JSON + ";charset=UTF-8";

    protected static final int ERROR_400 = 400;
    protected static final String ERROR_400_MESSAGE = "Invalid parameters supplied";
    protected static final int ERROR_404 = 404;
    protected static final String ERROR_404_MESSAGE = "Record with supplied parameters not found";
    protected static final int ERROR_503 = 503;
    protected static final String ERROR_503_MESSAGE = "Exception";

    private static final Logger LOG = Logger.getLogger(BaseResource.class);

    @Provider
    public static class InvalidArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
        @Override
        public Response toResponse(IllegalArgumentException e) {
            return HtmlApiUtil.respondNotFound(e.getMessage());
        }
    }

    @Provider
    public static class PageNotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
        @Override
        public Response toResponse(NotFoundException e) {
            return HtmlApiUtil.respondNotFound(e.getMessage());
        }
    }

    @Provider
    public static class ParamExceptionMapper implements ExceptionMapper<ParamException> {
        @Override
        public Response toResponse(ParamException e) {
            return HtmlApiUtil.respondNotFound(e.getMessage());
        }
    }

    @Provider
    public static class InternalErrorExceptionMapper implements ExceptionMapper<Exception> {
        @Override
        public Response toResponse(Exception e) {
            if (!(e instanceof WebApplicationException)) {
                LOG.info(e.getClass().getName() + " " + e.getMessage(), e);
            }
            return HtmlApiUtil.respondUnavailable(e.getMessage());
        }
    }

}
