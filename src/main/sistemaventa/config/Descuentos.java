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

public class Descuentos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUnidades1;
	private JTextField txtUnidades2;
	private JTextField txtUnidades3;
	private JTextField txtUnidades4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Descuentos dialog = new Descuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Descuentos() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 432, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
			JLabel lblUnidades1 = new JLabel("1 a 5 unidades                                                  %");
			lblUnidades1.setBounds(10, 21, 253, 14);
			contentPanel.add(lblUnidades1);
		
		
			JLabel lblUnidades2 = new JLabel("6 a 10 unidades                                                %");
			lblUnidades2.setBounds(10, 55, 253, 14);
			contentPanel.add(lblUnidades2);
		
		
			JLabel lblUnidades3 = new JLabel("11 a 15 unidades                                             %");
			lblUnidades3.setBounds(10, 89, 253, 14);
			contentPanel.add(lblUnidades3);
		
		
			JLabel lblUnidades4 = new JLabel("M\u00E1s de 15 unidades                                        %");
			lblUnidades4.setBounds(10, 122, 253, 14);
			contentPanel.add(lblUnidades4);
		
		
			txtUnidades1 = new JTextField();
			txtUnidades1.setBounds(137, 18, 86, 20);
			txtUnidades1.setText(String.valueOf(FrmMenu.pct1_5));
			contentPanel.add(txtUnidades1);
			txtUnidades1.setColumns(10);
		
		
			txtUnidades2 = new JTextField();
			txtUnidades2.setBounds(137, 52, 86, 20);
			txtUnidades2.setText(String.valueOf(FrmMenu.pct6_10));
			contentPanel.add(txtUnidades2);
			txtUnidades2.setColumns(10);
		
		
			txtUnidades3 = new JTextField();
			txtUnidades3.setBounds(137, 86, 86, 20);
			txtUnidades3.setText(String.valueOf(FrmMenu.pct11_15));
			contentPanel.add(txtUnidades3);
			txtUnidades3.setColumns(10);
		
		
			txtUnidades4 = new JTextField();
			txtUnidades4.setBounds(137, 119, 86, 20);
			txtUnidades4.setText(String.valueOf(FrmMenu.pct15));
			contentPanel.add(txtUnidades4);
			txtUnidades4.setColumns(10);
		
		
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\aceptar.png"));
			btnAceptar.setBounds(291, 33, 106, 23);
			contentPanel.add(btnAceptar);
		
		
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(291, 67, 106, 23);
			contentPanel.add(btnCancelar);
			btnAceptar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Aceptar")) {
			FrmMenu.pct1_5 = Double.parseDouble(txtUnidades1.getText());
			FrmMenu.pct6_10 = Double.parseDouble(txtUnidades2.getText());
			FrmMenu.pct11_15 = Double.parseDouble(txtUnidades3.getText());
			FrmMenu.pct15 = Double.parseDouble(txtUnidades4.getText());
			dispose();
		}
		
	}

}
