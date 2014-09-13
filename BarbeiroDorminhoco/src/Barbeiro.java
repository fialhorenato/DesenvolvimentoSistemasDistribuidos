
public class Barbeiro extends Thread {

	private BarbeiroMonitor bd = null;
	
	public Barbeiro(BarbeiroMonitor bd) {
		this.bd = bd;
	}
	
	@Override
	public void run() {
		while(true) {
			bd.inicioCorte();
			
			System.out.println("Barbeiro cortando cabelo");
			try {Thread.sleep(2000);} catch (InterruptedException e) {}
			
			bd.fimcorte();
		}
	}

}
