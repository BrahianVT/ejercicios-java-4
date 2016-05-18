//hilos son flujos de control independiente dentro de un programa
//como sincronizar hilos

public class Sincronizar<T>{
	private int cabeza=0,capacidad, ocupacion=0;
	//declaramos un objeto de la clase object
	private Object[] datos;
	public Sincronizar(int capacidad){ 
		super();
		this.capacidad = capacidad;
		datos = new Object[capacidad];
	}
	//sincronizar mediante el metodo synchronized
	public synchronized T getDato() throws InterruptedException{
		T dato;
		while(ocupacion ==0)
			wait();
		dato = (T)datos[cabeza];
		ocupacion--; cabeza++;
		cabeza %= capacidad;
		System.out.format("-%s [%d]\n", dato, ocupacion);
		notifyAll();
		return dato;
	}
	public synchronized void setDato(T dato)throws InterruptedException{
		while(ocupacion == capacidad)
			wait();
		datos[(cabeza + ocupacion) % capacidad] = dato;
		ocupacion++;
		System.out.format("+%s [%d]\n" , dato, ocupacion);
		notifyAll();
	}
	
	public static void main (String[] args){
		Sincronizar ver = new Sincronizar(100);
		try{
		ver.setDato(0);
		ver.getDato();
		}
		catch (InterruptedException e){ e.printStackTrace();}
		System.out.println("");
	}
}