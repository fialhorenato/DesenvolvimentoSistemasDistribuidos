package org;

public class Carro extends Thread {
	
	private MontanhaRussa m;

	public Carro(MontanhaRussa m) {
		this.m = m;
	}

	@Override
	public void run() {
		while (true) {
			m.carregar();
			m.andar();
			m.descarregar();
		}
	}

}
