package com.epam.reshetnev.memory.rest.util;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class HtmlApiUtil {

    private HtmlApiUtil() {
    }

    public static Response respondHtml(String msg) {
        if (msg == null) {
            throw new NotFoundException(); // provider will handle this exception
        } else {
            return Response.status(Response.Status.OK).entity(msg).type(MediaType.TEXT_HTML).build();
        }
    }

    public static Response respondOK() {
        return Response.status(Response.Status.OK).build();
    }

    public static Response respondNotFound(Object msg) {
        return Response.status(Response.Status.NOT_FOUND).entity(msg).type(MediaType.TEXT_HTML).build();
    }

    public static Response respondUnavailable(Object msg) {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(msg).type(MediaType.TEXT_HTML).build();
    }
}
