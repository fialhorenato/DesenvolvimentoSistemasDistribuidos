package org;

public class Carro extends Thread {

	private int maxSize;
	private int atual;
	private int estado = 1;

	public Carro(int maxSize) {
		this.maxSize = maxSize;
	}

	public synchronized void carregar() {
		this.estado = 1;
		if (atual < maxSize) {
			atual++;
			System.out.println("Carro " + this.getName() + "está carregando passageiros e tem " + this.atual
					+ " passageiros!");
			}
		this.notifyAll();
	}

	public synchronized void andar() {
		if (atual == maxSize) {
			this.estado = 2;
			System.out.println("Carro " + this.getName() + " partiu com " + this.atual + " passageiros!");
			this.estado = 3;
		}		
		this.notifyAll();
	}

	public synchronized void descarregar() {
		this.estado = 3;
		if (atual > 0) {
			atual--;
			this.notifyAll();
		}

		if (atual == 0) {
			this.estado = 1;
		}
		
		System.out.println("Carro está descarregando e tem " + atual
				+ " passageiros!");
		
		this.notifyAll();
	}

	public synchronized int getEstado() {
		return this.estado;
	}

}
