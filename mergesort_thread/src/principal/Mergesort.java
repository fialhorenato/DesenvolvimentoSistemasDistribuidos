package principal;

import java.util.ArrayList;

public class Mergesort extends Thread {
	private ArrayList<Integer> lista;
	private int meio;
	
	public Mergesort(ArrayList<Integer> lista){
		lista = this.lista;
		mergesort (lista, lista.get(0), lista.get(lista.size()-1));
		}
	public void mergesort (ArrayList<Integer> lista, int primeiro, int ultimo){
		
		if (primeiro < ultimo){
			meio = (primeiro + ultimo)/2;
			mergesort(lista, primeiro, meio);
			mergesort(lista, meio+1, ultimo);
			merge(lista, lista.get(0), lista.get(lista.size()-1));
			
		}
	}
	
	public void merge(ArrayList<Integer> listaordenada, int primeiro, int ultimo){
		ArrayList<Integer> temp = null;
		
		meio = (primeiro+ultimo)/2;
		int i1=0;
		int i2 = primeiro;
		int i3 = meio + 1;
		
		while (listaordenada.size() > 1){
			if (listaordenada.get(i2) < listaordenada.get(i3)){
				temp.set(i1++, listaordenada.get(i2++));
			}else{
				temp.set(i1++, listaordenada.get(i3++));
			}
		}
		
		for (int i = 0; i < listaordenada.size(); i++){
			System.out.println(listaordenada.get(i) + "\t");
		}
		
	}
	
	public void run(){
		//merge(listaordenada, primeiro, ultimo);
		merge(lista, lista.get(0), lista.get(lista.size()-1));
	}

}
