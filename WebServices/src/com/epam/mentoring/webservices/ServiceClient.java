package com.epam.mentoring.webservices;

public class ServiceClient {

	public static void main(String[] args) {
		MegaWebService webServ = new MegaWebService();
		webServ.getMessage("Brazil");
	}

}
