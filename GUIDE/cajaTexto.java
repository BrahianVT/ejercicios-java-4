//caja de texto en java ejemplos
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class cajaTexto{
	private JTextField meter_texto;
	private cajaTexto(){super();}
	public void crear_guide(){
		JFrame ventana = new JFrame("caja de texto ");
		ventana.setLayout(new FlowLayout());
		Container contenedor = ventana.getContentPane();
		contenedor.add(new JLabel("Intoduce Texto"));
		meter_texto = new JTextField(10);
		meter_texto.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e){
			System.out.println(meter_texto.getText());
		 }
		});
		ventana.add(meter_texto);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){public void run(){new cajaTexto().crear_guide();}});
	}
}