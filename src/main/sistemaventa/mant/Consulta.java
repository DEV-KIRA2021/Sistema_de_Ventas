package main.sistemaventa.mant;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import main.sistemaventa.FrmMenu;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Consulta extends JDialog implements ActionListener {
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtCapacidad;
	JComboBox cboModelo = new JComboBox();
	public static boolean esEditable;

	int modelo = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consulta dialog = new Consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Consulta() {
		System.out.println("L 44: "+  esEditable);
		setTitle("Consultar Disco Duro");
		setBounds(100, 100, 609, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 21, 124, 14);
		getContentPane().add(lblModelo);

		JLabel lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 59, 124, 14);
		getContentPane().add(lblPrecio);

		JLabel lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 99, 124, 14);
		getContentPane().add(lblAncho);

		JLabel lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 136, 124, 14);
		getContentPane().add(lblAlto);

		JLabel lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 180, 124, 14);
		getContentPane().add(lblFondo);

		JLabel lblCapacidad = new JLabel("Capacidad (TB)");
		lblCapacidad.setBounds(10, 218, 124, 14);
		getContentPane().add(lblCapacidad);

		cboModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		List<String> productos = Arrays.asList(FrmMenu.modelo0, FrmMenu.modelo1, FrmMenu.modelo2, FrmMenu.modelo3,
				FrmMenu.modelo4);

		for (String st : productos) {
			cboModelo.addItem(st);
		}

		cboModelo.setBounds(159, 17, 283, 22);
		getContentPane().add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(159, 56, 283, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(159, 96, 283, 20);
		getContentPane().add(txtAncho);

		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setColumns(10);
		txtAlto.setBounds(159, 133, 283, 20);
		getContentPane().add(txtAlto);

		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setColumns(10);
		txtFondo.setBounds(159, 177, 283, 20);
		getContentPane().add(txtFondo);

		txtCapacidad = new JTextField();
		txtCapacidad.setEditable(false);
		txtCapacidad.setColumns(10);
		txtCapacidad.setBounds(159, 215, 283, 20);
		getContentPane().add(txtCapacidad);
		
		
		cboModelo.setToolTipText(FrmMenu.modelo0);
		txtPrecio.setText("" + FrmMenu.precio0);
		txtAncho.setText("" + FrmMenu.ancho0);
		txtAlto.setText("" + FrmMenu.alto0);
		txtFondo.setText("" + FrmMenu.fondo0);
		txtCapacidad.setText("" + FrmMenu.capacidad0);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(476, 17, 107, 23);
		getContentPane().add(btnCerrar);
		cboModelo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if (e.getSource() == cboModelo) {
			System.out.println(cboModelo.getSelectedItem());
			System.out.println(cboModelo.getSelectedIndex());
			
			double precio, ancho, alto, fondo, capacidad;

			modelo = cboModelo.getSelectedIndex();
			precio = FrmMenu.getPrecio(modelo);
			ancho = FrmMenu.getAncho(modelo);
			alto = FrmMenu.getAlto(modelo);
			fondo = FrmMenu.getFondo(modelo);
			capacidad = FrmMenu.getCapacidad(modelo);
			mostrarDatos(precio, ancho, alto, fondo, capacidad);
		}
	}
	
	
	void mostrarDatos(double precio, double ancho, double alto, double fondo, double capacidad) {
		txtPrecio.setText(precio + "\n");
		txtAncho.setText(ancho + "\n");
		txtAlto.setText(alto + "\n");
		txtFondo.setText(fondo + "\n");
		txtCapacidad.setText(capacidad + "\n");
	}
	
		
	
}
