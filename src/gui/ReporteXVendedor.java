package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import clases.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ReporteXVendedor extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cbxVendedor;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteXVendedor frame = new ReporteXVendedor();
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
	public ReporteXVendedor() {
		setTitle("REPORTE POR VENDEDOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("VENDEDOR");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(26, 50, 120, 25);
			contentPane.add(lblNewLabel);
		}
		{
			cbxVendedor = new JComboBox();
			cbxVendedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedComboBox(e);
				}
			});
			cbxVendedor.setModel(new DefaultComboBoxModel(ArregloVendedor.opcionesCbx()));
			cbxVendedor.setBounds(156, 50, 186, 25);
			contentPane.add(cbxVendedor);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 105, 426, 448);
			contentPane.add(scrollPane);
			{
				textArea = new JTextArea();
				textArea.setEditable(false);
				scrollPane.setViewportView(textArea);
			}
			{
				table = new JTable();
				scrollPane.setViewportView(table);
				modelo = new DefaultTableModel();
				modelo.addColumn("Cod Factura");
				modelo.addColumn("Cod Producto");
				modelo.addColumn("Und Vendidas");
				modelo.addColumn("Precio Unitario");
				table.setModel(modelo);
				{
					btnCerrar = new JButton("");
					btnCerrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedBtnCerrar(e);
						}
					});
					btnCerrar.setIcon(new ImageIcon(ReporteXVendedor.class.getResource("/imagenes/icon-exit.png")));
					btnCerrar.setBackground(Color.WHITE);
					btnCerrar.setBounds(375, 45, 45, 40);
					contentPane.add(btnCerrar);
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(90);
				table.getColumnModel().getColumn(1).setPreferredWidth(90);
				table.getColumnModel().getColumn(2).setPreferredWidth(140);
				table.getColumnModel().getColumn(3).setPreferredWidth(140);
			}
		}
	}

	protected void actionPerformedComboBox(ActionEvent e) {
		mostrarTabla();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void mostrarTabla() {
		modelo.setRowCount(0);
		int cod = Integer.parseInt(String.valueOf(cbxVendedor.getSelectedItem()));
		int cont = 0;
		for (int i = 0; i < ArregloFactura.tamanio(); i++) {
			if (cod == ArregloFactura.obtener(i).getCodigoVendedor()) {
				modelo.insertRow(cont, Vendedor.extraerVendedor(ArregloFactura.obtener(i)));
				cont++;
			}
		}
	}

	private void cerrar() {
		this.dispose();
	}
}
