package com.service.controllers;

import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import com.service.exceptions.WebApplicationException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.core.util.Base64;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Provider
public class AuthController implements ContainerRequestFilter  {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String CONTROLLERS_PREFIX = "test";

	@Override
	public ContainerRequest filter(ContainerRequest requestContext) {
		
	if(requestContext.getPath().contains(CONTROLLERS_PREFIX)) {
		System.out.println(requestContext.getBaseUri().getPath());
		List<String> authHeader = requestContext.getRequestHeader(AUTHORIZATION_HEADER_KEY);
		if(authHeader != null && authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = Base64.base64Decode(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			if("username".equals(username) && "password".equals(password)) {
				
			}
		}else {
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity("No puede ingresar a este servicio").build();
			try {
				throw new WebApplicationException(unauthorizedStatus);
			} catch (WebApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}else {
	System.out.println("No se encuentra la palabra indicada en el URI requerido");
	}
		return null;
	}

}
