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
	
	public AdminGeneralInicio() {
		setTitle("Bienvenido Jefe!");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height-50);
        setLayout(new BorderLayout());
        
        JPanel pnlInic = new JPanel();
        pnlInic.setLayout(new GridLayout(3,1,10,50));
		
		
        lblTexto = new JLabel("¿Que desea hacer el dia de hoy?");
        lblTexto.setFont(new Font("Arial", Font.BOLD, 35));
        lblTexto.setForeground( Color.BLACK );
        lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(lblTexto);
        add(pnlInic, BorderLayout.CENTER);
        
        btnAnadir = new JButton("AÑADIR UN CARRO AL INVENTARIO");
        btnAnadir.setPreferredSize(new Dimension(150, 50));
        btnAnadir.setBackground( Color.BLUE );
        btnAnadir.setForeground( Color.WHITE );
        btnAnadir.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(btnAnadir);
        
        btnAnadir.addActionListener(this);
        btnAnadir.setActionCommand("AÑADIR");
        
        btnEliminar = new JButton("ELIMINAR UN CARRO DEL INVENTARIO");
        btnEliminar.setPreferredSize(new Dimension(150, 50));
        btnEliminar.setBackground( Color.BLUE );
        btnEliminar.setForeground( Color.WHITE );
        btnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(btnEliminar);
        
        btnEliminar.addActionListener(this);
        btnEliminar.setActionCommand("ELIMINAR");
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(350, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(350, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(250, 200)));
        add(panelVentanaPrincipalArr, BorderLayout.NORTH);
        		
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(Box.createRigidArea(new Dimension(250, 200)));
        add(panelVentanaPrincipalAba, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand( ).equals( "AÑADIR" )) {
			dispose();
		}
		else if (e.getActionCommand( ).equals( "ELIMINAR" )) {
			dispose();
		}
		
	}

}
