package org;

public class Main {

	public static void main(String[] args) {
		
		int passageiros = 10;
		int carros = 1;
		int tamanhoCarro = 5;
		
		MontanhaRussa m = new MontanhaRussa(tamanhoCarro);
		
		for (int i = 0; i < carros; i++) {
			new Carro(m).start();			
		}
		
		for (int i = 0; i < passageiros; i++) {
			new Passageiro(m).start();			
		} 
		
		
		
		
		
	}

}
