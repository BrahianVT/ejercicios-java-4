/*
escribir en una url java
para escribir a una url necesitamos una referencia de la clase URLConnection. La referencia necesaria nos la 
devuelve un metodo public URLConnection openConnection() throws IOException de la clase URL una vez odtenida devesindicar
que queremos escribir sobre ella , para eso utilizamos el metodo public void setDoOutput(boolean dooutput) con un 
argumento true. 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public final class Escribir {
	private Escribir(){super();}
	private void ejecuta(String sURL){
		try{
			URL url = new URL(sURL);
			URLConnection conexion = url.openConnection();
			conexion.setDoOutput(true);
			PrintWriter pw = new PrintWriter(conexion.getOutputStream(),true);
			pw.println("nombre = oscar");
			BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			try{
				String respuesta;
				while((respuesta = br.readLine()) != null)
					System.out.println(respuesta);
			} finally{
				pw.close();
				br.close();
			}
			} catch(MalformedURLException r){
				r.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
	}
	public static void main(String[] args){
		new Escribir().ejecuta("﻿http://rubi.dlsi.uji.es/oscar/PHP/nombre.php?nombre=oscar");
	}
}
