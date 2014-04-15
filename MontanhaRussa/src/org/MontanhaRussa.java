package org;

public class MontanhaRussa {

	private int maxSize;
	private int atual = 0;
	private int estadoCarro = 1;

	public MontanhaRussa(int maxSize) {
		this.maxSize = maxSize;
	}

	public synchronized void carregar() {

		while (this.atual != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (this.atual == 0) {
			this.estadoCarro = 1;
			System.out.println("MONTANHA RUSSA CARREGANDO");
		}
		
		this.notifyAll();
		
	}

	public synchronized void descarregar() {

		while (this.atual != this.maxSize) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (this.estadoCarro == 2) {
			this.estadoCarro = 3;
			System.out.println("MONTANHA RUSSA DESCARREGANDO");
		}

		this.notifyAll();
	}

	public synchronized void andar() {
		while (this.atual != this.maxSize) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (this.atual == this.maxSize && this.estadoCarro == 1) {
			this.estadoCarro = 2;
			System.out.println("MONTANHA RUSSA ANDANDO");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.estadoCarro = 3;
		}
		
		this.notifyAll();

	}

	public synchronized void embarcar(long id) {
		while (this.estadoCarro != 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (this.estadoCarro == 1 && this.atual < this.maxSize) {
			atual++;
			System.out.println("PASSAGEIRO " + id + " EMBARCOU");			
		}
		
		this.notifyAll();
	}

	public synchronized void desembarcar(long id) {
		
		while (this.estadoCarro != 3) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (this.estadoCarro == 3 && this.atual > 0) {
			atual--;
			System.out.println("PASSAGEIRO " + id + " DESEMBARCOU");			
		}
		
		this.notifyAll();

	}

}
