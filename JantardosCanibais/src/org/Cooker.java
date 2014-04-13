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
				while (Buffer.getPorcoes() >= this.size) {
					try {
						Buffer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				synchronized (Buffer) {

					if (Buffer.getPorcoes() >= 0) {
						Buffer.deposit(1);
						System.out.println("Cooker " + this.getId()
								+ " deposit on the pot and now have "
								+ Buffer.getPorcoes() + " portions!");
						Buffer.notifyAll();
						try {
							Buffer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}
	}
}
