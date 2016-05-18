//hilos son flujos de control independiente dentro de un programa
//creacion de hilo extendiendo la clase thread
public class ejemlo1 extends Thread{
	public ejemlo1(){super();}
	//sobreescribir metodo de la clase Thread
	public void run(){
		for(int i = 0; i<=19; i++){
			System.out.println(i);
		}
	}
	public static void main(String[] args){
		new ejemlo1().start();
	}
}

//como el metodoes publico puede ser instanciado desde cualquier clase
// por lo que este forma de implementacion esta desaconsejada.