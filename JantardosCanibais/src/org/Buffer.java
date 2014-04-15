package org;

public class Buffer {

		private int maxSize;
		private int actual = 0;

		public Buffer(int maxSize) {
			this.maxSize = maxSize;
			this.actual = maxSize;
		}

		public synchronized void withdraw(long id) {
			
			while (this.actual == 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if (this.actual > 0) {
				this.actual--;				
				System.out.println("Cannibal " + id + " ate a portion in the pot!" );
				System.out.println("STATUS === " + this.actual + " / " + this.maxSize );
			}
			
			this.notifyAll();
		}

		public synchronized void deposit(long id) {	
			while (this.actual != 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if (this.actual == 0) {
				this.actual = this.maxSize;
				System.out.println("Cooker " + id + " filled the pot!" );
				System.out.println("STATUS === " + this.actual + " / " + this.maxSize );
			}
			
			this.notifyAll();
			
		}		

}