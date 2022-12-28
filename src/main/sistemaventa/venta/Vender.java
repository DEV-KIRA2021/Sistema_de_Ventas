package main.sistemaventa.venta;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.sistemaventa.FrmMenu;

public class Vender extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtPrecio = new JTextField();
	private static JTextArea txaResultado = new JTextArea();
	private static JTextField txtCantidad = new JTextField();
	private JButton btnVender;
	private JButton btnCerrar;
	private static JComboBox cboModelo = new JComboBox();
	
	static double importeCompra;

	public static void main(String[] args) {
		try {
			Vender dialog = new Vender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vender() {
		setTitle("Vender");
		setBounds(100, 100, 534, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 96, 14);
		contentPanel.add(lblModelo);

		JLabel lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 42, 96, 14);
		contentPanel.add(lblPrecio);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 74, 96, 14);
		contentPanel.add(lblCantidad);
		cboModelo = new JComboBox<>();
		List<String> productos = FrmMenu.getModelos();
		for (String st : productos) {
			cboModelo.addItem(st);
		}
		cboModelo.setBounds(116, 7, 227, 22);
		contentPanel.add(cboModelo);

		txtPrecio.setEditable(false);
		txtPrecio.setBounds(116, 39, 227, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad.setColumns(10);
		txtCantidad.setBounds(116, 71, 227, 20);
		contentPanel.add(txtCantidad);

		JScrollPane scpResultado = new JScrollPane();
		scpResultado.setBounds(10, 99, 498, 214);
		contentPanel.add(scpResultado);

		scpResultado.setViewportView(txaResultado);
		txaResultado.setEditable(false);

	
		btnVender = new JButton("Vender");
		btnVender.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\venta.png"));
		btnVender.setBounds(381, 11, 115, 23);
		contentPanel.add(btnVender);

	
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
		btnCerrar.setBounds(381, 42, 115, 23);
		contentPanel.add(btnCerrar);

		txtCantidad.setEnabled(false);
		cboModelo.addActionListener(this);
		txtCantidad.addActionListener(this);
		btnVender.addActionListener(this);
		btnCerrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cboModelo) {
			if (cboModelo.getSelectedIndex() >= 1) {
				txtPrecio.setText("" + FrmMenu.getPrecio(cboModelo.getSelectedIndex() - 1));
				txtCantidad.setEnabled(true);
				txtCantidad.setText("1");

				calcularfactura(FrmMenu.getNombreModelo(cboModelo.getSelectedIndex() - 1),
						FrmMenu.getPrecio(cboModelo.getSelectedIndex() - 1));
			} else {
				reiniciarVenta();
			}
		}
		txtCantidad.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				txtCantidad.setText(txtCantidad.getText());
				calcularfactura(FrmMenu.getNombreModelo(cboModelo.getSelectedIndex() - 1),
						FrmMenu.getPrecio(cboModelo.getSelectedIndex() - 1));
			}
		});
		if (e.getActionCommand() == "Vender") {

			FrmMenu.importeGeneralAcumulado += importeCompra;
			FrmMenu.avanceVentas = FrmMenu.avanceVentas + 1;
			incrementarCantidades(cboModelo.getSelectedIndex() - 1, txtCantidad.getText());
			reiniciarVenta();
			if (FrmMenu.avanceVentas % 5 == 0) {
				String mensaje = "Venta Nro. " + FrmMenu.avanceVentas + "\nImporte total general acumulado: S/ "
						+ FrmMenu.importeGeneralAcumulado + "\nPorcentaje de la cuota diaria :"
						+ calcularPorcentajeMeta(FrmMenu.importeGeneralAcumulado) + "%";

				JOptionPane.showMessageDialog(null, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
			}

		}

		if (e.getActionCommand() == "Cerrar") {
			dispose();
		}

	}

	public static void incrementarCantidades(int modelo, String cantidadUnid) {
		int cant = Integer.parseInt(cantidadUnid);

		switch (modelo) {
		case 0:
			FrmMenu.cantModelo0 += 1;
			FrmMenu.cantVentasModelo0 += cant;
			break;
		case 1:
			FrmMenu.cantModelo1 += 1;
			FrmMenu.cantVentasModelo1 += cant;
			break;
		case 2:
			FrmMenu.cantModelo2 += 1;
			FrmMenu.cantVentasModelo2 += cant;
			break;
		case 3:
			FrmMenu.cantModelo3 += 1;
			FrmMenu.cantVentasModelo3 += cant;
			break;
		case 4:
			FrmMenu.cantModelo4 += 1;
			FrmMenu.cantVentasModelo4 += cant;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error", "Modelo no válido", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void reiniciarVenta() {
		cboModelo.setSelectedIndex(0);
		txtCantidad.setEnabled(false);
		txaResultado.setText("");
		txtCantidad.setText("0");
		txtPrecio.setText("");
	}

	public static double calcularPorcentajeMeta(double importeGeneralAcumulador) {
		return Math.round(((importeGeneralAcumulador * 100) / FrmMenu.cuotaDiaria) * 100.0) / 100.0;
	}

	public static double calcularImporteCompra(double precio) {
		return  (Integer.parseInt(txtCantidad.getText().equals("") ? "0" : txtCantidad.getText()) * precio);

	}

	public static double calcularDescuento(double importeCompra) {
		int cantidad = Integer.parseInt(txtCantidad.getText());

		if (cantidad >= 1 && cantidad <= 5) {
			return (importeCompra * FrmMenu.pct1_5) / 100;
		} else if (cantidad >= 6 && cantidad <= 10) {
			return (importeCompra * FrmMenu.pct6_10) / 100;

		} else if (cantidad >= 11 && cantidad <= 15) {
			return (importeCompra * FrmMenu.pct11_15) / 100;

		} else if (cantidad > 15) {
			return (importeCompra * FrmMenu.pct15) / 100;
		} else {
			return 0.0;
		}
	}

	public static int calcularCantidadRegalo() {
		int cantidad = Integer.parseInt(txtCantidad.getText());
		if (cantidad >= 1 && cantidad <= 5) {
			return FrmMenu.cantidad1;
		} else if (cantidad >= 6 && cantidad <= 10) {
			return FrmMenu.cantidad2;
		} else if (cantidad > 10) {
			return FrmMenu.cantidad3;
		} else {
			return 0;
		}
	}

	public static void calcularfactura(String modelo, double precio) {
		importeCompra = calcularImporteCompra(precio);
		double importeDsct = calcularDescuento(importeCompra);
		txaResultado.setText("");
		txaResultado.append("LISTADO DE DISCOS DUROS\n");
		txaResultado.append("\n");
		txaResultado.append("Modelo                              : " + modelo + "\n");
		txaResultado.append("Precio                                : S/ " + precio + "\n");
		txaResultado.append("Cantidad adquirida         : " + txtCantidad.getText() + "\n");
		txaResultado.append("Importe de Compra        : S/ " + importeCompra + "\n");
		txaResultado.append("Importe de Descuento   : S/ " + importeDsct + "\n");
		txaResultado.append("Importe a pagar               : S/ " + (importeCompra - importeDsct) + "\n");
		txaResultado.append("Tipo de obsequio            : " + FrmMenu.producto + "\n");
		txaResultado.append("Unidades obsequiadas : " + calcularCantidadRegalo() + "\n");
	}

}
