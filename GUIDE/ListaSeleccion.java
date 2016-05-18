// listas de seleccion JList en java ejemplo

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public final class ListaSeleccion{
	private ListaSeleccion(){super();}
	//Creamos la ventana principal 
	private void crear_guide(){
		JFrame ventana = new JFrame("Ejemplo Lista de seleccion");
		Container contenedor = ventana.getContentPane();
		//Creamos la lista de opciones a escoger
		JList opciones = new JList(new String[]{"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"});
		//ponemos solo 5 visibles y una seleccion de un solo elemento
		opciones.setVisibleRowCount(5);
		opciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//agregamos el escuchador para que identifique cuando alla una seleccion
		opciones.addListSelectionListener(new Escuchador());
		//agregamos el JScrollPane a la lista
		JScrollPane scroll = new JScrollPane(opciones);
		contenedor.add(scroll);
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	private class Escuchador implements ListSelectionListener{
		//identificamos cuando el valor de la lista es escogido
		public void valueChanged(ListSelectionEvent e){
			if(e.getValueIsAdjusting() == true)
				System.out.println("Item en curso " + ((JList)e.getSource()).getSelectedValue());
			else if(e.getValueIsAdjusting() == false)
				System.out.println("Item definitivo" + ((JList)e.getSource()).getSelectedValue());
		}
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){public void run(){new ListaSeleccion().crear_guide();}});
	}
}