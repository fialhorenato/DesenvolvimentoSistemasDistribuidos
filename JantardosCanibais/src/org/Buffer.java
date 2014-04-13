package org;

public class Buffer {

		int maxSize;
		
		public Buffer() {};
		
		public int getPorcoes() {
			return maxSize;
		}

		public void setPorcoes(int size) {
			this.maxSize = size;
		}
		
		public synchronized void withdraw(int num) {
			this.maxSize = this.maxSize - num;
		}
		
		public synchronized void deposit(int num) {			
			this.maxSize = this.maxSize + num;	
		}		
		
}
