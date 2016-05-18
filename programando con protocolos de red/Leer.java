/*
como leer una url desde java
﻿Una vez que tenemos construida una URL válida, podemos recuperar a partir
de ella un InputStream para leer el contenido del recurso al que apunta la
URL, mediante el método public final InputStream openStream() throws
IOException, y como ya vimos en el Cap´ıtulo 7 a partir de una referencia de
tipo InputStream podemos recuperar un BufferedReader con el que leer l           ınea
a l´ınea desde el recurso. El Listado 15.2 muestra un ejemplo completo de cómo
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public final class Leer {
	private Leer(){super();}
	private void ejecuta(String direccion){
		try{
			URL url = new URL(direccion);
			InputStream es = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(es));
			try{
				String cadena;
				while((cadena = br.readLine()) != null )
					System.out.println(cadena);
			} finally{
				br.close();
			}
			}catch (MalformedURLException e){
				e.printStackTrace();
			}catch(IOException e){
			e.printStackTrace();
		 }
	}

	public static void main(String[] args){
		new Leer().ejecuta(args[0]);
	}
}