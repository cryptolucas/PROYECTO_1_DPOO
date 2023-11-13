package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GraficasAdicional extends JFrame {

	
	 private Principal principal;
	 
	 public GraficasAdicional(Principal p_principal) {
		 principal = p_principal;
		 setTitle("Grafica Disponibilidad");
		 setResizable( false );
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 setSize(screenSize.width, screenSize.height-50);
		 setLayout(new BorderLayout());
		 
		 JPanel panel_norte = new GraficaNorte(principal);
		 add(panel_norte, BorderLayout.CENTER);
		 
		 
	 }
}
