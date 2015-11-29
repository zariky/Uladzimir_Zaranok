package com.epam;

public class GearBox {

	private String type;

	public GearBox(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GearBox [type=" + type + "]";
	}
	
}
