package org.com.perso.footcelad.hmi.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class HomePage extends Composite implements IHomePage {

	private static HomePageUiBinder uiBinder = GWT
			.create(HomePageUiBinder.class);

	interface HomePageUiBinder extends UiBinder<Widget, HomePage> {
	}

	@UiField
	PushButton home;

	@UiField(provided = true)
	FlexTable table;

	public HomePage() {
		HomePageResources.INSTANCE.css().ensureInjected();

		setupTable();
		
		setupButtons();

		initWidget(uiBinder.createAndBindUi(this));
	}

	private void setupButtons() {
	}

	private void setupTable() {
		table = new FlexTable();
		table.setText(0, 0, "Names");
		table.setText(0, 1, "Dispos");
		table.setText(0, 2, "Comments");
		table.setText(0, 3, "Convocation");
	}

	@Override
	public void setPresenter() {

	}

//	@UiHandler("home")
//	public void onHomeButtonClick(ClickEvent event) {
//		home.setText("yes");
//	}
}
