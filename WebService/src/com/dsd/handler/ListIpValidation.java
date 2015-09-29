package com.dsd.handler;

import java.util.ArrayList;

public class ListIpValidation {

	private ArrayList<String> listIP = new ArrayList<>();

	public ListIpValidation() {
		listIP.add("192.168.1.106");
		listIP.add("192.168.1.107");
		listIP.add("192.168.1.108");
		listIP.add("192.168.1.109");
		listIP.add("192.168.1.110");
	}

	public ArrayList<String> getListIP() {
		return listIP;
	}

	public void setListIP(ArrayList<String> listIP) {
		this.listIP = listIP;
	}
	
}
