package com.cybage.controller;

public class Users {
	private int id;
	private String name;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + "]";
	}
	
}
