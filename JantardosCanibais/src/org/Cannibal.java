package org;

public class Cannibal extends Thread {

	private Buffer Buffer;

	public Cannibal(Buffer buffer) {
		this.Buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			Buffer.withdraw(this.getId());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}