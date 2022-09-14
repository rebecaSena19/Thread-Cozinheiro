package controller;

import java.util.concurrent.Semaphore;

public class ThreadsCozinheiro extends Thread{
	
	private int idPrato;
	private static int pronto;
	private static int posentrega;
	private Semaphore semaforo;

	public ThreadsCozinheiro(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
  @Override
public void run() {
	  pratoinicia(); 
// inicio da seção crítica
	  try {
	  semaforo.acquire();
	  pratopronto();
	  }catch (InterruptedException e) {
		  e.printStackTrace();
	  }finally {
		  semaforo.release();
	  }
//  fim seção crítica
	  pratoentrega();
	  
}
  private void pratoinicia() {
  if (idPrato % 2 == 0)	{
	 System.out.println("Lasanha a Bolonhesa");
	 double tempo = ((Math.random()*0.61)+0.6);
	 
  }else {
	  System.out.println("Sopa de Cebola");
    double tempo = ((Math.random()*0.31)+0.5);
  }
}
private void pratopronto() {
	System.out.println("#"+idPrato+"esta pronto!");
}
private void pratoentrega() {
posentrega++;
System.out.println("#"+idPrato+"foi o "+posentrega+"° a ser entregue");
  
  
}
}
