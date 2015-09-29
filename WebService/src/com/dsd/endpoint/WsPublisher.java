package com.dsd.endpoint;

import javax.xml.ws.Endpoint;
import com.dsd.ws.ServerInfo;

public class WsPublisher {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:8888/ws/server", new ServerInfo());
		System.out.println("Service is published!");
		
	}

}