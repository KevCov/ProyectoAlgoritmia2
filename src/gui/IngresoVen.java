package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.*;
import clases.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Color;

public class IngresoVen extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtCodVen;
	private JTextField txtNomVen;
	private JTextField txtApeVen;
	private JTextField txtTelfVen;
	private JTextField txtDniVen;
	private JButton btnIngresar;
	private JButton btnCerrar;
	private JLabel lblCategoria;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoVen frame = new IngresoVen();
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
	public IngresoVen() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				windowOpenedThis(e);
			}
		});
		setTitle("INGRESO DE VENDEDORES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Código Vendedor");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(20, 50, 122, 25);
			contentPane.add(lblNewLabel);
		}
		{
			lblNombres = new JLabel("Nombres");
			lblNombres.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNombres.setBounds(20, 170, 122, 25);
			contentPane.add(lblNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblApellidos.setBounds(20, 230, 122, 25);
			contentPane.add(lblApellidos);
		}
		{
			lblTelefono = new JLabel("Telefono");
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTelefono.setBounds(20, 290, 122, 25);
			contentPane.add(lblTelefono);
		}
		{
			lblDni = new JLabel("DNI");
			lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDni.setBounds(20, 350, 122, 25);
			contentPane.add(lblDni);
		}
		{
			txtCodVen = new JTextField();
			txtCodVen.setEditable(false);
			txtCodVen.setBounds(150, 50, 260, 25);
			contentPane.add(txtCodVen);
			txtCodVen.setColumns(10);
		}
		{
			txtNomVen = new JTextField();
			txtNomVen.setColumns(10);
			txtNomVen.setBounds(150, 170, 260, 25);
			contentPane.add(txtNomVen);
		}
		{
			txtApeVen = new JTextField();
			txtApeVen.setColumns(10);
			txtApeVen.setBounds(150, 230, 260, 25);
			contentPane.add(txtApeVen);
		}
		{
			txtTelfVen = new JTextField();
			txtTelfVen.setColumns(10);
			txtTelfVen.setBounds(150, 290, 260, 25);
			contentPane.add(txtTelfVen);
		}
		{
			txtDniVen = new JTextField();
			txtDniVen.setColumns(10);
			txtDniVen.setBounds(150, 350, 260, 25);
			contentPane.add(txtDniVen);
		}
		{
			btnIngresar = new JButton("");
			btnIngresar.setBackground(Color.WHITE);
			btnIngresar.setIcon(new ImageIcon(IngresoVen.class.getResource("/imagenes/icon-ingresar.png")));
			btnIngresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnIngresar(e);
				}
			});
			btnIngresar.setBounds(100, 405, 45, 40);
			contentPane.add(btnIngresar);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setIcon(new ImageIcon(IngresoVen.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBounds(300, 405, 45, 40);
			contentPane.add(btnCerrar);
		}
		{
			lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCategoria.setBounds(20, 110, 122, 25);
			contentPane.add(lblCategoria);
		}
		{
			txtCategoria = new JTextField();
			txtCategoria.setColumns(10);
			txtCategoria.setBounds(150, 110, 260, 25);
			contentPane.add(txtCategoria);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		if (txtCategoria.getText().equals("") || txtNomVen.getText().equals("") || txtApeVen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CATEGORIA, NOMBRE Y APELLIDO SON OBLIGATORIOS", "FALTAN DATOS",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			try {
				agregar();
			} catch (NumberFormatException e2) { // java.lang.NumberFormatException
				JOptionPane.showMessageDialog(this, "LA CATEGORIA DEL VENDEDOR ES NUMERICO", "ERROR TIPO DE DATO",
						JOptionPane.INFORMATION_MESSAGE);
				txtCategoria.setText("");
				txtCategoria.requestFocus();
			}
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		txtCodVen.setText("" + Vendedor.getCodigoVendedor());
		txtCategoria.requestFocus();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}
	
	// METODOS PRIVADOS
	private void agregar() {
		ArregloVendedor.agregar(new Vendedor(Integer.parseInt(txtCategoria.getText()), txtNomVen.getText(),
				txtApeVen.getText(), txtTelfVen.getText(), txtDniVen.getText()));
		cerrar();
	}

	private void cerrar() {
		this.dispose();
	}
}
