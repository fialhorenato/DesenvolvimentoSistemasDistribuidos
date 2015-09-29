import java.util.concurrent.*;
import java.util.*;

public class Parque{
	public static void main(String[] args) {
		System.out.println("Parque abriu.");
		System.out.flush();

		final String[] nomes = {"Ana", "Boris", "Carla", "Dario", "Emilia", "Felipe", "Georgia", "Heitor", "Ivete", "Jorge"};		
		final int n = nomes.length;
		
		MontanhaRussa montanha = new MontanhaRussa();
		montanha.start();

		Thread pessoas[] = new Thread[n];

		// Cria e lança n pessoas
		for(int i=0;i<n;i++){
			pessoas[i] = new Thread(new Pessoa(nomes[i], montanha));
			pessoas[i].start();
		}

		// Espera as n pessoas sairem do parque
		for(int i=0;i<n;i++){			
			try{ pessoas[i].join(); }catch (InterruptedException e) {}
		}

		// Fecha o parque
		System.out.println("Parque fechou.");
		System.out.flush();
	}
}