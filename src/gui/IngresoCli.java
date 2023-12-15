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

public class IngresoCli extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtCodCli;
	private JTextField txtNomCli;
	private JTextField txtApeCli;
	private JTextField txtTelfCli;
	private JTextField txtDniCli;
	private JButton btnIngresar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoCli frame = new IngresoCli();
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
	public IngresoCli() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				windowOpenedThis(e);
			}
		});
		setTitle("INGRESO DE CLIENTES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Código Cliente");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(20, 50, 122, 25);
			contentPane.add(lblNewLabel);
		}
		{
			lblNombres = new JLabel("Nombres");
			lblNombres.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNombres.setBounds(20, 110, 122, 25);
			contentPane.add(lblNombres);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblApellidos.setBounds(20, 170, 122, 25);
			contentPane.add(lblApellidos);
		}
		{
			lblTelefono = new JLabel("Telefono");
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTelefono.setBounds(20, 230, 122, 25);
			contentPane.add(lblTelefono);
		}
		{
			lblDni = new JLabel("DNI");
			lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDni.setBounds(20, 290, 122, 25);
			contentPane.add(lblDni);
		}
		{
			txtCodCli = new JTextField();
			txtCodCli.setEditable(false);
			txtCodCli.setBounds(150, 50, 260, 25);
			contentPane.add(txtCodCli);
			txtCodCli.setColumns(10);
		}
		{
			txtNomCli = new JTextField();
			txtNomCli.setColumns(10);
			txtNomCli.setBounds(150, 110, 260, 25);
			contentPane.add(txtNomCli);
		}
		{
			txtApeCli = new JTextField();
			txtApeCli.setColumns(10);
			txtApeCli.setBounds(150, 170, 260, 25);
			contentPane.add(txtApeCli);
		}
		{
			txtTelfCli = new JTextField();
			txtTelfCli.setColumns(10);
			txtTelfCli.setBounds(150, 230, 260, 25);
			contentPane.add(txtTelfCli);
		}
		{
			txtDniCli = new JTextField();
			txtDniCli.setColumns(10);
			txtDniCli.setBounds(150, 290, 260, 25);
			contentPane.add(txtDniCli);
		}
		{
			btnIngresar = new JButton("");
			btnIngresar.setBackground(Color.WHITE);
			btnIngresar.setIcon(new ImageIcon(IngresoCli.class.getResource("/imagenes/icon-ingresar.png")));
			btnIngresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnIngresar(e);
				}
			});
			btnIngresar.setBounds(100, 345, 45, 40);
			contentPane.add(btnIngresar);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setIcon(new ImageIcon(IngresoCli.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBounds(300, 345, 45, 40);
			contentPane.add(btnCerrar);
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		if (txtNomCli.getText().equals("") || txtApeCli.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "NOMBRE Y APELLIDO SON OBLIGATORIOS", "FALTAN DATOS",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			agregar();
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		txtCodCli.setText("" + Cliente.getCodigoCliente());
		txtNomCli.requestFocus();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void agregar() {
		ArregloCliente.agregar(
				new Cliente(txtNomCli.getText(), txtApeCli.getText(), txtTelfCli.getText(), txtDniCli.getText()));
		cerrar();
	}

	private void cerrar() {
		this.dispose();
	}
}
