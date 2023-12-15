package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.*;
import clases.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IngresoProd extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtCodProd;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JButton btnIngreso;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoProd frame = new IngresoProd();
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
	public IngresoProd() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				windowOpenedThis(e);
			}
		});
		setTitle("INGRESO PRODUCTO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Codigo Producto");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(20, 50, 122, 25);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Descripción");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1.setBounds(20, 110, 122, 25);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Precio");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_2.setBounds(20, 170, 122, 25);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtCodProd = new JTextField();
			txtCodProd.setEditable(false);
			txtCodProd.setBounds(150, 50, 260, 25);
			contentPane.add(txtCodProd);
			txtCodProd.setColumns(10);
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(150, 110, 260, 25);
			contentPane.add(txtDescripcion);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(150, 170, 260, 25);
			contentPane.add(txtPrecio);
		}
		{
			btnIngreso = new JButton("");
			btnIngreso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnIngreso(e);
				}
			});
			btnIngreso.setIcon(new ImageIcon(IngresoProd.class.getResource("/imagenes/icon-ingresar.png")));
			btnIngreso.setBackground(Color.WHITE);
			btnIngreso.setBounds(100, 235, 45, 40);
			contentPane.add(btnIngreso);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setIcon(new ImageIcon(IngresoProd.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.setBounds(300, 235, 45, 40);
			contentPane.add(btnCerrar);
		}
	}

	protected void actionPerformedBtnIngreso(ActionEvent e) {
		if (txtDescripcion.getText().equals("") || txtPrecio.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "DESCRIPCION Y PRECIO SON OBLIGATORIOS", "FALTAN DATOS",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				agregar();
			} catch (NumberFormatException e2) { // java.lang.NumberFormatException
				JOptionPane.showMessageDialog(this, "EL PRECIO ES NUMERICO", "ERROR TIPO DE DATO",
						JOptionPane.INFORMATION_MESSAGE);
				txtPrecio.setText("");
			}
		}

	}

	protected void windowOpenedThis(WindowEvent e) {
		txtCodProd.setText("" + Producto.getCodigoProducto());
		txtDescripcion.requestFocus();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void agregar() {
		ArregloProducto.agregar(new Producto(txtDescripcion.getText(), Double.parseDouble(txtPrecio.getText())));
		cerrar();
	}

	private void cerrar() {
		this.dispose();
	}
}
