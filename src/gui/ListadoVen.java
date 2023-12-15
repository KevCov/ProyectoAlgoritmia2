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

public class ListadoVen extends JFrame {

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
					ListadoVen frame = new ListadoVen();
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
	public ListadoVen() {
		setTitle("LISTA DE VENDEDORES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 516, 350);
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
				modelo.addColumn("Cod. Vendedor");
				modelo.addColumn("Categoria");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido");
				modelo.addColumn("Telefono");
				modelo.addColumn("DNI");
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
			btnListar.setIcon(new ImageIcon(ListadoVen.class.getResource("/imagenes/icon-listar.png")));
			btnListar.setBounds(140, 370, 45, 35);
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
			btnNewButton.setIcon(new ImageIcon(ListadoVen.class.getResource("/imagenes/icon-exit.png")));
			btnNewButton.setBounds(340, 370, 45, 35);
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
		for (int i = 0; i < ArregloVendedor.tamanio(); i++) {
			modelo.insertRow(i, almacenar(ArregloVendedor.obtener(i)));
		}
	}

	private String[] almacenar(Vendedor vend) {
		String[] vector = new String[6];
		vector[0] = String.valueOf(vend.getCodVen());
		vector[1] = String.valueOf(vend.getCategoria());
		vector[2] = vend.getNombres();
		vector[3] = vend.getApellidos();
		vector[4] = vend.getTelefono();
		vector[5] = vend.getDni();
		return vector;
	}

	private void cerrar() {
		this.dispose();
	}
}
