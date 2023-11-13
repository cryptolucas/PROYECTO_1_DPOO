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

public class EnviarAmantenimiento extends JFrame implements ActionListener{
	
	
	private JLabel lblplaca;
	private JLabel lblfecha;
	private JTextField txtplaca;
	private JTextField txtfecha;
	private JLabel textsede;
	private JLabel lblCentro;
	private JLabel lblNorte;
	private JLabel lblSur;
	private JLabel lblNada;
	
	private JCheckBox checkBoxCentro;
    private JCheckBox checkNorte;
    private JCheckBox checkSur;
    private ButtonGroup buttonGroup;
    private ButtonModel selected_sede;
    
    private JButton boton_enviar;
    private Principal principal;
    
    public EnviarAmantenimiento(Principal p_principal) {
    	
    	principal = p_principal;
    	
    	setTitle("Enviar un vehiculo a mantenimiento...");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
        setSize(1350,710);
        setLayout(new BorderLayout());
        
        
        JPanel panel_central = new JPanel();
        panel_central.setLayout(new GridLayout(7,2,20,20));
        
        
        lblplaca = new JLabel("Ingrese la placa del vehículo : ");
        lblplaca.setFont(new Font("Arial", Font.BOLD , 20));
        lblplaca.setHorizontalAlignment(SwingConstants.CENTER);
        lblplaca.setForeground( Color.BLACK );
        lblplaca.setPreferredSize(new Dimension(150, 50));
        panel_central.add(lblplaca);
        txtplaca = new JTextField( "" );
        panel_central.add(txtplaca);
        
        lblfecha = new JLabel("<html>Ingrese la fecha estimada<br> hasta la que estará en mantenimiento : </html>");
        lblfecha.setFont(new Font("Arial", Font.BOLD , 20));
        lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
        lblfecha.setForeground( Color.BLACK );
        lblfecha.setPreferredSize(new Dimension(150, 50));
        panel_central.add(lblfecha);
        txtfecha = new JTextField( "" );
        panel_central.add(txtfecha);
        
        
        textsede = new JLabel("<html>Recuerdanos la sede<br> donde te encuentras: </html>");
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
        
        boton_enviar = new JButton("ENVIAR EL CARRO A MANTENIMIENTO");
        boton_enviar.setPreferredSize(new Dimension(200, 70));
        boton_enviar.setBackground( Color.BLUE );
        boton_enviar.setForeground( Color.WHITE );
        panel_central.add(boton_enviar);
        
        boton_enviar.addActionListener(this);
        boton_enviar.setActionCommand("enviar");
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(Box.createRigidArea(new Dimension(250, 100)));
        add(panelVentanaPrincipalAba, BorderLayout.SOUTH);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(250, 100)));
        add(panelVentanaPrincipalArr, BorderLayout.NORTH);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(checkBoxCentro);  
        buttonGroup.add(checkNorte); 
        buttonGroup.add(checkSur);
        
        
		
        add(panel_central, BorderLayout.CENTER);
        
    	
    }
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand( ).equals( "enviar" )) {
			try {
				principal.EnviarMantenimiento(txtplaca.getText(), getSede(), txtfecha.getText());
				JOptionPane.showMessageDialog(null, "Enviaste el carro a mantenimiento!", 
						"Gracias por tu apoyo incondicional", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERROR!", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
				dispose();
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
