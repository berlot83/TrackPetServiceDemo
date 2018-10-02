package com.service.exceptions;

import javax.ws.rs.core.Response;

public class WebApplicationException extends Exception{

	Response response;
	
	public WebApplicationException(Response response) {
		this.response = response;
	}
	
}
