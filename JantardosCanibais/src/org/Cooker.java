package org;

public class Cooker extends Thread {

	private Buffer Buffer;
	int size;

	public Cooker(Buffer Buffer, int size) {
		this.Buffer = Buffer;
		this.size = size;
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

				if (Buffer.getPorcoes() == 0) {
					Buffer.deposit(this.size);
					System.out.println("Cooker " + this.getId() + " deposited "
							+ this.size + " portions on the pot and now have "
							+ Buffer.getPorcoes() + " portions!");
					Buffer.notifyAll();

				}

			}
		}
	}
}
