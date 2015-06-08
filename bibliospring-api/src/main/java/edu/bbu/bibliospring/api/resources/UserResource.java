package edu.bbu.bibliospring.api.resources;

import edu.bbu.bibliospring.api.assembler.BaseAssembler;
import edu.bbu.bibliospring.api.assembler.UserAssembler;
import edu.bbu.bibliospring.api.exception.ApiExeption;
import edu.bbu.bibliospring.backend.model.User;
import edu.bbu.bibliospring.backend.service.UserService;
import edu.bbu.bibliospring.backend.service.exception.ServiceException;
import edu.bbu.bibliospring.common.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author zsvitalyos
 */
@LocalBean
@Stateless
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final BaseAssembler<UserDto, User> userAssembler = new UserAssembler();

    @EJB
    private UserService userService;

    @Path("/{id}")
    @GET
    public Response getUserById(@PathParam("id") final Long id) throws ApiExeption {
        try {
            User user = userService.getUserById(id);
            return Response.ok(userAssembler.modelToDto(user)).build();
        } catch (final ServiceException serviceException) {
            throw new ApiExeption("@POST error", serviceException);
        }
    }

    @GET
    public Response getAllUsers() throws ApiExeption {
        try {
            final List<User> users = (List<User>) userService.getAllUsers();
            final List<UserDto> userDtos = new ArrayList<UserDto>();
            for (final User user : users) {
                userDtos.add(userAssembler.modelToDto(user));
            }
            final GenericEntity<List<UserDto>> genericUserDtos
                    = new GenericEntity<List<UserDto>>(userDtos) {
                    };
            return Response.ok(genericUserDtos).build();
        } catch (final ServiceException serviceException) {
            throw new ApiExeption("@POST error", serviceException);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertUser(final UserDto userDto) throws ApiExeption {
        try {
            User user = userAssembler.dtoToModel(userDto);
            userService.insertUser(user);
            return Response.ok().build();
        } catch (final ServiceException serviceException) {
            throw new ApiExeption("@POST error", serviceException);
        }
    }

    @Path("/userId")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser() {
        return Response.ok().build();
    }

    @Path("/userId")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userId") final Long userId) throws ApiExeption {
        try {
            User user = userService.getUserById(userId);
            userService.deleteUser(user);
            return Response.ok().build();
        } catch (final ServiceException serviceException) {
            throw new ApiExeption("@POST error", serviceException);
        }
    }
}
