//hilos son flujos de control independiente dentro de un programa
//creacion de hilo mmediante creacion de una clase interna

public final class ejemlo2{
	private ejemlo2(){super();}
	private class hilo implements Runnable{
		private hilo(){super();}
		public void run(){
			for(int i = 0; i<=19; i++)
			System.out.println(i);
		}
	}
	private void ejecuta(){
		new Thread(new hilo()).start();
	}
	public static void main(String[] args){
		new ejemlo2().ejecuta();
	}
}