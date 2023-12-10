package consola;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class COINK extends JFrame implements ActionListener {

	private JLabel lblNombre;
	private JLabel lblNumero;
	private JLabel text3;
	private JLabel image1;
	private JLabel lblCVV;
	private JLabel lblFechaExp;
	private JLabel lblNombreTitular;
	private JLabel lblCodigoPostal;
	private JLabel lblemail;
	private JLabel lblnada;
	
	private JTextField txtNumero;
	private JTextField txtCVV;
	private JTextField txtFechaExp;
	private JTextField txtNombreTitular;
	private JTextField txtCodigoPostal;
	private JTextField txtemail;
	
	
	private Principal principal;
	
	private JButton boton_pagar;
	
	
	public COINK (Principal p_principal) {
		
		principal = p_principal;
		
		setTitle("Pago con Coink");
		setResizable( false );
		setLayout(new GridLayout(9, 2));
        setSize(1350,710);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon icono = new ImageIcon("data/coink.jpg");
        image1 = new JLabel((new ImageIcon(icono.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH))));
        add(image1);
        
        lblNombre = new JLabel("Método de pago: COINK");
        lblNombre.setFont(new Font("Arial", Font.BOLD , 15));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setForeground( Color.YELLOW );
        lblNombre.setPreferredSize(new Dimension(150, 50));
        add(lblNombre);
        
        lblNumero = new JLabel("Número Tarjeta ");
        lblNumero.setFont(new Font("Arial", Font.BOLD, 15));
        lblNumero.setForeground( Color.BLACK );
        lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNumero);
        txtNumero = new JTextField( "" );
        add(txtNumero);
        
        
        lblCVV= new JLabel("Código de Seguridad ");
        lblCVV.setFont(new Font("Arial", Font.BOLD, 15));
        lblCVV.setForeground( Color.BLACK );
        lblCVV.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblCVV);
        txtCVV = new JTextField( "" );
        add(txtCVV);
       
        
        lblFechaExp= new JLabel("Fecha expiración tarjeta 'MM/YY'  ");
        lblFechaExp.setFont(new Font("Arial", Font.BOLD, 15));
        lblFechaExp.setForeground( Color.BLACK );
        lblFechaExp.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblFechaExp);
        txtFechaExp = new JTextField( "" );
        add(txtFechaExp);
        
        
        lblNombreTitular = new JLabel("Nombre que aparece en la tarjeta ");
        lblNombreTitular.setFont(new Font("Arial", Font.BOLD, 15));
        lblNombreTitular.setForeground( Color.BLACK );
        lblNombreTitular.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNombreTitular);
        txtNombreTitular = new JTextField( "" );
        add(txtNombreTitular);
        
        
        lblCodigoPostal = new JLabel("Ingresa tu número de celular ");
        lblCodigoPostal.setFont(new Font("Arial", Font.BOLD, 15));
        lblCodigoPostal.setForeground( Color.BLACK );
        lblCodigoPostal.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblCodigoPostal);
        txtCodigoPostal = new JTextField( "" );
        add(txtCodigoPostal);
        
        
        lblemail = new JLabel("Ingresa tu email ");
        lblemail.setFont(new Font("Arial", Font.BOLD, 15));
        lblemail.setForeground( Color.BLACK );
        lblemail.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblemail);
        txtemail = new JTextField( "" );
        add(txtemail);
        
        lblnada= new JLabel("");
        add(lblnada);
        
        boton_pagar = new JButton("PAGAR");
        boton_pagar.setPreferredSize(new Dimension(150, 50));
        boton_pagar.setBackground( Color.BLUE );
        boton_pagar.setForeground( Color.WHITE );
        boton_pagar.setHorizontalAlignment(SwingConstants.CENTER);
        add(boton_pagar);
        boton_pagar.addActionListener(this);
        boton_pagar.setActionCommand("pagar");
        
       
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand( ).equals( "pagar" )) {     
		
			try {
			String rutaArchivo = "RegistroPasarelas/Registro_coink.txt";
			String contenido =  txtNombreTitular.getText() + " " + txtNumero.getText() + " " + txtemail.getText()
			+ " " + txtCodigoPostal.getText();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true));
			writer.write(contenido);
			writer.newLine(); 
			writer.close();
			JOptionPane.showMessageDialog(null,"Pago realizado exitósamente", "CONFIRMACIÓN PAGO",  JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			
			catch(Exception e1) {
				e1.printStackTrace();
			}
				
			}
		
		}
	}
	




