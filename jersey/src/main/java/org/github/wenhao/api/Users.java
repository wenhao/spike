package org.github.wenhao.api;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.github.wenhao.model.User;
import org.github.wenhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("users")
public class Users
{
    private UserService userService;

    @Autowired
    public Users(UserService userService)
    {
        this.userService = userService;
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response get(@PathParam("id") String id)
    {
        User user = userService.get(id);
        return Response.ok().entity(user).build();
    }

    @POST
    @Produces("application/json")
    public Response create(@Valid User user)
    {
        return Response.ok().entity(user).build();
    }
}
