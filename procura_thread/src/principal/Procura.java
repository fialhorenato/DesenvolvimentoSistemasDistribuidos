package principal;

import java.util.LinkedList;
import java.util.ListIterator;

public class Procura extends Thread{
	private LinkedList<Integer> lista;
	private int valor;
	private int achou;
		
	public Procura(LinkedList<Integer> lista, int valor){
		this.lista = lista;
		this.valor = valor;	
		ListIterator<Integer> listaDireta = lista.listIterator();
		
		while (listaDireta.hasNext()){
			if (listaDireta.next() == valor){
				achou = listaDireta.previousIndex();
			}
		}
		//System.out.println(">" + achou);
	}
	
	public Procura(int valor, LinkedList<Integer> lista){
		this.valor = valor;
		this.lista = lista;
		ListIterator<Integer> listaInversa = lista.listIterator(lista.size());
		
		while(listaInversa.hasPrevious()){
			if (listaInversa.previous() == valor){
				achou = listaInversa.nextIndex();
				}
		}
		//System.out.println("<" + achoui);
	}
	
	public int getResult(){		
		return achou;
	}
	
	@Override
	public void run(){	
	
		}
		
	}
