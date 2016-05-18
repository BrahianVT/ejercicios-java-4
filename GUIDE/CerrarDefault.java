import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class CerrarDefault{
	private CerrarDefault(){ super();}
	private void crearGuide(){
		JFrame ventana = new JFrame("Escuchador con clase adaptadora");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(400,400);
		ventana.setVisible(true);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new CerrarDefault().crearGuide();
			}
		});
	}
} 