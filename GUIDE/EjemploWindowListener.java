/* ejemplo completo de un escuchador para los
eventos de la ventana que cierra la aplicación cuando el usuario pulsa el botón
de cerrar ventana.
*/
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// esta clase implementa WindowListener luego eschuchaa WindowEvent
public class EjemploWindowListener implements WindowListener {
	private EjemploWindowListener(){ super();}
	
	private void creaGuide(){
		//creamos una ventana
		JFrame ventana = new JFrame("Cerrar ventana");
		//añadimos como escuchador lainstancia a esta clase
		ventana.addWindowListener(this);
		ventana.setSize(400,400);
		ventana.setVisible(true);
	} 
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
		  public void run(){
			new EjemploWindowListener().creaGuide();
		  }
		});
	}
	public void windowOpened(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		System.out.println("cerrando la ventana...");
		System.exit(0);
	}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
}