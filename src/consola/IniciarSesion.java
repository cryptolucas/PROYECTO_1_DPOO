package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class IniciarSesion extends JFrame implements ActionListener{
	
	private JLabel lblLog_In;
	private JLabel lblPassw;
	private JLabel lblNada;
	
	private JTextField txtLog_In;
	private JTextField txtPassw;
	
	private JButton btnIniciarSesion;
	
	private Principal principal;
	
	public IniciarSesion( Principal pPrincipal ) {
		principal = pPrincipal;
		setTitle("Iniciar sesión");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height-50);
        setLayout(new BorderLayout());
        //setLayout(new GridLayout(3,2));
        
        JPanel pnlInic = new JPanel();
        pnlInic.setLayout(new GridLayout(2,2));
        
		lblLog_In = new JLabel("Log-In");
        lblLog_In.setFont(new Font("Arial", Font.BOLD, 15));
        lblLog_In.setForeground( Color.BLACK );
        lblLog_In.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(lblLog_In);
        txtLog_In = new JTextField( "" );
        pnlInic.add(txtLog_In);
        
        lblPassw = new JLabel("Contraseña");
        lblPassw.setFont(new Font("Arial", Font.BOLD, 15));
        lblPassw.setForeground( Color.BLACK );
        lblPassw.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(lblPassw);
        txtPassw = new JTextField( "" );
        pnlInic.add(txtPassw);

        
        add(pnlInic, BorderLayout.CENTER);
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(250, 300)));
        add(panelVentanaPrincipalArr, BorderLayout.NORTH);
        
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(Box.createRigidArea(new Dimension(0, 300)));
        btnIniciarSesion = new JButton("INICIAR SESIÓN");
        btnIniciarSesion.setPreferredSize(new Dimension(150, 50));
        btnIniciarSesion.setBackground( Color.BLUE );
        btnIniciarSesion.setForeground( Color.WHITE );
        btnIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        panelVentanaPrincipalAba.add(btnIniciarSesion);
        btnIniciarSesion.addActionListener(this);
        btnIniciarSesion.setActionCommand("INICIAR SESIÓN");
        add(panelVentanaPrincipalAba, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand( ).equals( "INICIAR SESIÓN" )) { 
			String tipoUser = "error";
			try {
				tipoUser = principal.iniciarSesion(txtLog_In.getText(), txtPassw.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (tipoUser.equals("cliente")){
				
				MenuCliente menu_cliente = new MenuCliente(principal);
				menu_cliente.setLocationRelativeTo(null);
				menu_cliente.setVisible(true);
				
				dispose();
			}
			else if (tipoUser.equals("administradorl")) {
				
				AdminLocal adminl = new AdminLocal(principal);
				adminl.setLocationRelativeTo(null);
				adminl.setVisible(true);
				
				dispose();
			}
			
			else if (tipoUser.equals("empleado")) {
				
				MenuEmpleado menu_emple = new MenuEmpleado(principal);
				menu_emple.setLocationRelativeTo(null);
				menu_emple.setVisible(true);
				
				dispose();
			}
			
			else if (tipoUser.equals("administradorg")) {
				JOptionPane.showMessageDialog(null, "Ha iniciado sesion como "+txtLog_In.getText()+". Bienvenido Jefe!", "Inicio Sesión", JOptionPane.INFORMATION_MESSAGE);
				AdminGeneralInicio adminG = new AdminGeneralInicio(principal);
				adminG.setLocationRelativeTo(null);
				adminG.setVisible(true);
				dispose();
			}
			else {//"error"
				JOptionPane.showMessageDialog(null, "No existe el usuario", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
        	
        	//llamar a la otra ventana...
        }
		
	}
}
