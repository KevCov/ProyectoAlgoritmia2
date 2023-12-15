package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuMantenimiento;
	private JMenu menuVentas;
	private JMenu menuReportes;
	private JMenu menuSalir;
	private JMenu mnNewMenu_4;
	private JMenu mnNewMenu_5;
	private JMenu mnNewMenu_6;
	private JMenuItem menuIngreso1;
	private JMenuItem menuModificacion1;
	private JMenuItem menuConsulta1;
	private JMenuItem menuIngreso2;
	private JMenuItem menuModificacion2;
	private JMenuItem menuConsulta2;
	private JMenuItem menuIngreso3;
	private JMenuItem menuModificacion3;
	private JMenuItem menuConsulta3;
	private JMenuItem menuEliminacion1;
	private JMenuItem menuListado1;
	private JMenuItem menuEliminacion2;
	private JMenuItem menuListado2;
	private JMenuItem menuEliminacion3;
	private JMenuItem menuListado3;
	private JMenuItem menuReporteVendedor;
	private JMenuItem menuReporteProducto;
	private JMenuItem menuReportePrecio;
	private JMenuItem menuVender;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					//frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			menuBar = new JMenuBar();
			menuBar.setBorder(null);
			menuBar.setBackground(Color.WHITE);
			menuBar.setFont(new Font("Consolas", Font.PLAIN, 12));
			menuBar.setBounds(0, 0, 1101, 22);
			contentPane.add(menuBar);
			{
				menuMantenimiento = new JMenu("Mantenimiento");
				menuBar.add(menuMantenimiento);
				{
					mnNewMenu_4 = new JMenu("Vendedores");
					menuMantenimiento.add(mnNewMenu_4);
					{
						menuIngreso1 = new JMenuItem("Ingreso");
						menuIngreso1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuIngreso1(e);
							}
						});
						mnNewMenu_4.add(menuIngreso1);
					}
					{
						menuModificacion1 = new JMenuItem("Modificacion");
						menuModificacion1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuModificacion1(e);
							}
						});
						mnNewMenu_4.add(menuModificacion1);
					}
					{
						menuConsulta1 = new JMenuItem("Consulta");
						menuConsulta1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuConsulta1(e);
							}
						});
						mnNewMenu_4.add(menuConsulta1);
					}
					{
						menuEliminacion1 = new JMenuItem("Eliminacion");
						menuEliminacion1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuEliminacion1(e);
							}
						});
						mnNewMenu_4.add(menuEliminacion1);
					}
					{
						menuListado1 = new JMenuItem("Listado");
						menuListado1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuListado1(e);
							}
						});
						mnNewMenu_4.add(menuListado1);
					}
				}
				{
					mnNewMenu_5 = new JMenu("Clientes");
					menuMantenimiento.add(mnNewMenu_5);
					{
						menuIngreso2 = new JMenuItem("Ingreso");
						menuIngreso2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuIngreso2(e);
							}
						});
						mnNewMenu_5.add(menuIngreso2);
					}
					{
						menuModificacion2 = new JMenuItem("Modificacion");
						menuModificacion2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuModificacion2(e);
							}
						});
						mnNewMenu_5.add(menuModificacion2);
					}
					{
						menuConsulta2 = new JMenuItem("Consulta");
						menuConsulta2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuConsulta2(e);
							}
						});
						mnNewMenu_5.add(menuConsulta2);
					}
					{
						menuEliminacion2 = new JMenuItem("Eliminacion");
						menuEliminacion2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuEliminacion2(e);
							}
						});
						mnNewMenu_5.add(menuEliminacion2);
					}
					{
						menuListado2 = new JMenuItem("Listado");
						menuListado2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuListado2(e);
							}
						});
						mnNewMenu_5.add(menuListado2);
					}
				}
				{
					mnNewMenu_6 = new JMenu("Productos");
					menuMantenimiento.add(mnNewMenu_6);
					{
						menuIngreso3 = new JMenuItem("Ingreso");
						menuIngreso3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuIngreso3(e);
							}
						});
						mnNewMenu_6.add(menuIngreso3);
					}
					{
						menuModificacion3 = new JMenuItem("Modificacion");
						menuModificacion3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuModificacion3(e);
							}
						});
						mnNewMenu_6.add(menuModificacion3);
					}
					{
						menuConsulta3 = new JMenuItem("Consulta");
						menuConsulta3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuConsulta3(e);
							}
						});
						mnNewMenu_6.add(menuConsulta3);
					}
					{
						menuEliminacion3 = new JMenuItem("Eliminacion");
						menuEliminacion3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuEliminacion3(e);
							}
						});
						mnNewMenu_6.add(menuEliminacion3);
					}
					{
						menuListado3 = new JMenuItem("Listado");
						menuListado3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMenuListado3(e);
							}
						});
						mnNewMenu_6.add(menuListado3);
					}
				}
			}
			{
				menuVentas = new JMenu("Ventas");
				menuBar.add(menuVentas);
				{
					menuVender = new JMenuItem("Vender");
					menuVender.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMenuVender(e);
						}
					});
					menuVentas.add(menuVender);
				}
			}
			{
				menuReportes = new JMenu("Reportes");
				menuBar.add(menuReportes);
				{
					menuReporteVendedor = new JMenuItem("Reporte General");
					menuReporteVendedor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMenuReporteVendedor(e);
						}
					});
					menuReportes.add(menuReporteVendedor);
				}
				{
					menuReporteProducto = new JMenuItem("Reporte por vendedor");
					menuReporteProducto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMenuReporteProducto(e);
						}
					});
					menuReportes.add(menuReporteProducto);
				}
				{
					menuReportePrecio = new JMenuItem("Reporte por producto");
					menuReportePrecio.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMenuReportePrecio(e);
						}
					});
					menuReportes.add(menuReportePrecio);
				}
				{
					mntmNewMenuItem = new JMenuItem("Reporte de precios");
					mntmNewMenuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMntmNewMenuItem(e);
						}
					});
					menuReportes.add(mntmNewMenuItem);
				}
			}
			{
				menuSalir = new JMenu("Salir");
				menuBar.add(menuSalir);
				{
					mntmNewMenuItem_1 = new JMenuItem("Cerrar");
					mntmNewMenuItem_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMntmNewMenuItem_1(e);
						}
					});
					menuSalir.add(mntmNewMenuItem_1);
				}
			}
		}
	}
	public void iniciar(JFrame jf) {
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
	protected void actionPerformedMenuIngreso2(ActionEvent e) {
		IngresoCli ingreso1 = new IngresoCli();
		iniciar(ingreso1);
	}
	protected void actionPerformedMenuConsulta2(ActionEvent e) {
		ConsultaCli consultar = new ConsultaCli();
		iniciar(consultar);
	}
	protected void actionPerformedMenuModificacion2(ActionEvent e) {
		ModificacionCli modf = new ModificacionCli();
		iniciar(modf);
	}
	protected void actionPerformedMenuEliminacion2(ActionEvent e) {
		EliminacionCli elimina = new EliminacionCli();
		iniciar(elimina);
	}
	protected void actionPerformedMenuListado2(ActionEvent e) {
		ListadoCli list = new ListadoCli();
		iniciar(list);
	}
	protected void actionPerformedMenuConsulta1(ActionEvent e) {
		ConsultaVen consultarVen = new ConsultaVen();
		iniciar(consultarVen);
	}
	protected void actionPerformedMenuIngreso1(ActionEvent e) {
		IngresoVen ingresoVen = new IngresoVen();
		iniciar(ingresoVen);
	}
	protected void actionPerformedMenuModificacion1(ActionEvent e) {
		ModificacionVen modfVen = new ModificacionVen();
		iniciar(modfVen);
	}
	protected void actionPerformedMenuEliminacion1(ActionEvent e) {
		EliminacionVen eliminaVen = new EliminacionVen();
		iniciar(eliminaVen);
	}
	protected void actionPerformedMenuListado1(ActionEvent e) {
		ListadoVen listVen = new ListadoVen();
		iniciar(listVen);
	}
	protected void actionPerformedMenuIngreso3(ActionEvent e) {
		IngresoProd ingresoProd = new IngresoProd();
		iniciar(ingresoProd);
	}
	protected void actionPerformedMenuConsulta3(ActionEvent e) {
		ConsultaProd consultarProd = new ConsultaProd();
		iniciar(consultarProd);
	}
	protected void actionPerformedMenuModificacion3(ActionEvent e) {
		ModificacionProd modProd = new ModificacionProd();
		iniciar(modProd);
	}
	protected void actionPerformedMenuEliminacion3(ActionEvent e) {
		EliminacionProd eliminaProd = new EliminacionProd();
		iniciar(eliminaProd);
	}
	protected void actionPerformedMenuListado3(ActionEvent e) {
		ListadoProd listProd = new ListadoProd();
		iniciar(listProd);
	}
	protected void actionPerformedMenuVender(ActionEvent e) {
		Venta vt = new Venta();
		iniciar(vt);
	}
	protected void actionPerformedMenuReporteVendedor(ActionEvent e) {
		ReporteGeneral rg = new ReporteGeneral();
		iniciar(rg);
	}
	protected void actionPerformedMenuReporteProducto(ActionEvent e) {
		ReporteXVendedor rv = new ReporteXVendedor();
		iniciar(rv);
	}
	protected void actionPerformedMenuReportePrecio(ActionEvent e) {
		ReporteXProducto rp = new ReporteXProducto();
		iniciar(rp);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		ReportePrecios rpr = new ReportePrecios();
		iniciar(rpr);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		System.exit(0);
	}
}
