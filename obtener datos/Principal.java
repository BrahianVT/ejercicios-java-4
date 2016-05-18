import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
//encripter http://docs.oracle.com/javase/6/docs/api/javax/crypto/Cipher.html
public class Principal{
	private static final String algoritmo = "Blowfish";
	private static String llave = "miClaveSecreta";
	public static void encriptar(File archivo_entrada , File archivo_salida) throws Exception{
		doCrypto(Cipher.ENCRYPT_MODE, archivo_entrada , archivo_salida);
		System.out.println("Archivo encriptado correctamente");
	}
	public static void desencriptar(File archivo_entrada , File archivo_salida) throws Exception{
		doCrypto(Cipher.DECRYPT_MODE , archivo_entrada , archivo_salida);
		System.out.println("desencriptado correctamente");
	}
	
	private static void doCrypto(int modo_cipher , File archivo_entrada , File archivo_salida) throws Exception{
		//generar llave secreta a partir de una cadena
		Key llave_secreta = new SecretKeySpec(llave.getBytes(), algoritmo);
		Cipher cipher = Cipher.getInstance(algoritmo);
		cipher.init(modo_cipher, llave_secreta);
		//subimos archivo a encriptar
		FileInputStream entrada= new FileInputStream(archivo_entrada);
		byte[] entrada_bytes = new byte[(int) archivo_entrada.length()];
		entrada.read(entrada_bytes);
		
		byte[] salida_bytes = cipher.doFinal(entrada_bytes);
		
		FileOutputStream salida = new FileOutputStream(archivo_salida);
		salida.write(salida_bytes);
		entrada.close();
		salida.close();
		
	}
	public static void main(String[] args){
		File encriptar_archivo = new File("C:/Users/WIN7/Desktop/Php/java/obtener datos/prueba.txt");
		File encriptado = new File("C:/Users/WIN7/Desktop/Php/java/obtener datos/prueba.encrypted");
		
		try{
			Principal.encriptar(encriptar_archivo, encriptado);
			//Principal.desencriptar(encriptado , encriptar_archivo);
		}
		catch(Exception e){ e.printStackTrace();}
	}
}