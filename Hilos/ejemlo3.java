//hilos son flujos de control independiente dentro de un programa
//creacion de hilo mmediante creacion de una clase interna anonima

public final class ejemlo3{
	private ejemlo3(){super();}
	
	private void ejecuta(){
		new Thread(new Runnable(){
		  public void run(){
			for(int i = 0; i <=19; i++)
				System.out.println(i);
		  }
		}).start();
	}
	public static void main(String[] args){
	new ejemlo3().ejecuta();
	}
}