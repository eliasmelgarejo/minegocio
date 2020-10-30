package com.minegocio.core;

public class Credencial {
	
	private String username;
	private String password;
			
	public Credencial() {}
	
	public Credencial(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
