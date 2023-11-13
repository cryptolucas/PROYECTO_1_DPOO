package consola;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class RegistrarUsuario extends JFrame implements ActionListener{
	
	private JLabel lblNombre;
	private JLabel lblLog_In;
	private JLabel lblPassw;
	private JLabel lblEMail;
	private JLabel lblFechaNac;
	private JLabel lblNacionalidad;
	private JLabel lblLicencia;
	private JLabel lblPaisExpLic;
	private JLabel lblFechaVenLic;
	private JLabel lblNoTel;
	private JLabel lblTarjeta;
	
	private JTextField txtNombre;
	private JTextField txtLog_In;
	private JTextField txtPassw;
	private JTextField txtEMail;
	private JTextField txtFechaNac;
	private JTextField txtNacionalidad;
	private JTextField txtLicencia;
	private JTextField txtPaisExpLic;
	private JTextField txtFechaVenLic;
	private JTextField txtNoTel;
	private JTextField txtTarjeta;
	
	private JLabel lblNada;
	private JButton botonReg;
	
	private Principal principal;
	
	public RegistrarUsuario( Principal pPrincipal ) {
		principal = pPrincipal;
		setTitle("Registrar Usuario");
		setResizable( false );
		setLayout(new GridLayout(12, 2));
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
        setSize(1350,710);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Arial", Font.BOLD , 15));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setForeground( Color.BLACK );
        lblNombre.setPreferredSize(new Dimension(150, 50));
        add(lblNombre);
        txtNombre = new JTextField( "" );
        add(txtNombre);
        
        lblLog_In = new JLabel("Log-In");
        lblLog_In.setFont(new Font("Arial", Font.BOLD, 15));
        lblLog_In.setForeground( Color.BLACK );
        lblLog_In.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblLog_In);
        txtLog_In = new JTextField( "" );
        add(txtLog_In);
        
        lblPassw = new JLabel("Contraseña");
        lblPassw.setFont(new Font("Arial", Font.BOLD, 15));
        lblPassw.setForeground( Color.BLACK );
        lblPassw.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblPassw);
        txtPassw = new JTextField( "" );
        add(txtPassw);
        
        lblEMail = new JLabel("Correo electronico");
        lblEMail.setFont(new Font("Arial", Font.BOLD, 15));
        lblEMail.setForeground( Color.BLACK );
        lblEMail.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblEMail);
        txtEMail = new JTextField( "" );
        add(txtEMail);
        
        lblFechaNac = new JLabel("Fecha de Nacimiento");
        lblFechaNac.setFont(new Font("Arial", Font.BOLD, 15));
        lblFechaNac.setForeground( Color.BLACK );
        lblFechaNac.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblFechaNac);
        txtFechaNac = new JTextField( "" );
        add(txtFechaNac);
        
        lblNacionalidad = new JLabel("Nacionalidad");
        lblNacionalidad.setFont(new Font("Arial", Font.BOLD, 15));
        lblNacionalidad.setForeground( Color.BLACK );
        lblNacionalidad.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNacionalidad);
        txtNacionalidad = new JTextField( "" );
        add(txtNacionalidad);
        
        lblLicencia = new JLabel("Numero de licencia de conducción");
        lblLicencia.setFont(new Font("Arial", Font.BOLD, 15));
        lblLicencia.setForeground( Color.BLACK );
        lblLicencia.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblLicencia);
        txtLicencia = new JTextField( "" );
        add(txtLicencia);
        
        lblPaisExpLic = new JLabel("País de expedición");
        lblPaisExpLic.setFont(new Font("Arial", Font.BOLD, 15));
        lblPaisExpLic.setForeground( Color.BLACK );
        lblPaisExpLic.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblPaisExpLic);
        txtPaisExpLic = new JTextField( "" );
        add(txtPaisExpLic);
        
        lblFechaVenLic = new JLabel("Fecha de vencimiento");
        lblFechaVenLic.setFont(new Font("Arial", Font.BOLD, 15));
        lblFechaVenLic.setForeground( Color.BLACK );
        lblFechaVenLic.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblFechaVenLic);
        txtFechaVenLic = new JTextField( "" );
        add(txtFechaVenLic);
        
        lblNoTel = new JLabel("Número de teléfono");
        lblNoTel.setFont(new Font("Arial", Font.BOLD, 15));
        lblNoTel.setForeground( Color.BLACK );
        lblNoTel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNoTel);
        txtNoTel = new JTextField( "" );
        add(txtNoTel);
        
        lblTarjeta = new JLabel("Número de tarjeta de credito");
        lblTarjeta.setFont(new Font("Arial", Font.BOLD, 15));
        lblTarjeta.setForeground( Color.BLACK );
        lblTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTarjeta);
        txtTarjeta = new JTextField( "" );
        add(txtTarjeta);
        
        lblNada = new JLabel();
        add(lblNada);
        botonReg = new JButton("REGISTRARME!");
        botonReg.setPreferredSize(new Dimension(150, 50));
        botonReg.setBackground( Color.BLUE );
        botonReg.setForeground( Color.WHITE );
        add(botonReg);
        
        botonReg.addActionListener(this);
        botonReg.setActionCommand("REGISTRAR");
        
        //add(panelVentanaRegistrarse);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand( ).equals( "REGISTRAR" )) {     
			try {
				principal.registrarUsuario(txtNombre.getText(), txtEMail.getText(), 
						txtLog_In.getText(), txtPassw.getText(), "cliente",
						txtFechaNac.getText(), txtNacionalidad.getText(),
						txtLicencia.getText(), txtPaisExpLic.getText(), 
						txtFechaVenLic.getText(),txtNoTel.getText(), 
						txtTarjeta.getText());
				
				JOptionPane.showMessageDialog(null, "Se registró correctamente a nuestro sistema", 
						"Gracias por elegirnos", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERROR!", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
				dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERROR!", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
				dispose();
			}
        	dispose();
        }
		
	}

	
}
