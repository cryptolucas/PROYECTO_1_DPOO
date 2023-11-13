package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class AdminGeneralInicio extends JFrame implements ActionListener{
	
	private JLabel lblTexto;
	
	private JButton btnAnadir;
	private JButton btnEliminar;
	private JButton btn_grafica;
	Principal principal;
	
	public AdminGeneralInicio(Principal p_principal) {
		principal = p_principal;
		setTitle("Bienvenido Jefe!");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
		setSize(1350,710);
        setLayout(new BorderLayout());
        
        JPanel pnlInic = new JPanel();
        pnlInic.setLayout(new GridLayout(6,1,10,50));
		
		
        lblTexto = new JLabel("¿Que desea hacer el dia de hoy?");
        lblTexto.setFont(new Font("Arial", Font.BOLD, 35));
        lblTexto.setForeground( Color.BLACK );
        lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
        lblTexto.setPreferredSize(new Dimension(850, 150));
        add(pnlInic, BorderLayout.CENTER);
        
        btnAnadir = new JButton("AÑADIR UN CARRO AL INVENTARIO");
        btnAnadir.setPreferredSize(new Dimension(150, 100));
        btnAnadir.setBackground( Color.BLUE );
        btnAnadir.setForeground( Color.WHITE );
        btnAnadir.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(btnAnadir);
        
        btnAnadir.addActionListener(this);
        btnAnadir.setActionCommand("AÑADIR");
        
        btnEliminar = new JButton("ELIMINAR UN CARRO DEL INVENTARIO");
        btnEliminar.setPreferredSize(new Dimension(150, 100));
        btnEliminar.setBackground( Color.BLUE );
        btnEliminar.setForeground( Color.WHITE );
        btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(btnEliminar);
        
        btnEliminar.addActionListener(this);
        btnEliminar.setActionCommand("ELIMINAR");
        
        btn_grafica = new JButton("VER GRÁFICA DISPONIBILIDAD SEDE NORTE");
        btn_grafica.setPreferredSize(new Dimension(150, 100));
        btn_grafica.setBackground( Color.BLUE );
        btn_grafica.setForeground( Color.WHITE );
        btn_grafica.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(btn_grafica);
        
        btn_grafica.addActionListener(this);
        btn_grafica.setActionCommand("graphNorte");
        
        btn_grafica = new JButton("VER GRÁFICA DISPONIBILIDAD SEDE SUR");
        btn_grafica.setPreferredSize(new Dimension(150, 100));
        btn_grafica.setBackground( Color.BLUE );
        btn_grafica.setForeground( Color.WHITE );
        btn_grafica.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(btn_grafica);
        
        btn_grafica.addActionListener(this);
        btn_grafica.setActionCommand("graphSur");
        
        btn_grafica = new JButton("VER GRÁFICA DISPONIBILIDAD SEDE CENTRO");
        btn_grafica.setPreferredSize(new Dimension(150, 100));
        btn_grafica.setBackground( Color.BLUE );
        btn_grafica.setForeground( Color.WHITE );
        btn_grafica.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(btn_grafica);
        
        btn_grafica.addActionListener(this);
        btn_grafica.setActionCommand("graphCentro");
        
        
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(350, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(350, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(lblTexto);
        add(panelVentanaPrincipalArr, BorderLayout.NORTH);
        
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(Box.createRigidArea(new Dimension(250, 80)));
        add(panelVentanaPrincipalAba, BorderLayout.SOUTH);
        		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand( ).equals( "AÑADIR" )) {
			AñadirCarro nuevo_carro = new AñadirCarro(principal);
			nuevo_carro.setLocationRelativeTo(null);
			nuevo_carro.setVisible(true);
			dispose();
		}
		else if (e.getActionCommand( ).equals( "ELIMINAR" )) {
			EliminarCarro elim = new EliminarCarro(principal);
			elim.setLocationRelativeTo(null);
			elim.setVisible(true);
			dispose();
		}
		
		else if (e.getActionCommand( ).equals( "graphNorte" )) {
			GraficasAdicional g = new GraficasAdicional(principal);
			g.setLocationRelativeTo(null);
			g.setVisible(true);
			//dispose();
			
		}
		
		else if (e.getActionCommand( ).equals( "graphSur" )) {
			MostrarGraficaSur s = new MostrarGraficaSur(principal);
			s.setLocationRelativeTo(null);
			s.setVisible(true);
			//dispose();
			
		}
		
		else if (e.getActionCommand( ).equals( "graphCentro" )) {
			MostrarGraficaCentro c = new MostrarGraficaCentro(principal);
			c.setLocationRelativeTo(null);
			c.setVisible(true);
			//dispose();
			
		}
		
	}

}
