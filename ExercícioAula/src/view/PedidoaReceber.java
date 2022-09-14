
package view;

import controller.ThreadsCozinheiro;
import java.util.concurrent.Semaphore;

public class PedidoaReceber {

	public static void main(String[] args) {
		
		int n = 10;
		int premissoes = 5;
		Semaphore semaforo = new Semaphore(premissoes);
			for(int idPrato = 0;idPrato < n; idPrato++) {
			Thread tPrato = new ThreadsCozinheiro(idPrato,semaforo);
		      tPrato.start();
	}
	}
}
