package org.com.perso.footcelad.hmi.client;

import org.com.perso.footcelad.hmi.client.view.HomePage;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FootCELADClient implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final FootCELADClientServiceAsync greetingService = GWT.create(FootCELADClientService.class);

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  
	  
	  RootLayoutPanel.get().add(new HomePage().asWidget());
	  
  }
}
