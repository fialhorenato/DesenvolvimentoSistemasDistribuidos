package org;

public class Cannibal extends Thread {

	private Buffer Buffer;

	public Cannibal(Buffer buffer) {
		this.Buffer = buffer;
	}

	@Override
	public synchronized void run() {
		synchronized (Buffer) {

			while (true) {
				while (Buffer.getPorcoes() == 0) {
					try {
						Buffer.wait();
					} catch (InterruptedException e) {
					}
				}

				if (Buffer.getPorcoes() != 0) {
					Buffer.withdraw(1);
					Buffer.notifyAll();
					System.out
							.println("Cannibal " + this.getId() + " just ate and the pot now have "
									+ Buffer.getPorcoes() + " portions!");
				}

			}

		}
	}
}
