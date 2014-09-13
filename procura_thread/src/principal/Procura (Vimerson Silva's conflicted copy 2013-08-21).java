package principal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Procura extends Thread{
	private LinkedList<Integer> lista;
	private int valor;
	private int thrd = 0;
	
	public Procura(LinkedList<Integer> lista, int valor){
		this.lista = lista;
		this.valor = valor;		
	}
	
	public void run(){
		thrd++;
		//int cont = 0;
		ListIterator<Integer> listadireta = lista.listIterator();
		ListIterator<Integer> listaInversa = lista.listIterator(lista.size());
		
		
		System.out.println("valor: " + thrd);

		if (thrd == 0){
			Procura p2 = new Procura(lista, valor);
			p2.start();
			thrd++;
		}
		
			
			
			while (listadireta.hasNext()){
				cont++;
				System.out.println(listadireta.next());
			}
			
			thrd++;
			
			if (thrd == 1){
				Procura p3 = new Procura(lista, valor);
				p3.start();
				thrd++;
			}
			
			while(listaInversa.hasPrevious()){
				System.out.println(listaInversa.previous());
			}
		}
		
	}
