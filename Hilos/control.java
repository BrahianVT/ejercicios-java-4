//hilos son flujos de control independiente dentro de un programa
//control de hilos tratando como bloque
//como suspender temponralmente la ejecucion de un hilo
public class control{
	private control() {super();}
	private void ejecuta(){
		new Thread(new Runnable(){
			public void run(){
				try{
					for (int i = 0; i<=10; i++)
						System.out.println(i);
						Thread.sleep(10000);
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}).start();
	}
	public static void main (String[] args){
		new control().ejecuta();
	}
}
