//botones en java ejemplos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class botones{
	private botones(){super();}
	private void crear_guide(){
		JFrame ventana = new JFrame("ventana y etiqueta");
		JPanel contenedor = new JPanel();
		contenedor.add(new JLabel("Pulsa boton"));
		JButton boton = new JButton("Pulsame");
		boton.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			System.out.println("Boton pulsado");
		  }
		  });
		  contenedor.add(boton);
		  ventana.getContentPane().add(contenedor);
		  ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  ventana.pack();
		  ventana.setVisible(true);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){public void run(){new botones().crear_guide();}});
	}
}