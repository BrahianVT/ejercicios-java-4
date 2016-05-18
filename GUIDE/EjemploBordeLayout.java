import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public final class EjemploBordeLayout {
	private EjemploBordeLayout(){ super(); }
	private void crearGUIDE(){
		JFrame principal = new JFrame("controlador del BorderLayout");
		Container contenedor = principal.getContentPane();
		contenedor.add(new JButton("Centro"));
		contenedor.add(new JButton("Norte"), BorderLayout.NORTH);
		contenedor.add(new JButton("Este") , BorderLayout.EAST);
		contenedor.add(new JButton("Sur"), BorderLayout.SOUTH);
		contenedor.add(new JButton("Oeste"), BorderLayout.WEST);
		principal.setSize(400 , 400);
		principal.setVisible(true);
	}
	public static void main (String [] args){
		SwingUtilities.invokeLater(new Runnable() {
		public void run (){
			new EjemploBordeLayout().crearGUIDE();
		}
		});
	}
}