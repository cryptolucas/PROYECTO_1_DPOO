package app_cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import consola.GraficaNorte;
import consola.Principal;

public class MostrarGraficaNorteCliente extends JFrame {

	
	 private ClientePrincipal principal;
	 
	 public MostrarGraficaNorteCliente(ClientePrincipal p_principal) {
		 principal = p_principal;
		 setTitle("Grafica Disponibilidad");
		 setResizable( false );
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 setSize(screenSize.width, screenSize.height-50);
		 setLayout(new BorderLayout());
		 
		 JPanel panel_norte = new GraficaNorteCliente(principal);
		 add(panel_norte, BorderLayout.CENTER);
		 
		 
	 }
}