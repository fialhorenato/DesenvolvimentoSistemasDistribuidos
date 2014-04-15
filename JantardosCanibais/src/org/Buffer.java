package org;

public class Buffer {

		private int maxSize;

		public Buffer() {};

		public synchronized int getPorcoes() {
			return maxSize;
		}

		public synchronized void setPorcoes(int size) {
			this.maxSize = size;
		}

		public synchronized void withdraw(int num, long id) {
			
			if (maxSize == 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				this.maxSize = this.maxSize - num;
				this.notifyAll();
				System.out.println("Cannibal " + id + " ate " + num + " portions in the pot!" );
			}
			
		}

		public synchronized void deposit(int num, long id) {	
			if (maxSize != 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				this.maxSize = this.maxSize + num;
				this.notifyAll();
			System.out.println("Cooker " + id + " deposit " + num + " portions in the pot!" );
			}
			
		}		

}