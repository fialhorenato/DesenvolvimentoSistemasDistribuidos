package principal;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		Random gerador = new Random();
		int valor = 85;
		
		LinkedList<Integer> lista = new LinkedList();
		
		for (int i=0; i <= 99; i++){
		lista.add(gerador.nextInt(100));
		} 
		
		/*ListIterator<Integer> listaIN = lista.listIterator();
		ListIterator<Integer> listaIN2 = lista.listIterator(lista.size());
		
		while (listaIN.hasNext()){
			System.out.println(listaIN.next() + ">" + listaIN.previousIndex());
		}
		System.out.println("----------------");
		
		while (listaIN.hasPrevious()){
			System.out.println(listaIN.previous() + "<" + listaIN.nextIndex());
		}*/
		
		Procura p1 = new Procura(lista, valor);
		Procura p2 = new Procura(valor, lista);
		p1.start();
		p2.start();
		
		if (p1.getResult() == 0){
			System.out.println("Não encontrado!");
		}else{
			System.out.println(p1.getResult() + ">");
			System.out.println(p2.getResult() + "<");	
		}
		

	}

}
