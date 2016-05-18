//﻿La clase Scanner está presente en Java desde la versión 5. Esta clase per-
//mite analizar una cadena de texto utilizando para ello expresiones regulares 1.
//Las cadenas se pueden proporcionar directamente en el momento de crear la
//instancia de clase Scanner o a través de un flujo.
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public final class scanner{
	private static final String  fichero = "personas.txt";
	private scanner(){ super();}
	private void ejecuta(){
		try{
			Scanner escanear = new Scanner(new File(fichero));
			while(escanear.hasNext()){
				analizaLinea(escanear.nextLine());
			}} catch (FileNotFoundException e){
				e.printStackTrace();
			}
	}
	private void analizaLinea(String linea) {
		Scanner escanear = new Scanner(linea);
		escanear.useDelimiter(": ");
		String Persona ,Nombre , Apellidos;
		int telefono;
		Persona = escanear.next();
		Nombre = escanear.next();
		Apellidos = escanear.next();
		telefono = escanear.nextInt();
		System.out.println(Nombre + " ," + Apellidos + ", " + telefono);
	}
public static void main(String[] args){
	new scanner().ejecuta();
}
}