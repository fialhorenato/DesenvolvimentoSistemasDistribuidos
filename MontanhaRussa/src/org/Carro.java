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
			this.notifyAll();
		}
		System.out.println("Carro está carregando e tem " + atual + " passageiros!" );
	}
	
	public synchronized void andar() {
		if (atual == maxSize) {
			this.estado = 2;
			System.out.println("Carro partiu com " + atual + " passageiros!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.estado = 3;
		}		
	}
	
	public synchronized void descarregar() {
		this.estado = 3;
		if (atual > 0) {
			atual --;
			this.notifyAll();
		}
		
		if (atual == 0) {
			this.estado = 1;
		}
		System.out.println("Carro está descarregando e tem " + atual + " passageiros!");
	}
	
	public synchronized int getEstado() {
		return this.estado;
	}

}
