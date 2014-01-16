package org.com.perso.footcelad.hmi.client.widgets.ctgbmenu;

import javax.xml.bind.annotation.XmlAttribute;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;

public class CustomToggleMenuButton extends Composite implements HasClickHandlers{

	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CustomToggleMenuButton> {
		
	}
	
	@XmlAttribute
	String upText;
	
	@XmlAttribute
	String downText;
	
	@XmlAttribute
	boolean isDown;

	@UiField
	ToggleButton button;

	@UiConstructor
	public CustomToggleMenuButton(String upText, String downText, boolean isDown) {
		CustomToggleMenuButtonResources.INSTANCE.css().ensureInjected();
		initWidget(binder.createAndBindUi(this));
		
		//Init widget arguments
		setUpText(upText);
		setDownText(downText);
		setDown(isDown);
	}
	
	public void setDown(boolean isDown) {
		this.isDown = isDown;
		button.setDown(isDown);
	}

	public void setUpText(String upText) {
		this.upText = upText;
		button.getUpFace().setText(upText);
	}
	
	public void setDownText(String downText) {
		this.downText = downText;
		button.getDownFace().setText(downText);
	}
	
	public boolean isDown() {
		return isDown;
	}
	
	public HandlerRegistration  addClickHandler(ClickHandler handler) {
		return button.addClickHandler(handler);
	}
	
	@Override
	public String getTitle() {
		return upText;
	}

	public void setText(String text) {
		setDownText(text);
		setUpText(text);
	}

}
