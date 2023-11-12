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

public class AñadirCarro extends JFrame implements ActionListener {
	
	private JLabel lblMarca;
	private JLabel lblPlaca;
	private JLabel lblColor;
	private JLabel lblModelo;
	private JLabel lblTipo_Trans;
	private JLabel lblCapacidad;
	private JLabel lblTipoMotor;
	
	
	private JLabel lblTexto1;
	private JLabel lblCentro;
	private JLabel lblNorte;
	private JLabel lblSur;
	private JLabel lblTexto2;
	private JLabel lblSUV;
	private JLabel lblPickup;
	private JLabel lblHatchback;
	private JLabel lblCoupe;
	private JLabel lblStationWagon;
	private JLabel lblMinivan;
	private JLabel lblSedan;
	private JLabel lblNada;
	private JLabel lblNada2;
	private JLabel lblNada3;
	
	
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtColor;
	private JTextField txtModelo;
	private JTextField txtTipo_Trans;
	private JTextField txtCapacidad;
	private JTextField txtTipoMotor;
	
	private JCheckBox checkBoxCentro;
    private JCheckBox checkNorte;
    private JCheckBox checkSur;
    private ButtonGroup buttonGroup;
    
    private JCheckBox checkSUV;
    private JCheckBox checkPickup;
    private JCheckBox checkHatchback;
    private JCheckBox checkCoupe;
    private JCheckBox checkStationWagon;
    private JCheckBox checkMinivan;
    private JCheckBox checkSedan;
    private ButtonGroup buttonGroup2;
    
    private JButton boton_agregar;
    private Principal principal;
    
    private ButtonModel selected_tipoveh;
    private ButtonModel selected_sede;
    
	
	
	public AñadirCarro(Principal p_principal) {
		principal = p_principal;
		setTitle("Añadir Carro al Inventario...");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height-50);
        setLayout(new BorderLayout());
        
        JPanel panel_izq = new JPanel();
        panel_izq.setLayout(new GridLayout(14,1,10,10));
        JPanel panel_der = new JPanel();
        panel_der.setLayout(new GridLayout(13,2,10,10));
        
		
		
