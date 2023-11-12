package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RealizarReserva extends JFrame implements ActionListener {
	
	
	
	private JLabel lblNombre;
	private JLabel lblLicencia;
	private JLabel lblCedula;
	private JLabel lblSedeOrigen;
	private JLabel lblSedeDestino;
	private JLabel lblFecha1;
	private JLabel lblFecha2;
	private JLabel lblMetodoPago;
	private JLabel lblConductoresAdicionales;
	
	private JLabel lblText1;
	private JLabel lblSeguroBasico;
	private JLabel lblSeguroIntermedio;
	private JLabel lblSeguroCompleto;
	private JLabel lblSinSeguro;
	private JCheckBox checkBasico;
    private JCheckBox checkIntermedio;
    private JCheckBox checkCompleto;
    private JCheckBox checkSinSeguro;
    private ButtonGroup buttonGroup;
    private ButtonModel selected_seguro;
    
    
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
	
	private JCheckBox checkSUV;
    private JCheckBox checkPickup;
    private JCheckBox checkHatchback;
    private JCheckBox checkCoupe;
    private JCheckBox checkStationWagon;
    private JCheckBox checkMinivan;
    private JCheckBox checkSedan;
    private ButtonGroup buttonGroup2;
    private ButtonModel selected_tipoveh;
	
	
	
	
	private JTextField txtNombre;
	private JTextField txtLicencia;
	private JTextField txtCedula;
	private JTextField txtSedeOrigen;
	private JTextField txtSedeDestino;
	private JTextField txtFecha1;
	private JTextField txtFecha2;
	private JTextField txtMetodoPago;
	private JTextField txtConductoresAdicionales;
	
	private JComboBox<String> sedes;
	private JComboBox<String> sedes2;
	private JComboBox<String> metodo_pago;
	
	private JButton boton_reserva;
	
	private Principal principal;
	
	public RealizarReserva(Principal p_principal) {
		
		principal = p_principal;
		
		setTitle("Realizar Mi Reserva...");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height-50);
        setLayout(new BorderLayout());
        
        JPanel panel_principal = new JPanel();
        panel_principal.setLayout(new BorderLayout());
        
        JPanel panel_norte = new JPanel();
        panel_norte.setLayout(new GridLayout(9,2,10,10));
        JPanel panel_sur = new JPanel();
        panel_sur.setLayout(new GridLayout(14,2,10,10));
        

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Arial", Font.BOLD , 15));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setForeground( Color.BLACK );
        lblNombre.setPreferredSize(new Dimension(150, 50));
        panel_norte.add(lblNombre);
        txtNombre = new JTextField( "" );
        panel_norte.add(txtNombre);
        
        lblLicencia = new JLabel("Numero de licencia de conducción");
        lblLicencia.setFont(new Font("Arial", Font.BOLD, 15));
        lblLicencia.setForeground( Color.BLACK );
        lblLicencia.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblLicencia);
        txtLicencia = new JTextField( "" );
        panel_norte.add(txtLicencia);
        
        lblCedula = new JLabel("Cedula de Ciudadania");
        lblCedula.setFont(new Font("Arial", Font.BOLD, 15));
        lblCedula.setForeground( Color.BLACK );
        lblCedula.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblCedula);
        txtCedula = new JTextField( "" );
        panel_norte.add(txtCedula);
        
        lblSedeOrigen = new JLabel("Sede donde recibirás el vehiculo");
        lblSedeOrigen.setFont(new Font("Arial", Font.BOLD, 15));
        lblSedeOrigen.setForeground( Color.BLACK );
        lblSedeOrigen.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblSedeOrigen);
        
        String opciones[] = {
        		"Norte",
        		"Sur",
        		"Centro"
        };
        sedes = new JComboBox<String>(opciones);
        sedes.setBackground( Color.WHITE );
        sedes.setForeground( Color.BLACK );
        panel_norte.add( sedes );
        sedes.addActionListener(sedes);
        sedes.addActionListener( this );
        
        
        lblSedeDestino = new JLabel("Sede donde entregarás el vehiculo");
        lblSedeDestino.setFont(new Font("Arial", Font.BOLD, 15));
        lblSedeDestino.setForeground( Color.BLACK );
        lblSedeDestino.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblSedeDestino);
        
        sedes2= new JComboBox<String>(opciones);
        sedes2.setBackground( Color.WHITE );
        sedes2.setForeground( Color.BLACK );
        panel_norte.add( sedes2 );
        sedes2.addActionListener(sedes2);
        sedes2.addActionListener( this );
        
        
       
        
        lblFecha1 = new JLabel("Escribe la fecha de recogida:   'yyyy-MM-dd'T'HH:mm:ss' ");
        lblFecha1.setFont(new Font("Arial", Font.BOLD, 15));
        lblFecha1.setForeground( Color.BLACK );
        lblFecha1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblFecha1);
        txtFecha1 = new JTextField( "" );
        panel_norte.add(txtFecha1);
        
        lblFecha2 = new JLabel("Escribe la fecha de entrega en la sede:   'yyyy-MM-dd'T'HH:mm:ss' ");
        lblFecha2.setFont(new Font("Arial", Font.BOLD, 15));
        lblFecha2.setForeground( Color.BLACK );
        lblFecha2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblFecha2);
        txtFecha2 = new JTextField( "" );
        panel_norte.add(txtFecha2);
        
        
        
        
        
        lblMetodoPago = new JLabel("Escoge tu metodo de pago");
        lblMetodoPago.setFont(new Font("Arial", Font.BOLD, 15));
        lblMetodoPago.setForeground( Color.BLACK );
        lblMetodoPago.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblMetodoPago);
        
        
        String opciones2[] = {
        		"Nequi",
        		"Daviplata",
        		"Tarjeta de credito", "Tarjeta de debito"
        };
        metodo_pago = new JComboBox<String>(opciones2);
        metodo_pago.setBackground( Color.WHITE );
        metodo_pago.setForeground( Color.BLACK );
        panel_norte.add( metodo_pago );
        metodo_pago.addActionListener(metodo_pago);
        metodo_pago.addActionListener( this );
        
        
        lblConductoresAdicionales = new JLabel("Escriba el numero de conductores adicionales (numero del 1 al 5)");
        lblConductoresAdicionales.setFont(new Font("Arial", Font.BOLD, 15));
        lblConductoresAdicionales.setForeground( Color.BLACK );
        lblConductoresAdicionales.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(lblConductoresAdicionales);
        txtConductoresAdicionales= new JTextField( "" );
        panel_norte.add(txtConductoresAdicionales);
        
        panel_principal.add(panel_norte, BorderLayout.NORTH);
        
        
        lblText1 = new JLabel("Seleccione los seguros que quiera para su renta");
        lblText1.setFont(new Font("Arial", Font.BOLD, 25));
        lblText1.setForeground( Color.BLACK );
        lblText1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblText1);
        JLabel nada = new JLabel("");
        panel_sur.add(nada);
        
        

        lblSeguroBasico = new JLabel("1. Seguro Básico: $45,000 COP");
        lblSeguroBasico.setFont(new Font("Arial", Font.BOLD, 15));
        lblSeguroBasico.setForeground( Color.BLACK );
        lblSeguroBasico.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblSeguroBasico);
        checkBasico= new JCheckBox();
        panel_sur.add(checkBasico);
        
        
        lblSeguroIntermedio= new JLabel("2. Seguro Intermedio: $70,000 COP");
        lblSeguroIntermedio.setFont(new Font("Arial", Font.BOLD, 15));
        lblSeguroIntermedio.setForeground( Color.BLACK );
        lblSeguroIntermedio.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblSeguroIntermedio);
        checkIntermedio= new JCheckBox();
        panel_sur.add(checkIntermedio);
        
        lblSeguroCompleto = new JLabel("3. Seguro Completo: $98,000 COP");
        lblSeguroCompleto.setFont(new Font("Arial", Font.BOLD, 15));
        lblSeguroCompleto.setForeground( Color.BLACK );
        lblSeguroCompleto.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblSeguroCompleto);
        checkCompleto = new JCheckBox();
        panel_sur.add(checkCompleto);
        

        lblSinSeguro = new JLabel("4. No deseo comprar ningún seguro ");
        lblSinSeguro.setFont(new Font("Arial", Font.BOLD, 15));
        lblSinSeguro.setForeground( Color.BLACK );
        lblSinSeguro.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblSinSeguro);
        checkSinSeguro = new JCheckBox();
        panel_sur.add(checkSinSeguro);
        
        
        
        lblTexto2 = new JLabel("Selecciona el tipo de carro que agregarás: ");
        lblTexto2.setFont(new Font("Arial", Font.BOLD, 25));
        lblTexto2.setForeground( Color.BLACK );
        lblTexto2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblTexto2);
        
        
        lblNada = new JLabel("");
        panel_sur.add(lblNada);
        
        lblSUV = new JLabel("1. SUV ");
        lblSUV.setFont(new Font("Arial", Font.BOLD, 15));
        lblSUV.setForeground( Color.BLACK );
        lblSUV.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblSUV);
        
        checkSUV = new JCheckBox();
        panel_sur.add(checkSUV);
        
        lblPickup = new JLabel("2. PickUp ");
        lblPickup.setFont(new Font("Arial", Font.BOLD, 15));
        lblPickup.setForeground( Color.BLACK );
        lblPickup.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblPickup);
        
        checkPickup = new JCheckBox();
        panel_sur.add(checkPickup);
        
        lblHatchback = new JLabel("3. Hatchback ");
        lblHatchback.setFont(new Font("Arial", Font.BOLD, 15));
        lblHatchback.setForeground( Color.BLACK );
        lblHatchback.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblHatchback);
        
        
        checkHatchback= new JCheckBox();
        panel_sur.add(checkHatchback);
        
        lblCoupe = new JLabel("4. Coupé ");
        lblCoupe.setFont(new Font("Arial", Font.BOLD, 15));
        lblCoupe.setForeground( Color.BLACK );
        lblCoupe.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblCoupe);
        
        checkCoupe = new JCheckBox();
        panel_sur.add(checkCoupe);
        
        lblStationWagon = new JLabel("5. Station Wagon ");
        lblStationWagon.setFont(new Font("Arial", Font.BOLD, 15));
        lblStationWagon.setForeground( Color.BLACK );
        lblStationWagon.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblStationWagon);
        
        checkStationWagon = new JCheckBox();
        panel_sur.add(checkStationWagon);
        
        lblMinivan = new JLabel("6. Minivan ");
        lblMinivan.setFont(new Font("Arial", Font.BOLD, 15));
        lblMinivan.setForeground( Color.BLACK );
        lblMinivan.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblMinivan);
        
        checkMinivan= new JCheckBox();
        panel_sur.add(checkMinivan);
        
        lblSedan = new JLabel("7. Sedan");
        lblSedan.setFont(new Font("Arial", Font.BOLD, 15));
        lblSedan.setForeground( Color.BLACK );
        lblSedan.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(lblSedan);
        
        checkSedan = new JCheckBox();
        panel_sur.add(checkSedan);
        
        lblNada3 = new JLabel("");
        panel_sur.add(lblNada3);
        
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(checkBasico);  
        buttonGroup.add(checkIntermedio); 
        buttonGroup.add(checkCompleto); 
        buttonGroup.add(checkSinSeguro); 
        
      
        
        buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(checkSUV);  
        buttonGroup2.add(checkPickup); 
        buttonGroup2.add(checkHatchback);
        buttonGroup2.add(checkCoupe);
        buttonGroup2.add(checkStationWagon);
        buttonGroup2.add(checkMinivan);
        buttonGroup2.add(checkSedan);
        
        
        boton_reserva = new JButton("GENERAR RESERVA");
        boton_reserva.setPreferredSize(new Dimension(150, 50));
        boton_reserva.setBackground( Color.BLUE );
        boton_reserva.setForeground( Color.WHITE );
        panel_sur.add(boton_reserva);
        
        
        
        
        
        panel_principal.add(panel_sur, BorderLayout.SOUTH);
        
        boton_reserva.addActionListener(this);
        boton_reserva.setActionCommand("reservar");
        
        
        JScrollPane scrollPane = new JScrollPane(panel_principal);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);
        
        
        setLocationRelativeTo(null);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("reservar".equals(e.getActionCommand())) {
			try {
				JOptionPane.showMessageDialog(null, principal.CrearReserva(txtNombre.getText(), txtLicencia.getText(),
						txtCedula.getText(), getSedeOrigen(), getSedeDestino(), 
						txtFecha1.getText(), txtFecha2.getText(), getMetodoPago(), Integer.parseInt(txtConductoresAdicionales.getText()),
								getSeguro(), getTipoVehiculo()), "Creando tu reserva",  JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (HeadlessException | NumberFormatException | IOException e1) {
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

	
	
	public String getSeguro() {
		selected_seguro = buttonGroup.getSelection();
		if (selected_seguro == checkBasico.getModel()) 
			return "1";
			
		else if (selected_seguro == checkIntermedio.getModel()) 
				return "2";
		
		else if (selected_seguro == checkCompleto.getModel()) 
			return "3";
		
		
		else
			return "4";
		
		
		}
	
	
	
	public String getSedeOrigen() {
		String selectedValue = (String) sedes.getSelectedItem();
		
		if (selectedValue.equals("Norte")) 
			return "norte";
		else if (selectedValue.equals("Sur")) 
			return "sur";
		
		else 
		return "centro";
	}
	
	public String getSedeDestino() {
		String selectedValue = (String) sedes2.getSelectedItem();
		
		if (selectedValue.equals("Norte")) 
			return "norte";
		else if (selectedValue.equals("Sur")) 
			return "sur";
		
		else 
		return "centro";
	}
	
	
	public String getMetodoPago() {
		String selectedValue = (String) metodo_pago.getSelectedItem();
		
		if (selectedValue.equals("Nequi")) 
			return "Nequi";
		else if (selectedValue.equals("Daviplata")) 
			return "Daviplata";
		
		else if (selectedValue.equals("Tarjeta de credito")) 
			return "Tarjeta de credito";
		
		else 
		return "Tarjeta de debito";
	}
	
	
	
		}


