package org;

public class Main {

	public static void main(String[] args) {
		
		int tamanho = 10;
		
		Buffer Buffer = new Buffer();
		Cooker Cooker = new Cooker(Buffer, tamanho);
		Cannibal Eater = new Cannibal(Buffer);

		Cooker.start();
		Eater.start();

	}

}
