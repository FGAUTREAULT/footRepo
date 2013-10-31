/**
 * 
 */
package org.com.perso.footcelad.hmi.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Fabien Gautreault
 *
 */
public interface FootCELADClientServiceAsync {

	void greetServer(String textToServer, AsyncCallback<String> asyncCallback);

}
