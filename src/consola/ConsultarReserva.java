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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsultarReserva extends JFrame implements ActionListener{
	
	
	private JLabel text1;
	private JTextField texto_id;
	private JButton boton_consultar;
	
	private Principal principal; 
	
	public ConsultarReserva(Principal p_principal){
		
		principal = p_principal;
		
		setTitle("Consultar Mi Reserva...");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height-50);
        setLayout(new BorderLayout());
        
        
        JPanel panel_central = new JPanel();
        panel_central.setLayout(new GridLayout(2,2,20,20));
        
        
        text1 = new JLabel("Ingresa el ID de la reserva a consultar: ");
        text1.setFont(new Font("Arial", Font.BOLD , 20));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setForeground( Color.BLACK );
        text1.setPreferredSize(new Dimension(150, 50));
        panel_central.add(text1);
        texto_id = new JTextField( "" );
        panel_central.add(texto_id);
        
        JLabel nada = new JLabel("");
        panel_central.add(nada);
        
        
        boton_consultar = new JButton("CONSULTAR RESERVA");
        boton_consultar.setPreferredSize(new Dimension(200, 70));
        boton_consultar.setBackground( Color.BLUE );
        boton_consultar.setForeground( Color.WHITE );
        panel_central.add(boton_consultar);
        
        boton_consultar.addActionListener(this);
        boton_consultar.setActionCommand("consultar");
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(250, 300)));
        add(panelVentanaPrincipalArr, BorderLayout.NORTH);
        
        JPanel panelQQ = new JPanel();
        panelQQ.add(Box.createRigidArea(new Dimension(250, 300)));
        add(panelQQ, BorderLayout.SOUTH);
		
        add(panel_central, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("consultar".equals(e.getActionCommand())){
			
			JOptionPane.showMessageDialog(null, principal.ConsultarReserva(texto_id.getText()),
					"Consultar Reserva", JOptionPane.INFORMATION_MESSAGE);
			
			dispose();
			
		}
		
	}

}
