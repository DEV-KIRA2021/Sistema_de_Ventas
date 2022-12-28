package main.sistemaventa.config;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.sistemaventa.FrmMenu;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Cuota extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cuota dialog = new Cuota();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cuota() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 462, 136);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
			JLabel lblCuota = new JLabel("Cuota diaria esperada (S/.)");
			lblCuota.setBounds(10, 22, 178, 14);
			contentPanel.add(lblCuota);
		
		
			txtCuota = new JTextField();
			txtCuota.setBounds(198, 19, 86, 20);
			contentPanel.add(txtCuota);
			txtCuota.setColumns(10);
			txtCuota.setText(String.valueOf(FrmMenu.cuotaDiaria));
		
		
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\aceptar.png"));
			btnAceptar.setBounds(322, 18, 114, 23);
			contentPanel.add(btnAceptar);
		
		
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(322, 52, 114, 23);
			contentPanel.add(btnCancelar);
			btnAceptar.addActionListener(this);	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Aceptar")) {
			FrmMenu.cuotaDiaria = Double.parseDouble(txtCuota.getText());
			dispose();

		}
		
	}

}
