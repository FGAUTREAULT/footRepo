package org.com.perso.footcelad.hmi.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

public interface HomePageResources extends ClientBundle {
	public static final HomePageResources INSTANCE = GWT
			.create(HomePageResources.class);

	@Source("org/com/perso/footcelad/hmi/css/HomePage.css")
	public HomePageCss css();

	// IMAGES
	// Profile
	@Source("org/com/perso/footcelad/hmi/imgs/profile.png")
	ImageResource profile();

	@Source("org/com/perso/footcelad/hmi/imgs/profile-over.png")
	ImageResource profileOver();

	// Disconnect
	@Source("org/com/perso/footcelad/hmi/imgs/disconnect.png")
	ImageResource disconnect();

	@Source("org/com/perso/footcelad/hmi/imgs/disconnect-over.png")
	ImageResource disconnectOver();

	// MAP
	@Source("org/com/perso/footcelad/hmi/imgs/map.png")
	ImageResource map();

	// MENU
	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnUP.png")
	DataResource menuUp();
	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnDown.png")
	DataResource menuDown();

	// CSS
	public interface HomePageCss extends CssResource {
		String home();

		String banner();

		String labels();

		String map();

		String otherBtns();
	}
}
