package controller;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserServlet {

    private UserService userService = new UserServiceImpl();

//    http://localhost:8080/api/user/findAll

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<User> result = userService.getAll();
        return result != null ?
                Response.ok().entity(result).build() :
                Response.noContent().build();
    }

    //    http://localhost:8080/api/user/balance
    @GET
    @Path("/balance")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBalanceById() {
        List<User> result = userService.getBalanceById();
        return result != null ?
                Response.ok().entity(result).build() :
                Response.noContent().build();
    }
}
