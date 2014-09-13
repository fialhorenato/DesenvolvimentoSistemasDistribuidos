
public class Barbearia {

	public static void main(String[] args) {
		
		BarbeiroMonitor bd = new BarbeiroMonitor(5);
		
		new Barbeiro(bd).start();
		
		for(int i = 1; i <= 20; i++) {
			new Cliente(i,bd).start();
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
	
}
