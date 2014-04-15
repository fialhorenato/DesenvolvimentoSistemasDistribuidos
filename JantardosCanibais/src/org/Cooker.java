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
		while (true) {
			Buffer.deposit(this.getId());
		}
	}
}