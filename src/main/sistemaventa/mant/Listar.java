package main.sistemaventa.mant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.sistemaventa.FrmMenu;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Listar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	JTextArea txaResultado = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Listar dialog = new Listar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Listar() {
		setTitle("Listado de Discos Duros");
		setBounds(100, 100, 525, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scpResultado = new JScrollPane();
		scpResultado.setBounds(10, 11, 489, 248);
		contentPanel.add(scpResultado);
		scpResultado.setViewportView(txaResultado);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(137, 270, 111, 23);
		contentPanel.add(btnCerrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\listar.png"));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnListar.setBounds(269, 270, 111, 23);
		contentPanel.add(btnListar);
		btnListar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BOTON: " + e.getActionCommand());
		if (e.getActionCommand() == "Listar") {
			listarDatos();
		}
		
	}
	
	void listarDatos() {
		txaResultado.setText("");
		txaResultado.append("LISTADO DE DISCOS DUROS\n");
		txaResultado.append("\n");
		txaResultado.append("Modelo            :  "+ FrmMenu.modelo0+ "\n");
		txaResultado.append("Precio              :  S/ "+ FrmMenu.precio0+ "\n");
		txaResultado.append("Profundidad   :  "+ FrmMenu.fondo0+  " cm\n");	
		txaResultado.append("Ancho              :  "+ FrmMenu.ancho0+ " cm\n");	
		txaResultado.append("Alto                   :  "+ FrmMenu.alto0+ " cm\n");	
		txaResultado.append("Capacidad     :  "+ FrmMenu.capacidad0+ " kg\n");	
		
		txaResultado.append("\n");
		txaResultado.append("Modelo            :  "+ FrmMenu.modelo1+ "\n");
		txaResultado.append("Precio              :  S/ "+ FrmMenu.precio1+ "\n");
		txaResultado.append("Profundidad   :   "+ FrmMenu.fondo1+  " cm\n");	
		txaResultado.append("Ancho              :   "+ FrmMenu.ancho1+ " cm\n");	
		txaResultado.append("Alto                   :   "+ FrmMenu.alto1+ " cm\n");	
		txaResultado.append("Capacidad     :   "+ FrmMenu.capacidad1+ " kg\n");	
		
		txaResultado.append("\n");
		txaResultado.append("Modelo            :   "+ FrmMenu.modelo2+ "\n");
		txaResultado.append("Precio              :  S/ "+ FrmMenu.precio2+ "\n");
		txaResultado.append("Profundidad   :   "+ FrmMenu.fondo2+  " cm\n");	
		txaResultado.append("Ancho              :   "+ FrmMenu.ancho2+ " cm\n");	
		txaResultado.append("Alto                   :   "+ FrmMenu.alto2+ " cm\n");	
		txaResultado.append("Capacidad     :   "+ FrmMenu.capacidad2+ " kg\n");	
		
		txaResultado.append( "\n");
		txaResultado.append("Modelo            :   "+ FrmMenu.modelo3+ "\n");
		txaResultado.append("Precio              :  S/ "+ FrmMenu.precio3+ "\n");
		txaResultado.append("Profundidad   :   "+ FrmMenu.fondo3+  " cm\n");	
		txaResultado.append("Ancho              :   "+ FrmMenu.ancho3+ " cm\n");	
		txaResultado.append("Alto                   :   "+ FrmMenu.alto3+ " cm\n");	
		txaResultado.append("Capacidad     :   "+ FrmMenu.capacidad3+ " kg\n");	
		
		txaResultado.append("\n");
		txaResultado.append("Modelo            :   "+ FrmMenu.modelo4+ "\n");
		txaResultado.append("Precio              :  S/ "+ FrmMenu.precio4+ "\n");
		txaResultado.append("Profundidad   :   "+ FrmMenu.fondo4+  " cm\n");	
		txaResultado.append("Ancho              :   "+ FrmMenu.ancho4+ " cm\n");	
		txaResultado.append("Alto                   :   "+ FrmMenu.alto4+ " cm\n");	
		txaResultado.append("Capacidad     :   "+ FrmMenu.capacidad4+ " kg\n");	
		
	}
	
	
}
