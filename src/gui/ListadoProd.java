package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import clases.*;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;

public class ListadoProd extends JFrame {

	private JPanel contentPane;
	private JTextArea txtR;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoProd frame = new ListadoProd();
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
	public ListadoProd() {
		setTitle("LISTA DE PRODUCTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 466, 350);
			contentPane.add(scrollPane);
			{
				txtR = new JTextArea();
				txtR.setFont(new Font("Monospaced", Font.PLAIN, 13));
				txtR.setEditable(false);
				scrollPane.setViewportView(txtR);
			}
			{
				table = new JTable();
				scrollPane.setViewportView(table);
				modelo = new DefaultTableModel();
				modelo.addColumn("Cod. Producto");
				modelo.addColumn("Descripcion");
				modelo.addColumn("Precio");
				table.setModel(modelo);
			}
		}
		{
			btnListar = new JButton("");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnListar(e);
				}
			});
			btnListar.setBackground(Color.WHITE);
			btnListar.setIcon(new ImageIcon(ListadoProd.class.getResource("/imagenes/icon-listar.png")));
			btnListar.setBounds(120, 370, 45, 35);
			contentPane.add(btnListar);
		}
		{
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNewButton(e);
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setIcon(new ImageIcon(ListadoProd.class.getResource("/imagenes/icon-exit.png")));
			btnNewButton.setBounds(320, 370, 45, 35);
			contentPane.add(btnNewButton);
		}
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		agregarTabla();
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void agregarTabla() {
		modelo.setRowCount(0);
		for (int i = 0; i < ArregloProducto.tamanio(); i++) {
			modelo.insertRow(i, almacenar(ArregloProducto.obtener(i)));
		}
	}

	private String[] almacenar(Producto prod) {
		String[] vector = new String[3];
		vector[0] = String.valueOf(prod.getCodPro());
		vector[1] = prod.getDescripcion();
		vector[2] = String.valueOf(prod.getPrecio());

		return vector;
	}

	private void cerrar() {
		this.dispose();
	}
}
