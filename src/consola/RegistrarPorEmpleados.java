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
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistrarPorEmpleados extends JFrame implements ActionListener{
	
	private JLabel text1;
	private JLabel textsede;
	private JTextField texto_id;
	private JButton boton_registrar;
	
	private JLabel lblCentro;
	private JLabel lblNorte;
	private JLabel lblSur;
	private JLabel lblNada;
	
	private JCheckBox checkBoxCentro;
    private JCheckBox checkNorte;
    private JCheckBox checkSur;
    private ButtonGroup buttonGroup;
    private ButtonModel selected_sede;
	
	private Principal principal;
	
	public RegistrarPorEmpleados (Principal p_principal) {
		
		principal = p_principal;
		
		setTitle("Registrar la entrega de un vehículo en la sede...");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height-50);
        setLayout(new BorderLayout());
        
        
        JPanel panel_central = new JPanel();
        panel_central.setLayout(new GridLayout(6,2,20,20));
        
        
        text1 = new JLabel("Ingrese el ID de la reserva : ");
        text1.setFont(new Font("Arial", Font.BOLD , 20));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setForeground( Color.BLACK );
        text1.setPreferredSize(new Dimension(150, 50));
        panel_central.add(text1);
        texto_id = new JTextField( "" );
        panel_central.add(texto_id);
        
        
        textsede = new JLabel("Escoge la sede donde recibes el automovil : ");
        textsede.setFont(new Font("Arial", Font.BOLD , 20));
        textsede.setHorizontalAlignment(SwingConstants.CENTER);
        textsede.setForeground( Color.BLACK );
        textsede.setPreferredSize(new Dimension(150, 50));
        panel_central.add(textsede);
        
        
        JLabel nada = new JLabel("");
        panel_central.add(nada);
        
        
        lblCentro = new JLabel("1. Centro ");
        lblCentro.setFont(new Font("Arial", Font.BOLD, 15));
        lblCentro.setForeground( Color.BLACK );
        lblCentro.setHorizontalAlignment(SwingConstants.CENTER);
        panel_central.add(lblCentro);
        
        checkBoxCentro = new JCheckBox();
        panel_central.add(checkBoxCentro);
        
        
        lblNorte = new JLabel("2. Norte ");
        lblNorte.setFont(new Font("Arial", Font.BOLD, 15));
        lblNorte.setForeground( Color.BLACK );
        lblNorte.setHorizontalAlignment(SwingConstants.CENTER);
        panel_central.add(lblNorte);
        
        checkNorte= new JCheckBox();
        panel_central.add(checkNorte);
        
        lblSur = new JLabel("3. Sur ");
        lblSur.setFont(new Font("Arial", Font.BOLD, 15));
        lblSur.setForeground( Color.BLACK );
        lblSur.setHorizontalAlignment(SwingConstants.CENTER);
        panel_central.add(lblSur);
        
        checkSur = new JCheckBox();
        panel_central.add(checkSur);
        
        JLabel nada2 = new JLabel("");
        panel_central.add(nada2);
        
        
        boton_registrar = new JButton("REGISTRAR ENTREGA CARRO");
        boton_registrar.setPreferredSize(new Dimension(200, 70));
        boton_registrar.setBackground( Color.BLUE );
        boton_registrar.setForeground( Color.WHITE );
        panel_central.add(boton_registrar);
        
        boton_registrar.addActionListener(this);
        boton_registrar.setActionCommand("registrar");
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(checkBoxCentro);  
        buttonGroup.add(checkNorte); 
        buttonGroup.add(checkSur);
        
        
		
        add(panel_central, BorderLayout.CENTER);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand( ).equals( "registrar" )) {
			try {
				principal.RegistrarEntrega(texto_id.getText(), getSede());
				JOptionPane.showMessageDialog(null, "Registraste correctamente la entrega!", 
						"Gracias por tu apoyo incondicional", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	public String getSede() {
		selected_sede = buttonGroup.getSelection();
		if (selected_sede == checkBoxCentro.getModel()) 
			return "centro";
		else if (selected_sede == checkNorte.getModel()) 
			return "norte";
		else
			return "sur";
}

}
