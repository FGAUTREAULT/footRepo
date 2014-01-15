package org.com.perso.footcelad.hmi.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

public interface CustomToggleMenuButtonResources extends ClientBundle {
	public static final CustomToggleMenuButtonResources INSTANCE = GWT
			.create(CustomToggleMenuButtonResources.class);

	@Source("org/com/perso/footcelad/hmi/client/widgets/CustomToggleMenuButton.css")
	public CustomToggleMenuButtonCss css();

	// MENU
	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnUP.png")
	DataResource menuUp();

	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnDown.png")
	DataResource menuDown();
	
	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnOver.png")
	DataResource menuOver();

	// CSS
	public interface CustomToggleMenuButtonCss extends CssResource {
		
		String menuBtns();
		
	}

}
