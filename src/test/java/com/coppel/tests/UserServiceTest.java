/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coppel.tests;

import com.coppel.jersey.UsersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmanuel
 */
public class UserServiceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(UsersService.class);
    }

    @Test
    public void ordersPathParamTest() {
        String response = target("api/usuarios?userName=edgardrp").request().get(String.class);
        JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
        Assert.assertFalse(jsonResponse.get("disponible").getAsBoolean());
    }

    @Test
    public void ordersFixedPathTest() {
        String response = target("api/usuarios?userName=xxx").request().get(String.class);
        JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
        Assert.assertTrue(jsonResponse.get("disponible").getAsBoolean());
    }
    
}
