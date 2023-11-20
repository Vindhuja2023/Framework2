package com.naveenautomationlabs.enums;

public enum TopNavBar {
	DESKTOPS("Desktops"), LAPTOPS_AND_NOTEBOOKS("Laptops & Notebooks"), COMPONENTS("Components"), TABLETS("Tablets"),
	SOFTWARE("Software"), PHONE_AND_PDAS("Phones & PDAs"), CAMERAS("Cameras"), MP3_PLAYERS("MP3 Players");

	public String topNavMenu;

	TopNavBar(String topNavMenu) {
		this.topNavMenu = topNavMenu;
	}

	public String getTopNavBar() {
		return topNavMenu;
	}

}
