package org;

public class Cooker extends Thread {

	private Buffer Buffer;
	int tamanho;

	public Cooker(Buffer Buffer, int tamanho) {
		this.Buffer = Buffer;
		this.tamanho = tamanho;
	}

	@Override
	public void run() {
		synchronized (Buffer) {
			while (true) {
				while (Buffer.getPorcoes() != 0) {
					try {
						Buffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				synchronized (Buffer) {
					if (Buffer.getPorcoes() == 0) {
						Buffer.deposita(tamanho);
						Buffer.notifyAll();
						System.out
								.println("Cooker deposit on the pot and now have "
										+ Buffer.getPorcoes() + "portions");
					}
				}

			}
		}
	}
}
