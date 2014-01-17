package org.com.perso.footcelad.hmi.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.event.MapClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
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

	@UiField
	MapWidget map;

	public HomePage() {
		HomePageResources.INSTANCE.css().ensureInjected();

		setupTable();
		initWidget(uiBinder.createAndBindUi(this));
		
		LatLng toulouse = LatLng.newInstance(43.597518,1.445468);
		map.setCenter(toulouse);
		map.setZoomLevel(11);
		map.setSize("150px", "240px");
		map.addControl(new LargeMapControl());
		map.addOverlay(new Marker(toulouse));
		map.addMapClickHandler(new MapClickHandler() {
			
			@Override
			public void onClick(MapClickEvent event) {
				Window.open("https://maps.google.fr/maps?saddr=43.612477,1.382804&daddr=43.605447,1.424046", "_blank", "");
			}
		});
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

//	@UiHandler("map")
//	@Override
//	public void onMapClick(MapClickEvent event) {
//		Window.open("https://maps.google.fr/maps?q=maps&ie=UTF-8&ei=NgbZUsP-Iams0QXy1oCgBw&ved=0CAoQ_AUoAg", "_blank", "");
//	}
}