        lblMarca = new JLabel("MARCA");
        lblMarca.setFont(new Font("Arial", Font.BOLD, 15));
        lblMarca.setForeground( Color.BLACK );
        lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblMarca);
        txtMarca = new JTextField( "" );
        panel_izq.add(txtMarca);
        
        
        lblPlaca = new JLabel("PLACA");
        lblPlaca.setFont(new Font("Arial", Font.BOLD, 15));
        lblPlaca.setForeground( Color.BLACK );
        lblPlaca.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblPlaca);
        txtPlaca = new JTextField( "" );
        panel_izq.add(txtPlaca);
        
        lblColor = new JLabel("COLOR");
        lblColor.setFont(new Font("Arial", Font.BOLD, 15));
        lblColor.setForeground( Color.BLACK );
        lblColor.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblColor);
        txtColor = new JTextField( "" );
        panel_izq.add(txtColor);
        
        lblModelo = new JLabel("MODELO");
        lblModelo.setFont(new Font("Arial", Font.BOLD, 15));
        lblModelo.setForeground( Color.BLACK );
        lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblModelo);
        txtModelo = new JTextField( "" );
        panel_izq.add(txtModelo);
        
        lblTipo_Trans = new JLabel("TIPO DE TRANSMISION");
        lblTipo_Trans.setFont(new Font("Arial", Font.BOLD, 15));
        lblTipo_Trans.setForeground( Color.BLACK );
        lblTipo_Trans.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblTipo_Trans);
        txtTipo_Trans = new JTextField( "" );
        panel_izq.add(txtTipo_Trans);
        
        
        lblCapacidad = new JLabel("CAPACIDAD AUTOMOVIL");
        lblCapacidad.setFont(new Font("Arial", Font.BOLD, 15));
        lblCapacidad.setForeground( Color.BLACK );
        lblCapacidad.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblCapacidad);
        txtCapacidad = new JTextField( "" );
        panel_izq.add(txtCapacidad);
        
        lblTipoMotor = new JLabel("TIPO DE MOTOR");
        lblTipoMotor.setFont(new Font("Arial", Font.BOLD, 15));
        lblTipoMotor.setForeground( Color.BLACK );
        lblTipoMotor.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblTipoMotor);
        txtTipoMotor = new JTextField( "" );
        panel_izq.add(txtTipoMotor);
        
        
        
        add(panel_izq, BorderLayout.WEST);
        
        
        lblTexto1 = new JLabel("Selecciona la sede a la que irá el carro: ");
        lblTexto1.setFont(new Font("Arial", Font.BOLD, 15));
        lblTexto1.setForeground( Color.BLACK );
        lblTexto1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblTexto1);
        
        lblNada = new JLabel("");
        panel_der.add(lblNada);
        
        lblCentro = new JLabel("1. Centro ");
        lblCentro.setFont(new Font("Arial", Font.BOLD, 15));
        lblCentro.setForeground( Color.BLACK );
        lblCentro.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblCentro);
        
        checkBoxCentro = new JCheckBox();
        panel_der.add(checkBoxCentro);
        
        
        lblNorte = new JLabel("2. Norte ");
        lblNorte.setFont(new Font("Arial", Font.BOLD, 15));
        lblNorte.setForeground( Color.BLACK );
        lblNorte.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblNorte);
        
        checkNorte= new JCheckBox();
        panel_der.add(checkNorte);
        
        lblSur = new JLabel("3. Sur ");
        lblSur.setFont(new Font("Arial", Font.BOLD, 15));
        lblSur.setForeground( Color.BLACK );
        lblSur.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblSur);
        
        checkSur = new JCheckBox();
        panel_der.add(checkSur);
        
        
        
        lblTexto2 = new JLabel("Selecciona el tipo de carro que agregarás: ");
        lblTexto2.setFont(new Font("Arial", Font.BOLD, 15));
        lblTexto2.setForeground( Color.BLACK );
        lblTexto2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblTexto2);
        
        
        lblNada = new JLabel("");
        panel_der.add(lblNada);
        
        lblSUV = new JLabel("1. SUV ");
        lblSUV.setFont(new Font("Arial", Font.BOLD, 15));
        lblSUV.setForeground( Color.BLACK );
        lblSUV.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblSUV);
        
        checkSUV = new JCheckBox();
        panel_der.add(checkSUV);
        
        lblPickup = new JLabel("2. PickUp ");
        lblPickup.setFont(new Font("Arial", Font.BOLD, 15));
        lblPickup.setForeground( Color.BLACK );
        lblPickup.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblPickup);
        
        checkPickup = new JCheckBox();
        panel_der.add(checkPickup);
        
        lblHatchback = new JLabel("3. Hatchback ");
        lblHatchback.setFont(new Font("Arial", Font.BOLD, 15));
        lblHatchback.setForeground( Color.BLACK );
        lblHatchback.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblHatchback);
        
        
        checkHatchback= new JCheckBox();
        panel_der.add(checkHatchback);
        
        lblCoupe = new JLabel("4. Coupé ");
        lblCoupe.setFont(new Font("Arial", Font.BOLD, 15));
        lblCoupe.setForeground( Color.BLACK );
        lblCoupe.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblCoupe);
        
        checkCoupe = new JCheckBox();
        panel_der.add(checkCoupe);
        
        lblStationWagon = new JLabel("5. Station Wagon ");
        lblStationWagon.setFont(new Font("Arial", Font.BOLD, 15));
        lblStationWagon.setForeground( Color.BLACK );
        lblStationWagon.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblStationWagon);
        
        checkStationWagon = new JCheckBox();
        panel_der.add(checkStationWagon);
        
        lblMinivan = new JLabel("6. Minivan ");
        lblMinivan.setFont(new Font("Arial", Font.BOLD, 15));
        lblMinivan.setForeground( Color.BLACK );
        lblMinivan.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblMinivan);
        
        checkMinivan= new JCheckBox();
        panel_der.add(checkMinivan);
        
        lblSedan = new JLabel("7. Sedan");
        lblSedan.setFont(new Font("Arial", Font.BOLD, 15));
        lblSedan.setForeground( Color.BLACK );
        lblSedan.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblSedan);
        
        checkSedan = new JCheckBox();
        panel_der.add(checkSedan);
        
        lblNada3 = new JLabel("");
        panel_der.add(lblNada3);
        

        boton_agregar = new JButton("AGREGAR VEHICULO");
        boton_agregar.setPreferredSize(new Dimension(150, 50));
        boton_agregar.setBackground( Color.BLUE );
        boton_agregar.setForeground( Color.WHITE );
        panel_der.add(boton_agregar);
        
       
        buttonGroup = new ButtonGroup();
        buttonGroup.add(checkBoxCentro);  
        buttonGroup.add(checkNorte); 
        buttonGroup.add(checkSur); 
        
      
        
        buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(checkSUV);  
        buttonGroup2.add(checkPickup); 
        buttonGroup2.add(checkHatchback);
        buttonGroup2.add(checkCoupe);
        buttonGroup2.add(checkStationWagon);
        buttonGroup2.add(checkMinivan);
        buttonGroup2.add(checkSedan);
        
        
       
        
        add(panel_der, BorderLayout.EAST);
        
        boton_agregar.addActionListener(this);
        boton_agregar.setActionCommand("Agregar_vehiculo");
        
        
        JPanel panel_libre = new JPanel();
        panel_libre.add(Box.createRigidArea(new Dimension(350, 250)));
        add(panel_libre, BorderLayout.CENTER);
        
       
        setLocationRelativeTo(null);
        setVisible(true);
      
        
        
  
        
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Agregar_vehiculo".equals(e.getActionCommand())) {
			try {
				principal.AgregarCarro(txtMarca.getText(), txtPlaca.getText(), txtModelo.getText(), 
						txtColor.getText(), txtTipo_Trans.getText(), Integer.parseInt(txtCapacidad.getText()), 
						txtTipoMotor.getText(), getTipoVehiculo(), getSede());
				
				JOptionPane.showMessageDialog(null, "Agregaste correctamente el vehiculo!!!", 
						"Añadir vehiculo Don German", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	public String getTipoVehiculo() {
		selected_tipoveh = buttonGroup2.getSelection();
		if (selected_tipoveh == checkSUV.getModel()) 
			return "SUV";
		else if (selected_tipoveh == checkPickup.getModel()) 
			return "Pickup";
		else if (selected_tipoveh == checkHatchback.getModel()) 
			return "Hatchback";
		else if (selected_tipoveh == checkCoupe.getModel()) 
			return "Coupe";
		else if (selected_tipoveh == checkStationWagon.getModel()) 
			return "Station Wagon";
		else if (selected_tipoveh == checkMinivan.getModel()) 
			return "Minivan";
		else //es dificil
			return "Sedan";

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
