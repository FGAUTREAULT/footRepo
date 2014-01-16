package org.com.perso.footcelad.hmi.client.widgets.btngrouppanel;

import java.util.Iterator;

import org.com.perso.footcelad.hmi.client.widgets.ctgbmenu.CustomToggleMenuButton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ButtonGroupPanel extends Composite implements HasWidgets
{

	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, ButtonGroupPanel> {

	}

	@UiField
	VerticalPanel panel;

	public ButtonGroupPanel() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void add(Widget w) {
		if (w instanceof CustomToggleMenuButton) {
			CustomToggleMenuButton button = (CustomToggleMenuButton) w;
			button.addClickHandler(handler);
		}
		panel.add(w);
	}

	@Override
	public void clear() {
		panel.clear();
	}

	@Override
	public Iterator<Widget> iterator() {
		return panel.iterator();
	}

	@Override
	public boolean remove(Widget w) {
		return panel.remove(w);
	}
	
	private ClickHandler handler = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			Iterator<Widget> itr = panel.iterator();
			System.out.println(event.getSource() instanceof CustomToggleMenuButton);
			while (itr.hasNext()) {
				Widget w = itr.next();
				if (w instanceof CustomToggleMenuButton) {
					CustomToggleMenuButton button = (CustomToggleMenuButton) w;
					if(button.getTitle().equalsIgnoreCase(((ToggleButton) event.getSource()).getText())){
						button.setDown(true);
					}
					else{
						button.setDown(false);
					}
				}
			}

		}
	};

}
