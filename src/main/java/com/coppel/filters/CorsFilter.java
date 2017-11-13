/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coppel.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author emmanuel
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {
    /**
     * Crea los filtros para habilitar las peticiones de diferentes dominios 
     * y los tipos de peticiones
     * @param requestContext
     * @param response
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "content-type, token, AUTHORIZATION");
    }
}
