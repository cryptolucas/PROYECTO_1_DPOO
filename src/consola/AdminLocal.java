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

public class AdminLocal extends JFrame implements ActionListener{
	
	private JLabel lbllogin;
	private JLabel lblcontraseña;
	private JLabel lblnombre;
	private JLabel lblid;
	
	private JTextField txtlogin;
	private JTextField txtcontraseña;
	private JTextField txtnombre;
	private JTextField txtid;
	
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
    
    private JButton boton_agregarEmpleado;
    private Principal principal;
	
	
	public AdminLocal (Principal p_principal) {
		
		principal = p_principal;
		
		setTitle("Agregar empleado al sistema");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
        setSize(1350,710);
        setLayout(new BorderLayout());
        
        
        JPanel panel_norte = new JPanel();
        JLabel titulo = new JLabel("Registrar un Nuevo Empleado");
        titulo.setFont(new Font("Arial", Font.BOLD , 33));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground( Color.BLACK );
        titulo.setPreferredSize(new Dimension(550, 100));
        panel_norte.add(titulo);
        
        
        JPanel panel_izq = new JPanel();
        panel_izq.setLayout(new GridLayout(9,2,20,20));
        
        
        lbllogin = new JLabel("Ingrese el login asignado : ");
        lbllogin.setFont(new Font("Arial", Font.BOLD , 20));
        lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
        lbllogin.setForeground( Color.BLACK );
        lbllogin.setPreferredSize(new Dimension(150, 50));
        panel_izq.add(lbllogin);
        txtlogin = new JTextField( "" );
        panel_izq.add(txtlogin);
        
        lblcontraseña = new JLabel("Ingrese la contraseña asignada : ");
        lblcontraseña.setFont(new Font("Arial", Font.BOLD , 20));
        lblcontraseña.setHorizontalAlignment(SwingConstants.CENTER);
        lblcontraseña.setForeground( Color.BLACK );
        lblcontraseña.setPreferredSize(new Dimension(150, 50));
        panel_izq.add(lblcontraseña);
        txtcontraseña = new JTextField( "" );
        panel_izq.add(txtcontraseña);
        
        lblnombre = new JLabel("Ingrese el nombre del empleado : ");
        lblnombre.setFont(new Font("Arial", Font.BOLD , 20));
        lblnombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblnombre.setForeground( Color.BLACK );
        lblnombre.setPreferredSize(new Dimension(150, 50));
        panel_izq.add(lblnombre);
        txtnombre = new JTextField( "" );
        panel_izq.add(txtnombre);
        
        lblid = new JLabel("Ingrese el ID que usará empleado : ");
        lblid.setFont(new Font("Arial", Font.BOLD , 20));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setForeground( Color.BLACK );
        lblid.setPreferredSize(new Dimension(150, 50));
        panel_izq.add(lblid);
        txtid = new JTextField( "" );
        panel_izq.add(txtid);
        
     
        
        textsede = new JLabel("Selecciona la sede donde trabajará el empleado: ");
        textsede.setFont(new Font("Arial", Font.BOLD , 20));
        textsede.setHorizontalAlignment(SwingConstants.CENTER);
        textsede.setForeground( Color.BLACK );
        textsede.setPreferredSize(new Dimension(150, 50));
        panel_izq.add(textsede);
        
        
        JLabel nada = new JLabel("");
        panel_izq.add(nada);
        
        
        lblCentro = new JLabel("1. Centro ");
        lblCentro.setFont(new Font("Arial", Font.BOLD, 15));
        lblCentro.setForeground( Color.BLACK );
        lblCentro.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblCentro);
        
        checkBoxCentro = new JCheckBox();
        panel_izq.add(checkBoxCentro);
        
        
        lblNorte = new JLabel("2. Norte ");
        lblNorte.setFont(new Font("Arial", Font.BOLD, 15));
        lblNorte.setForeground( Color.BLACK );
        lblNorte.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblNorte);
        
        checkNorte= new JCheckBox();
        panel_izq.add(checkNorte);
        
        lblSur = new JLabel("3. Sur ");
        lblSur.setFont(new Font("Arial", Font.BOLD, 15));
        lblSur.setForeground( Color.BLACK );
        lblSur.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblSur);
        
        checkSur = new JCheckBox();
        panel_izq.add(checkSur);
        
        JLabel nada2 = new JLabel("");
        panel_izq.add(nada2);
        
        
        JPanel panel_sur = new JPanel();
        boton_agregarEmpleado = new JButton("REGISTRAR AL NUEVO EMPLEADO");
        boton_agregarEmpleado.setPreferredSize(new Dimension(350, 70));
        boton_agregarEmpleado.setBackground( Color.BLUE );
        boton_agregarEmpleado.setForeground( Color.WHITE );
        panel_sur.add(boton_agregarEmpleado);
        
        boton_agregarEmpleado.addActionListener(this);
        boton_agregarEmpleado.setActionCommand("empleado");
        
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(checkBoxCentro);  
        buttonGroup.add(checkNorte); 
        buttonGroup.add(checkSur);
        
        add(panel_norte, BorderLayout.NORTH);
        add(panel_izq, BorderLayout.CENTER); 
   
        add(panel_sur, BorderLayout.SOUTH); 
        
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand( ).equals( "empleado" )) {
			
			try {
				principal.CrearEmpleado(txtlogin.getText(), txtcontraseña.getText(),
						"empleado", txtnombre.getText(), txtid.getText(), getSede());
				
				JOptionPane.showMessageDialog(null, "Registraste al empleado exitosamente!", 
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
