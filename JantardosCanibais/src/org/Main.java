package org;

public class Main {

	public static void main(String[] args) {
		
		int size = 50;
		int numberOfCannibals = 500;
		int numberOfCookers = 50;
		
		Buffer Buffer = new Buffer();
		
		for (int i = 0; i < numberOfCookers; i++) {
			new Cooker(Buffer, size).start();;
		}
		
		for (int i = 0; i < numberOfCannibals; i++) {
			new Cannibal(Buffer).start();
		}
		


	}

}
