package com.minegocio.home.controller;

public class MenuDTO {
	public String menu;
	public String URL;
	public String ICON;
	public String permission;
	
	
	public MenuDTO() {
		super();
	}

	public MenuDTO(String menu, String uRL, String iCON, String permission) {
		this.menu = menu;
		URL = uRL;
		ICON = iCON;
		this.permission = permission;
	}
	
	
}
