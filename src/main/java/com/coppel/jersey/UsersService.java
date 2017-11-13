/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coppel.jersey;

import com.coppel.controllers.UsersController;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author emmanuel
 */
@Path("usuarios")
public class UsersService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers(@QueryParam("userName") final String userName) {
        UsersController controller = new UsersController();
        return controller.show(userName);
    }
}
