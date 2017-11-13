/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coppel.filters;

import java.io.IOException;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author elzafirox
 */
@Provider
public class SSOFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //No es necesario checar options
        if( requestContext.getMethod().equals(HttpMethod.OPTIONS)) {
            requestContext.abortWith(Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                    .header("Access-Control-Allow-Headers", "content-type, token, Authorization")
                    .build());
        }
        
        /*String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        String token = null;
        Gson gson = new Gson();
        
        // Comprobamos si se proporciono el token
        if (authorizationHeader == null ) {            
            // Regresamos el mensaje de error.            
            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .type(MediaType.APPLICATION_JSON)
                    .entity( gson.toJson(new ErrorResponse("Ocurrio un error"
                            ,"No se proporciono un token de sesion valido.") ))
                    .build());
            return;
        }else{
            // Extraemos el token.
            token = authorizationHeader.trim();
        }
        
        try {
            validateToken(token);
        } catch (Exception e) {
            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .type(MediaType.APPLICATION_JSON)
                    .entity( gson.toJson(new Error( e.getMessage() )) )
                    .build()
            );
        }*/
        
    }
    
    // Metodo para consultar la validez del token
    private void validateToken(String token) throws Exception {
        // URL para comprobar el token
        
        String url = "http://10.44.15.214/api/v1/verify";
        
        Client client = ClientBuilder.newClient();
        Response res = client.target(url)
                                .request("application/json")
                                .header(HttpHeaders.AUTHORIZATION, token)
                                .post(null);
        // Comprobamos el estatus de respuesta.
        if( (int) res.getStatus() != HttpServletResponse.SC_OK ){
            throw new Exception("El token de sesion proporcionado no es valido.");
        }
        
    }
}
