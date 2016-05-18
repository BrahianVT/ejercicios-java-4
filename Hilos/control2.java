//hilos son flujos de control independiente dentro de un programa
//como iniciar un hilo cuando termina otro

public final class control2 {
	private Thread hilo;
	private control2(){super();}
	private void ejecuta(){
		hilo = new Thread(new Tarea());
		hilo.start();
		new Thread(new TareaEspera()).start();
	}
	private class Tarea implements Runnable{
		public void run(){
		try{System.out.println("Inicia primer Thread");
			for(int i = 0; i<=10; i++){
				System.out.println(i);
				Thread.sleep(500);}
			}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		}
	}
	
	private class TareaEspera implements Runnable{
		public void run(){
			try{System.out.println("Inicia segundo thread");
				for(int i=0; i<=10; i++){
				 System.out.println("cuenta y espera :" + i);
				Thread.sleep(500);}
				hilo.join();
				for(int i=11; i<=20; i++){
				 System.out.println("Salta la espera y cuenta:" + i);
				 Thread.sleep(500);}
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		new control2().ejecuta();
	}
}

