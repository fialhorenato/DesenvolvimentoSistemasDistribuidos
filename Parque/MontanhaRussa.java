import java.util.concurrent.*;
import java.util.*;

class MontanhaRussa extends Thread{
	private BlockingQueue<Pessoa> queue = new LinkedBlockingQueue<Pessoa>();
	int vagas = 2; // Limite de pessoas por carrinho
	int contador = 5; // Carros que vao andar hoje
	Pessoa carro[] = new Pessoa[vagas];

	public synchronized void poe_na_fila(Pessoa p){
		System.out.println("Montanha Russa coloca "+p.nome+" na fila.");
		queue.add(p);
		p.estado = 0;
	}

	public void sai_um_carro(){
		// Tira as R pessoas da fila
		for(int i=0;i<vagas;i++){
			System.out.println("Montanha Russa chama alguem da fila.");
			System.out.flush();

			while(carro[i]==null){
				//synchronized(this){
					try{
						carro[i] = queue.take();
						//carro[i] = queue.poll(500, TimeUnit.MILLISECONDS);
					}catch (InterruptedException e) {}
				//}
				//if(carro[i]==null)try{ Thread.sleep(1000); }catch (InterruptedException e) {}
			}
			synchronized(this){
				carro[i].estado = 1;
			}

			System.out.println("Montanha Russa coloca "+carro[i].nome+" no carro "+Integer.toString(this.contador)+" na cadeira "+Integer.toString(i)+".");
			System.out.flush();
		}
		System.out.println("Montanha Russa libera o carro "+Integer.toString(this.contador)+".");
		System.out.flush();
	}

	public void abre_montanha_russa(){
		System.out.println("Montanha Russa abriu.");
		System.out.flush();
	}

	public void fecha_montanha_russa(){
		System.out.println("Montanha Russa fechou.");
		System.out.flush();
	}

	public void run(){
		this.abre_montanha_russa();
		while(this.contador > 0){
			this.sai_um_carro();
			
			// Avisa as pessoas para brincarem
			for(int i=0;i<vagas;i++)
				carro[i].estado = 1;
			
			// Esvazia o carro
			for(int i=0;i<vagas;i++)
				carro[i] = null;

			// Menos um carro por hoje
			this.contador--;
		}
		this.fecha_montanha_russa();
	}
}