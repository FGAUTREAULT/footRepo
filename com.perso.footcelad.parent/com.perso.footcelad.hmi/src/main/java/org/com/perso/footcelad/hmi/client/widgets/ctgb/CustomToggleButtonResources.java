package org.com.perso.footcelad.hmi.client.widgets.ctgb;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

public interface CustomToggleButtonResources extends ClientBundle {
	public static final CustomToggleButtonResources INSTANCE = GWT
			.create(CustomToggleButtonResources.class);

	@Source("org/com/perso/footcelad/hmi/client/widgets/ctgb/CustomToggleButton.css")
	public CustomToggleButtonCss css();

	// MENU
	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnUP.png")
	DataResource tgdUp();

	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnDown.png")
	DataResource tgdDown();
	
	@Source("org/com/perso/footcelad/hmi/imgs/menuBtnOver.png")
	DataResource tgdOver();

	// CSS
	public interface CustomToggleButtonCss extends CssResource {
		
		String tgdBtns();
		
	}

}
