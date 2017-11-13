/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coppel.controllers;

import com.coppel.entities.Users;
import com.coppel.models.UsersModel;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author emmanuel
 */
public class UsersController {
    
    public String show(String userName) {
        UsersModel model = new UsersModel();
        JsonObject response = null;
        try {
            response = new JsonObject();
            List<Users> users = model.show(userName);
            if (users.isEmpty()) {
                response.addProperty("disponible", Boolean.TRUE);
            } else {
                response.addProperty("disponible", Boolean.FALSE);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception: " + e.getMessage());
            response = new JsonObject();
            response.addProperty("mensaje", "Ocurrió un error en el servidor.");
            response.addProperty("dev", e.getMessage());
            ResponseBuilder builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(response.toString())
                    .type(MediaType.APPLICATION_JSON);
            throw new WebApplicationException(builder.build());
        }
        
        return response.toString();
    }
}
