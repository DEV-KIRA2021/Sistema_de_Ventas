package main.sistemaventa;

import java.awt.EventQueue;
import javax.swing.JFrame;
import main.sistemaventa.config.Cantidad;
import main.sistemaventa.config.Cuota;
import main.sistemaventa.config.Descuentos;
import main.sistemaventa.config.Obsequios;
import main.sistemaventa.mant.Consulta;
import main.sistemaventa.mant.Listar;
import main.sistemaventa.mant.Modificar;
import main.sistemaventa.venta.Reportes;
import main.sistemaventa.venta.Vender;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class FrmMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JMenuBar menuBar = new JMenuBar();

	private JMenu archivo;
	private JMenu mantenimiento;
	private JMenu ventas;
	private JMenu config;
	private JMenu ayuda;

	private JMenuItem itemArchivoCerrar;

	private JMenuItem itemMantModificar;
	private JMenuItem itemMantConsultar;
	private JMenuItem itemMantListar;

	private JMenuItem itemVenta;
	private JMenuItem itemReporte;

	private JMenuItem itemConfigDesct;
	private JMenuItem itemConfigObseq;
	private JMenuItem itemConfigCant;
	private JMenuItem itemConfigCuota;

	private JMenuItem itemAyudaInfo;

	public static String modelo0 = "Western Digital My Cloud Home 6TB";
	public static double precio0 = 1499.0;
	public static double fondo0 = 14.0;
	public static double ancho0 = 5.3;
	public static double alto0 = 17.5;
	public static double capacidad0 = 6;

	public static String modelo1 = "Western Digital Elements 4TB";
	public static double precio1 = 555.0;
	public static double ancho1 = 11.5;
	public static double alto1 = 8.2;
	public static double fondo1 = 2.1;
	public static double capacidad1 = 4;

	public static String modelo2 = "Toshiba Canvio Basics 4TB";
	public static double precio2 = 499.0;
	public static double ancho2 = 14.1;
	public static double alto2 = 11.1;
	public static double fondo2 = 3.8;
	public static double capacidad2 = 4;

	public static String modelo3 = "Seagate Expansion 4TB";
	public static double precio3 = 619.0;
	public static double ancho3 = 11.7;
	public static double alto3 = 8.0;
	public static double fondo3 = 2.1;
	public static double capacidad3 = 4;

	public static String modelo4 = "Seagate Backup Plus Hub 10TB";
	public static double precio4 = 1099.0;
	public static double ancho4 = 19.8;
	public static double alto4 = 11.8;
	public static double fondo4 = 4.1;
	public static double capacidad4 = 10;
	
	// Porcentajes de descuento
	public static double pct1_5 = 7.5;
	public static double pct6_10 = 10.0;
	public static double pct11_15 = 12.5;
	public static double pct15 = 15.0;
	
	// Obsequios
	public static String producto = "Lapicero";
	public static int cantidad1 = 2;
	public static int cantidad2 = 3;
	public static int cantidad3 = 4;
	
	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;
	
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	
	public static int avanceVentas = 0;
	public static double importeGeneralAcumulado = 0.0;

	

	// cantidades por modelo 
	public static int cantModelo0;
	public static int cantModelo1;
	public static int cantModelo2;
	public static int cantModelo3;
	public static int cantModelo4;
	
	public static int cantVentasModelo0;
	public static int cantVentasModelo1;
	public static int cantVentasModelo2;
	public static int cantVentasModelo3;
	public static int cantVentasModelo4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMenu() {
		getContentPane().setBackground(Color.CYAN);
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 300);
		setLocationRelativeTo(null);
		menuBar.setBackground(Color.LIGHT_GRAY);

		setJMenuBar(menuBar);
		archivo = new JMenu("Archivo");
		archivo.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		archivo.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\archivo.png"));
		mantenimiento = new JMenu("Mantenimiento");
		mantenimiento.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		mantenimiento.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\mantenimiento.png"));
		ventas = new JMenu("Ventas");
		ventas.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		ventas.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\ventas.png"));
		config = new JMenu("Configuración");
		config.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		config.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\configuracion.png"));
		ayuda = new JMenu("Ayuda");
		ayuda.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 16));
		ayuda.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\ayuda.png"));

		itemArchivoCerrar = new JMenuItem("Cerrar");
		itemArchivoCerrar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\salir.png"));

		itemMantConsultar = new JMenuItem("Consultar disco duro");
		itemMantConsultar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\search.png"));
		itemMantModificar = new JMenuItem("Modificar disco duro");
		itemMantModificar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\modificar.png"));
		itemMantListar = new JMenuItem("Listar discos duros");
		itemMantListar.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\listar.png"));

		itemVenta = new JMenuItem("Vender");
		itemVenta.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\venta.png"));
		itemReporte = new JMenuItem("Generar reportes");
		itemReporte.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\reportes.png"));

		itemConfigDesct = new JMenuItem("Configurar descuentos");
		itemConfigDesct.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\descuento.png"));
		itemConfigObseq = new JMenuItem("Configurar obsequios");
		itemConfigObseq.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\obsequio.png"));
		itemConfigCant = new JMenuItem("Configurar cantidad óptima");
		itemConfigCant.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\cantidad.png"));
		itemConfigCuota = new JMenuItem("Configurar cuota diaria");
		itemConfigCuota.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\cuota.png"));

		itemAyudaInfo = new JMenuItem("Acerca de Tienda");
		itemAyudaInfo.setIcon(new ImageIcon("E:\\ALGORITMIA\\PROYECTO\\proyecto\\src\\icons\\acercaTienda.png"));

		archivo.add(itemArchivoCerrar);

		mantenimiento.add(itemMantConsultar);
		mantenimiento.add(itemMantModificar);
		mantenimiento.add(itemMantListar);

		ventas.add(itemVenta);
		ventas.add(itemReporte);

		config.add(itemConfigDesct);
		config.add(itemConfigObseq);
		config.add(itemConfigCant);
		config.add(itemConfigCuota);

		ayuda.add(itemAyudaInfo);

		menuBar.add(archivo);
		menuBar.add(mantenimiento);
		menuBar.add(ventas);
		menuBar.add(config);
		menuBar.add(ayuda);

		itemArchivoCerrar.addActionListener(this);
		itemMantConsultar.addActionListener(this);
		itemMantModificar.addActionListener(this);
		itemMantListar.addActionListener(this);
		itemVenta.addActionListener(this);
		itemReporte.addActionListener(this);
		itemConfigDesct.addActionListener(this);
		itemConfigObseq.addActionListener(this);
		itemConfigCant.addActionListener(this);
		itemConfigCuota.addActionListener(this);
		itemAyudaInfo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Cerrar")) {
			int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro que desea cerrar el sistema", "Salir",
					JOptionPane.YES_NO_OPTION);
			if (opcion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

		}
		if (e.getActionCommand().equals("Consultar disco duro")) {
			Consulta consultaDisco = new Consulta();
			consultaDisco.setVisible(true);

		}

		if (e.getActionCommand().equals("Modificar disco duro")) {
			Modificar modificarDisco = new Modificar();
			modificarDisco.setVisible(true);

		}

		if (e.getActionCommand().equals("Listar discos duros")) {
			Listar listarDisco = new Listar();
			listarDisco.setVisible(true);
		}

		if (e.getActionCommand().equals("Vender")) {
			Vender venderDisco = new Vender();
			venderDisco.setVisible(true);
		}

		if (e.getActionCommand().equals("Generar reportes")) {
			Reportes generarReportes = new Reportes();
			generarReportes.setVisible(true);
		}

		if (e.getActionCommand().equals("Configurar descuentos")) {
			Descuentos Dsct = new Descuentos();
			Dsct.setVisible(true);
		}

		if (e.getActionCommand().equals("Configurar obsequios")) {
			Obsequios Obs = new Obsequios();
			Obs.setVisible(true);
		}

		if (e.getActionCommand().equals("Configurar cantidad óptima")) {
			Cantidad Cant = new Cantidad();
			Cant.setVisible(true);
		}

		if (e.getActionCommand().equals("Configurar cuota diaria")) {
			Cuota Cuot = new Cuota();
			Cuot.setVisible(true);
		}

		if (e.getActionCommand().equals("Acerca de Tienda")) {
			AcercadeTienda tienda = new AcercadeTienda();
			tienda.setVisible(true);
		}

	}

	public static String getNombreModelo(int modelo) {

		switch (modelo) {
		case 0:
			return FrmMenu.modelo0;
		case 1:
			return FrmMenu.modelo1;
		case 2:
			return FrmMenu.modelo2;
		case 3:
			return FrmMenu.modelo3;
		default:
			return FrmMenu.modelo4;
		}
	}

	public static double getPrecio(int modelo) {

		switch (modelo) {
		case 0:
			return FrmMenu.precio0;
		case 1:
			return FrmMenu.precio1;
		case 2:
			return FrmMenu.precio2;
		case 3:
			return FrmMenu.precio3;
		default:
			return FrmMenu.precio4;
		}
	}

	public static double getAncho(int modelo) {
		switch (modelo) {
		case 0:
			return FrmMenu.ancho0;
		case 1:
			return FrmMenu.ancho1;
		case 2:
			return FrmMenu.ancho2;
		case 3:
			return FrmMenu.ancho3;
		default:
			return FrmMenu.ancho4;
		}
	}

	public static double getAlto(int modelo) {
		switch (modelo) {
		case 0:
			return FrmMenu.alto0;
		case 1:
			return FrmMenu.alto1;
		case 2:
			return FrmMenu.alto2;
		case 3:
			return FrmMenu.alto3;
		default:
			return FrmMenu.alto4;
		}
	}

	public static double getFondo(int modelo) {
		switch (modelo) {
		case 0:
			return FrmMenu.fondo0;
		case 1:
			return FrmMenu.fondo1;
		case 2:
			return FrmMenu.fondo2;
		case 3:
			return FrmMenu.fondo3;
		default:
			return FrmMenu.fondo4;
		}
	}

	public static double getCapacidad(int modelo) {
		switch (modelo) {
		case 0:
			return FrmMenu.capacidad0;
		case 1:
			return FrmMenu.capacidad1;
		case 2:
			return FrmMenu.capacidad2;
		case 3:
			return FrmMenu.capacidad3;
		default:
			return FrmMenu.capacidad4;
		}
	}
	
	public static int getCantVentasXModelo(int modelo) {
		switch (modelo) {
		case 0:
			return FrmMenu.cantModelo0;
		case 1:
			return FrmMenu.cantModelo1;
		case 2:
			return FrmMenu.cantModelo2;
		case 3:
			return FrmMenu.cantModelo3;
		default:
			return FrmMenu.cantModelo4;
		}
	}
	
	public static int getUndVentasXModelo(int modelo) {
		switch (modelo) {
		case 0:
			return FrmMenu.cantVentasModelo0;
		case 1:
			return FrmMenu.cantVentasModelo1;
		case 2:
			return FrmMenu.cantVentasModelo2;
		case 3:
			return FrmMenu.cantVentasModelo3;
		default:
			return FrmMenu.cantVentasModelo4;
		}
	}
	
	
	public static List<String> getModelos(){
		return Arrays.asList("Seleccione Producto", modelo0, modelo1, modelo2,modelo3,modelo4);
	}
	

}
