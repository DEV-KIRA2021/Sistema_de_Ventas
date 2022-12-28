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
import java.awt.Color;

public class Cantidad extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cantidad dialog = new Cantidad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cantidad() {
		setBackground(new Color(128, 128, 0));
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 524, 137);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
			JLabel lblCantidad = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
			lblCantidad.setBounds(10, 22, 233, 14);
			contentPanel.add(lblCantidad);
		
		
			txtCantidad = new JTextField();
			txtCantidad.setBounds(242, 19, 86, 20);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
			txtCantidad.setText(String.valueOf(FrmMenu.cantidadOptima));
		
		
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\aceptar.png"));
			btnAceptar.setBounds(383, 18, 110, 23);
			contentPanel.add(btnAceptar);
		
		
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(383, 52, 110, 23);
			contentPanel.add(btnCancelar);
			btnAceptar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Aceptar")) {
			FrmMenu.cantidadOptima = Integer.parseInt(txtCantidad.getText());
			dispose();

		}
		
	}

}
