import java.util.concurrent.*;
import java.util.*;

class Pessoa implements Runnable{
        String nome;
		MontanhaRussa montanha;		
		int estado;

		Pessoa(String nome, MontanhaRussa montanha){
			this.nome = nome;
			this.montanha = montanha;
		}

		void entra_no_parque(){
			System.out.println(this.nome + " entrou no parque.");
			System.out.flush();
		}

		void entra_na_fila(){
			montanha.poe_na_fila(this);
		}

		void sai_do_parque(){
			System.out.println(this.nome + " sai do parque.");
			System.out.flush();
		}

		void espera_a_vez(){
			while(this.estado == 0){
				try {
					System.out.println(this.nome + " espera a vez.");
					System.out.flush();
					Thread.sleep(1000);
				}catch (InterruptedException e) {}
			}
		}

		public void run(){
			this.entra_no_parque();
			this.entra_na_fila();
			this.espera_a_vez();
			this.sai_do_parque();
		}
}
