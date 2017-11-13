/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coppel.jersey;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author emmanuel
 */
@ApplicationPath("api")
public class Main extends ResourceConfig {
    public Main() {
        packages("com.coppel.jersey", "com.coppel.filters");
    }
}
