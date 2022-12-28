package main.sistemaventa.venta;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.sistemaventa.FrmMenu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Reportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private static JComboBox cboReporte = new JComboBox();
	private JButton btnCerrar;
	private static JTextArea txtResultado = new JTextArea();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reportes dialog = new Reportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 667, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblReporte = new JLabel("Tipo de reporte");
		lblReporte.setBounds(10, 11, 130, 14);
		contentPanel.add(lblReporte);
		cboReporte = new JComboBox<>();
		List<String> reportes = Arrays.asList("Seleccione tipo reporte", "Ventas por modelo",
				"Razón de precios en relación al precio mayor", "Estadística sobre la cantidad óptima",
				"Estadística sobre el precio");
		for (String r : reportes) {
			cboReporte.addItem(r);
		}
		cboReporte.setBounds(116, 7, 317, 22);
		contentPanel.add(cboReporte);

		JScrollPane scpResultado = new JScrollPane();
		scpResultado.setBounds(10, 42, 631, 208);
		contentPanel.add(scpResultado);

		scpResultado.setViewportView(txtResultado);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
		btnCerrar.setBounds(524, 7, 117, 23);
		contentPanel.add(btnCerrar);
		btnCerrar.addActionListener(this);
		cboReporte.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cboReporte) {
			if (cboReporte.getSelectedIndex() >= 1) {
				filtrarReporte(cboReporte.getSelectedIndex() - 1);
			} else {
				cboReporte.setSelectedIndex(0);
				txtResultado.setText("");
			}
		}

		if (e.getActionCommand() == "Cerrar") {
			dispose();
		}
		
		
	}

	private static void filtrarReporte(int cboIndex) {
		switch (cboIndex) {
		case 0: {
			ventaPorModelo();
			break;
		}
		case 1: {
			razonDePrecios();
			break;
		}
		case 2: {
			estadCantOptima();
			break;
		}
		case 3: {
			estadPrecio();
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, "Error", "Reporte no válido", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static void ventaPorModelo() {
		String title = "VENTAS POR MODELO\n\n";
		txtResultado.setText(title);

		for (int i = 0; i <= 4; i++) {
			txtResultado.append("Modelo                                                 : "+FrmMenu.getNombreModelo(i)+"\n");
			txtResultado.append("Cantidad de ventas                           : "+FrmMenu.getCantVentasXModelo(i)+"\n");
			txtResultado.append("Cantidad de unidades vendidas    : "+FrmMenu.getUndVentasXModelo(i)+"\n");
			txtResultado.append("Importe total vendido                        : S/."+ calcularImporteTotalxModelo(i)+"\n");
			txtResultado.append("Aporte a la cuota diaria                    :  "+calcularPorcCuotaDiaria(i)+"%");
			txtResultado.append("\n\n");
		}
	}

	private static void razonDePrecios() {
		String title = "RAZÓN DE PRECIOS EN RELACIÓN AL PRECIO MAYOR\n\n";
		txtResultado.setText(title);
		
		for (int i = 0; i <= 4; i++) {
			txtResultado.append("Modelo : "+FrmMenu.getNombreModelo(i)+"\n");
			txtResultado.append("Precio  : "+FrmMenu.getPrecio(i)+"\n");
			txtResultado.append("Razón  : "+calcularRazon(i)+"\n");
			txtResultado.append("\n\n");
		}

	}



	private static void estadCantOptima() {
		String title = "ESTADÍSTICA SOBRE LA CANTIDAD ÓPTIMA\n\n";
		txtResultado.setText(title);	

			txtResultado.append("Cantidad de modelos que superaron la cantidad óptima        : " +"\n" );
			txtResultado.append("Cantidad de modelos que no superaron la cantidad óptima   : "+"\n");
			txtResultado.append("Cantidad de modelos que igualaron la cantidad óptima          : "+"\n");
			txtResultado.append("\n\n");

	}

	private static void estadPrecio() {
		String title = "ESTADÍSTICA SOBRE EL PRECIO\n\n";
		txtResultado.setText(title);
	}
	
	private static double calcularImporteTotalxModelo(int modelo) {
		int cant = FrmMenu.getUndVentasXModelo(modelo);
		double precio = FrmMenu.getPrecio(modelo);
		return cant*precio;
	}
	
	private static double calcularPorcCuotaDiaria(int modelo) {
		double monto = calcularImporteTotalxModelo(modelo);
		return Math.round(((monto * 100) / FrmMenu.cuotaDiaria) * 100.0) / 100.0;
	}
	
	private static double calcularRazon(int modelo) {
		double precio = FrmMenu.getPrecio(modelo);
		return Math.round(((precio) / FrmMenu.precio0) * 100.0) / 100.0;
	}


}
