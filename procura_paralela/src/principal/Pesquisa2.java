package principal;

import java.util.List;
import java.util.ListIterator;

public class Pesquisa2 extends Thread{
	private int n;
	private List<Integer> Lista;
	private int result = -1;
	private Pesquisa1 t1 = null;

	public Pesquisa2(int n, List<Integer> lista) {
		this.n = n;
		Lista = lista;
	}

	public void run(){
		ListIterator<Integer> it = Lista.listIterator(Lista.size());
		while(it.hasPrevious() && !this.isInterrupted()){
			if(n==it.previous()){
				result = it.previous();
				t1.interrupt();
				break;
			}
		}
	}
	
	public int getResult(){
        return result;
    }
	
	public void setThread(Pesquisa1 t){
		t1 = t;
	}
}