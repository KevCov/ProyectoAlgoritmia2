package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import clases.*;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ReporteGeneral extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cbxReporte;

	private DefaultTableModel modelo;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteGeneral frame = new ReporteGeneral();
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
	public ReporteGeneral() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("REPORTE POR : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(27, 41, 120, 25);
			contentPane.add(lblNewLabel);
		}
		{
			cbxReporte = new JComboBox();
			cbxReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedComboBox(e);
				}
			});
			cbxReporte.setModel(new DefaultComboBoxModel(new String[] { "PRODUCTOS", "VENDEDORES" }));
			cbxReporte.setBounds(216, 42, 148, 25);
			contentPane.add(cbxReporte);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 104, 520, 361);
			contentPane.add(scrollPane);
			{
				textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
			{
				table = new JTable();
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scrollPane.setViewportView(table);
				modelo = new DefaultTableModel();
				modelo.addColumn("Codigo");
				modelo.addColumn("Nro Ventas");
				modelo.addColumn("Und Vendidas Acumuladas");
				modelo.addColumn("Importe Total Acumulado");
				table.setModel(modelo);
				{
					btnCerrar = new JButton("");
					btnCerrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedBtnCerrar(e);
						}
					});
					btnCerrar.setIcon(new ImageIcon(ReporteGeneral.class.getResource("/imagenes/icon-exit.png")));
					btnCerrar.setBackground(Color.WHITE);
					btnCerrar.setBounds(435, 35, 45, 40);
					contentPane.add(btnCerrar);
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(90);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(168);
				table.getColumnModel().getColumn(3).setPreferredWidth(169);
			}
		}
	}

	protected void actionPerformedComboBox(ActionEvent e) {
		mostrarReporte();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void mostrarReporte() {
		int cbx = cbxReporte.getSelectedIndex();
		switch (cbx) {
		case 0:
			modelo.setRowCount(0);
			for (int i = 0; i < ArregloProducto.tamanio(); i++) {
				modelo.insertRow(i, almacenar(ArregloProducto.obtener(i)));
			}
			break;
		case 1:
			modelo.setRowCount(0);
			for (int i = 0; i < ArregloVendedor.tamanio(); i++) {
				modelo.insertRow(i, almacenar(ArregloVendedor.obtener(i)));
			}
			break;
		}
	}

	private Double[] almacenar(Producto pro) {
		Double[] vector = new Double[4];
		vector[0] = (double) pro.getCodPro();
		vector[1] = (double) ArregloFactura.ventasEfectuadasXPro(pro);
		vector[2] = (double) ArregloFactura.unidadesVendidasXPro(pro);
		vector[3] = ArregloFactura.totalAcumuladoXPro(pro);
		return vector;
	}

	private Double[] almacenar(Vendedor vend) {
		Double[] vector = new Double[4];
		vector[0] = (double) vend.getCodVen();
		vector[1] = (double) ArregloFactura.ventasEfectuadasXVen(vend);
		vector[2] = (double) ArregloFactura.unidadesVendidasXVen(vend);
		vector[3] = ArregloFactura.totalAcumuladoXVen(vend);
		return vector;
	}

	private void cerrar() {
		this.dispose();
	}
}
