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

public class Obsequios extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTipo;
	private JTextField txtUnidades1;
	private JTextField txtUnidades2;
	private JTextField txtUnidades3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Obsequios dialog = new Obsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Obsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 417, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblTipo = new JLabel("Tipo de obsequio");
		lblTipo.setBounds(10, 11, 102, 14);
		contentPanel.add(lblTipo);

		JLabel lblUnidades1 = new JLabel("1 a 5 unidades");
		lblUnidades1.setBounds(10, 47, 102, 14);
		contentPanel.add(lblUnidades1);

		JLabel lblUnidades2 = new JLabel("6  a 10 unidades");
		lblUnidades2.setBounds(10, 88, 102, 14);
		contentPanel.add(lblUnidades2);

		JLabel lblUnidades3 = new JLabel("11 a m\u00E1s unidades");
		lblUnidades3.setBounds(10, 123, 125, 14);
		contentPanel.add(lblUnidades3);

		txtTipo = new JTextField();
		txtTipo.setBounds(133, 8, 86, 20);
		contentPanel.add(txtTipo);
		txtTipo.setColumns(10);

		txtUnidades1 = new JTextField();
		txtUnidades1.setBounds(133, 44, 86, 20);
		contentPanel.add(txtUnidades1);
		txtUnidades1.setColumns(10);

		txtUnidades2 = new JTextField();
		txtUnidades2.setBounds(133, 85, 86, 20);
		contentPanel.add(txtUnidades2);
		txtUnidades2.setColumns(10);

		txtUnidades3 = new JTextField();
		txtUnidades3.setBounds(133, 123, 86, 20);
		contentPanel.add(txtUnidades3);
		txtUnidades3.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\aceptar.png"));
		btnAceptar.setBounds(269, 7, 115, 23);
		contentPanel.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(269, 43, 115, 23);
		contentPanel.add(btnCancelar);
		
		
		txtTipo.setText(String.valueOf(FrmMenu.producto));
		txtUnidades1.setText(String.valueOf(FrmMenu.cantidad1));
		txtUnidades2.setText(String.valueOf(FrmMenu.cantidad2));
		txtUnidades3.setText(String.valueOf(FrmMenu.cantidad3));
		
		
		btnAceptar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Aceptar")) {
			FrmMenu.producto = txtTipo.getText();
			FrmMenu.cantidad1 = Integer.parseInt(txtUnidades1.getText());
			FrmMenu.cantidad2 = Integer.parseInt(txtUnidades2.getText());
			FrmMenu.cantidad3 = Integer.parseInt(txtUnidades3.getText());
			dispose();

		}

	}
}
