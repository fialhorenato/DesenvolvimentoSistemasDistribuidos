package principal;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) {
		int x = 199;
		List<Integer> Lista = new ArrayList<Integer>();
		for(int i=0; i<=1000; i++){
			Lista.add(i);
		}
		
		Pesquisa1 p1 = new Pesquisa1(x, Lista);
		Pesquisa2 p2 = new Pesquisa2(x, Lista);
		
		p1.setThread(p2);
		p2.setThread(p1);
		
		p1.start();
		p2.start();
		
		try {
			p1.join();
			p2.join();
			
			if((p1.getResult()<0)&&(p2.getResult()<0)){
				System.out.println("Thread nao encontrada");
			}else if((p1.getResult()<0)&&(p2.getResult()>=0)){
				System.out.println("Thread 2 Encontrou na posicao " + p2.getResult());
			}else if((p1.getResult()>=0)&&(p2.getResult()<0)){
				System.out.println("Thread 1 Encontrou na posicao " + p1.getResult());
			}else{
				System.out.println("Thread 1 e 2 Encontraram na posicao " + p1.getResult());
			}
			} catch (Exception e) {
			System.out.println("e.getmessage");
		}
		
	}

}
