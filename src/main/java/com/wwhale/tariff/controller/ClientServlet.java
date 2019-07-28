package com.wwhale.tariff.controller;

import com.wwhale.tariff.entity.Client;
import com.wwhale.tariff.service.ClientService;
import com.wwhale.tariff.service.impl.ClientServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class ClientServlet {

    private ClientService clientService = new ClientServiceImpl();

//    http://localhost:8080/api/json/clients/findAll

    @GET
    @Path("/json/clients/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Client> result = clientService.findAll();
        return result != null ?
                Response.ok().entity(result).build() :
                Response.noContent().build();
    }

    //     http://localhost:8080/xml/clients/findAll
    @GET
    @Path("/xml/clients/findAll")
    @Produces(MediaType.APPLICATION_XML)
    public Response findBalanceById() {
        List<Client> result = clientService.findAll();
        return result != null ?
                Response.ok().entity(result).build() :
                Response.noContent().build();
    }
}
