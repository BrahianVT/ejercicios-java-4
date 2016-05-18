//RedioButton en java ejemplo
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public final class radioBotones{
	private radioBotones(){super();}
	private JPanel crearContenedor(String Posicion){
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
		Escuchador escuchador = new Escuchador();
		
		JRadioButton radioBoton = new JRadioButton("Mucho");
		radioBoton.addActionListener(escuchador);
		radioBoton.addItemListener(escuchador);
		contenedor.add(radioBoton);
		
		JRadioButton radioBoton2 = new JRadioButton("Normal");
		radioBoton2.addActionListener(escuchador);
		radioBoton2.addItemListener(escuchador);
		contenedor.add(radioBoton2);
		
		JRadioButton radioBoton3 = new JRadioButton("Poco");
		radioBoton3.addActionListener(escuchador);
		radioBoton3.addItemListener(escuchador);
		contenedor.add(radioBoton3);
		if (Posicion == BorderLayout.EAST){
			ButtonGroup grupo = new ButtonGroup();
			grupo.add(radioBoton);
			grupo.add(radioBoton2);
			grupo.add(radioBoton3);
		}
	return contenedor;
	}
	private void crear_guide(){
		JFrame ventana = new JFrame("Radio button");
		ventana.add(crearContenedor(BorderLayout.WEST), BorderLayout.WEST);
		ventana.add(crearContenedor(BorderLayout.EAST), BorderLayout.EAST);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
	}
	private class Escuchador implements ActionListener, ItemListener{
		public Escuchador(){super();}
		public void actionPerformed(ActionEvent e){
			System.out.println("Boton pulsado\n");
		}
		public void itemStateChanged(ItemEvent e){
			String texto = ((JRadioButton)e.getSource()).getText();
			if(e.getStateChange() == ItemEvent.DESELECTED)
			System.out.format("Boton %s deselecionado.\n" , texto);
			else if(e.getStateChange() == ItemEvent.SELECTED)
			System.out.format("Boton %s seleccionado \n" , texto);		
		}
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new radioBotones().crear_guide();
			}
		});
	}
}