package org.com.perso.footcelad.hmi.client.view;

import com.google.gwt.maps.client.event.MapClickHandler.MapClickEvent;


public interface IHomePage {

	void setPresenter();
	
	void onMapClick(MapClickEvent event);
	
}
