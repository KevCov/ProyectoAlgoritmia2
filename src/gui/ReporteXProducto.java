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
import javax.swing.ImageIcon;
import java.awt.Color;

public class ReporteXProducto extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cbxProducto;
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
					ReporteXProducto frame = new ReporteXProducto();
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
	public ReporteXProducto() {
		setTitle("REPORTE POR PRODUCTO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("PRODUCTO");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(26, 49, 120, 25);
			contentPane.add(lblNewLabel);
		}
		{
			cbxProducto = new JComboBox();
			cbxProducto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedComboBox(e);
				}
			});
			cbxProducto.setModel(new DefaultComboBoxModel(ArregloProducto.opcionesCbx()));
			cbxProducto.setBounds(156, 52, 186, 25);
			contentPane.add(cbxProducto);
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
				modelo.addColumn("Cod Vendedor");
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
					btnCerrar.setBackground(Color.WHITE);
					btnCerrar.setIcon(new ImageIcon(ReporteXProducto.class.getResource("/imagenes/icon-exit.png")));
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
		int cod = Integer.parseInt(String.valueOf(cbxProducto.getSelectedItem()));
		int cont = 0;
		for (int i = 0; i < ArregloFactura.tamanio(); i++) {
			if (cod == ArregloFactura.obtener(i).getCodigoProducto()) {
				modelo.insertRow(cont, Producto.extraerProducto(ArregloFactura.obtener(i)));
				cont++;
			}
		}
	}

	private void cerrar() {
		this.dispose();
	}
}
