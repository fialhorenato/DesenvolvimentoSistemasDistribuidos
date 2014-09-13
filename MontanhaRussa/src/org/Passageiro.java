package org;

public class Passageiro extends Thread {

	private MontanhaRussa m;
	private int estado = 1;

	public Passageiro(MontanhaRussa m) {
		this.m = m;
	}

	@Override
	public void run() {
		while (true) {
			if (estado == 1) {
				m.embarcar(this.getId());
				estado = 2;
			}

			if (estado == 2) {
				m.desembarcar(this.getId());
				estado = 1;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
