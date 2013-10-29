/**
 * 
 */
package org.com.perso.footcelad.hmi.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author ktf01464
 *
 */
public interface FootCELADClientServiceAsync {

	void greetServer(String textToServer, AsyncCallback<String> asyncCallback);

}
