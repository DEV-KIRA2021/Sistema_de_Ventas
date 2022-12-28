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


public class Modificar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static JTextField txtPrecio;
	private static JTextField txtAncho;
	private static JTextField txtAlto;
	private static JTextField txtFondo;
	private static JTextField txtCapacidad;
	private JComboBox<String> cboModelo = new JComboBox<String>();
	public static boolean esEditable;

	int modelo = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modificar dialog = new Modificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modificar() {
		System.out.println("L 44: " + esEditable);
		setTitle("Modificar Disco Duro");
		setBounds(100, 100, 599, 300);
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
		txtPrecio.setBounds(159, 56, 283, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(159, 96, 283, 20);
		getContentPane().add(txtAncho);

		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(159, 133, 283, 20);
		getContentPane().add(txtAlto);

		txtFondo = new JTextField();
		txtFondo.setColumns(10);
		txtFondo.setBounds(159, 177, 283, 20);
		getContentPane().add(txtFondo);

		txtCapacidad = new JTextField();
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

		btnCerrar.setBounds(473, 17, 100, 23);
		getContentPane().add(btnCerrar);

		JButton btnGrabar = new JButton("Grabar");

		btnGrabar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\grabar.png"));
		btnGrabar.setBounds(473, 55, 100, 23);
		getContentPane().add(btnGrabar);
		cboModelo.addActionListener(this);
		btnGrabar.addActionListener(this);
		btnCerrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BOTON: " + e.getActionCommand());
		if (e.getActionCommand().equals("Cerrar")) {
			dispose();
		}
		if (e.getSource() == cboModelo) {
			double precio, ancho, alto, fondo, capacidad;

			modelo = cboModelo.getSelectedIndex();
			precio = FrmMenu.getPrecio(modelo);
			ancho = FrmMenu.getAncho(modelo);
			alto = FrmMenu.getAlto(modelo);
			fondo = FrmMenu.getFondo(modelo);
			capacidad = FrmMenu.getCapacidad(modelo);
			mostrarDatos(precio, ancho, alto, fondo, capacidad);
		}
		

		if (e.getActionCommand().equals("Grabar")) {
			guardarDatos(cboModelo.getSelectedIndex());
		}

	}

	static void guardarDatos(int modelo) {
		System.out.println("MODELO: " + modelo);
		switch (modelo) {
		case 0:
			FrmMenu.precio0 = Double.parseDouble(txtPrecio.getText());
			FrmMenu.fondo0 = Double.parseDouble(txtFondo.getText());
			FrmMenu.ancho0 = Double.parseDouble(txtAncho.getText());
			FrmMenu.alto0 = Double.parseDouble(txtAlto.getText());
			FrmMenu.capacidad0 = Double.parseDouble(txtCapacidad.getText());
			break;

		case 1:
			FrmMenu.precio1 = Double.parseDouble(txtPrecio.getText());
			FrmMenu.fondo1 = Double.parseDouble(txtFondo.getText());
			FrmMenu.ancho1 = Double.parseDouble(txtAncho.getText());
			FrmMenu.alto1 = Double.parseDouble(txtAlto.getText());
			FrmMenu.capacidad1 = Double.parseDouble(txtCapacidad.getText());
			break;

		case 2:

			FrmMenu.precio2 = Double.parseDouble(txtPrecio.getText());
			FrmMenu.fondo2 = Double.parseDouble(txtFondo.getText());
			FrmMenu.ancho2 = Double.parseDouble(txtAncho.getText());
			FrmMenu.alto2 = Double.parseDouble(txtAlto.getText());
			FrmMenu.capacidad2 = Double.parseDouble(txtCapacidad.getText());
			break;

		case 3:

			FrmMenu.precio3 = Double.parseDouble(txtPrecio.getText());
			FrmMenu.fondo3 = Double.parseDouble(txtFondo.getText());
			FrmMenu.ancho3 = Double.parseDouble(txtAncho.getText());
			FrmMenu.alto3 = Double.parseDouble(txtAlto.getText());
			FrmMenu.capacidad3 = Double.parseDouble(txtCapacidad.getText());
			break;

		default:
			FrmMenu.precio4 = Double.parseDouble(txtPrecio.getText());
			FrmMenu.fondo4 = Double.parseDouble(txtFondo.getText());
			FrmMenu.ancho4 = Double.parseDouble(txtAncho.getText());
			FrmMenu.alto4 = Double.parseDouble(txtAlto.getText());
			FrmMenu.capacidad4 = Double.parseDouble(txtCapacidad.getText());
			break;

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
