package org;

public class Main {

	public static void main(String[] args) {

		int numPassengers = 50;

		Carro carro = new Carro(10);

		for (int i = 0; i < numPassengers; i++) {
			new Passageiro(carro).start();
		}
	}

}
