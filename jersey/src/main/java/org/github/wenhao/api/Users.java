package org.github.wenhao.api;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.github.wenhao.model.User;

@Path("users")
public class Users
{
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Response get(@PathParam("id") String id)
    {
        return Response.ok().entity(new User("jack", 30)).build();
    }

    @POST
    @Produces("application/json")
    public Response create(@Valid User user)
    {
        return Response.ok().entity(user).build();
    }
}
