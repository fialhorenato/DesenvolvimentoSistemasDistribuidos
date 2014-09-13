package principal;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listaordenada = new ArrayList<Integer>();
		
		lista.add(9);
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(4);
		lista.add(7);
		lista.add(6);
		lista.add(5);
		
		System.out.println(lista.size());
		
		for (int i = 0; i < lista.size(); i++){
			System.out.print(lista.get(i) + "\t");
		}
		
		
		

	}

}
