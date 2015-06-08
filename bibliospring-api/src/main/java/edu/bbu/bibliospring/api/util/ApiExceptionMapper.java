package edu.bbu.bibliospring.api.util;

import edu.bbu.bibliospring.backend.service.exception.ServiceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author zsvitalyos
 */
public class ApiExceptionMapper implements ExceptionMapper<Exception> {    

    @Override
    public Response toResponse(final Exception exception) {
        Response.Status errorCode = Response.Status.INTERNAL_SERVER_ERROR;
        if (exception instanceof ServiceException) {
            errorCode = Response.Status.BAD_REQUEST;
        }
        return Response.status(errorCode).entity(exception.getMessage()).build();
    }
}
