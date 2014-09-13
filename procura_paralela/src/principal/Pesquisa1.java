package principal;

import java.util.List;
import java.util.ListIterator;

public class Pesquisa1 extends Thread{
	private int n;
	private List<Integer> Lista;
	private int result = -1;
	private Pesquisa2 t2 = null;

	public Pesquisa1(int n, List<Integer> lista) {
		this.n = n;
		Lista = lista;
	}

	public void run(){
		ListIterator<Integer> it = Lista.listIterator();
		while(it.hasNext() && !this.isInterrupted()){
			if(n==it.next()){
				result = it.next();
				t2.interrupt();
				break;
			}
		}
	}
	
	public int getResult(){
        return result;
    }
	
	public void setThread(Pesquisa2 t){
		t2 = t;
	}
}
