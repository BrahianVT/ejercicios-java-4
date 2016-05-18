import java.io.File;
public class Renombrar{
	public static void main(String [] args){
		try{
		String ruta = System.getProperty("user.dir") + "/tesis.pdf";
		String ruta2 = System.getProperty("user.dir")+ "/tesis.encrypted";
		System.out.println(ruta);
		System.out.println(ruta2);
		File archivo = new File(ruta);
		archivo.renameTo(new File(ruta2));
		}catch (Exception e){ e.printStackTrace();}
	}
}