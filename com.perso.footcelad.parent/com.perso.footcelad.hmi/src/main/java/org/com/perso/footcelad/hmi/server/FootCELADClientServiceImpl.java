package org.com.perso.footcelad.hmi.server;

import org.com.perso.footcelad.hmi.client.FootCELADClientService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class FootCELADClientServiceImpl extends RemoteServiceServlet implements
		FootCELADClientService {

	public String greetServer(String input) throws IllegalArgumentException {
		return null;
	}

}
