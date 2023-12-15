package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import arreglos.*;
import clases.*;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EliminacionVen extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtNomVen;
	private JTextField txtApeVen;
	private JTextField txtTelfVen;
	private JTextField txtDniVen;
	private JButton btnConsultar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JLabel lblCategoria;
	private JTextField txtCategoria;
	private JComboBox cbxCodVen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminacionVen frame = new EliminacionVen();
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
	public EliminacionVen() {
		setTitle("ELIMINAR VENDEDOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			txtNomVen = new JTextField();
			txtNomVen.setEditable(false);
			txtNomVen.setColumns(10);
			txtNomVen.setBounds(150, 170, 260, 25);
			contentPane.add(txtNomVen);
		}
		{
			txtApeVen = new JTextField();
			txtApeVen.setEditable(false);
			txtApeVen.setColumns(10);
			txtApeVen.setBounds(150, 230, 260, 25);
			contentPane.add(txtApeVen);
		}
		{
			txtTelfVen = new JTextField();
			txtTelfVen.setEditable(false);
			txtTelfVen.setColumns(10);
			txtTelfVen.setBounds(150, 290, 260, 25);
			contentPane.add(txtTelfVen);
		}
		{
			txtDniVen = new JTextField();
			txtDniVen.setEditable(false);
			txtDniVen.setColumns(10);
			txtDniVen.setBounds(150, 350, 260, 25);
			contentPane.add(txtDniVen);
		}
		{
			btnConsultar = new JButton("");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnConsultar(e);
				}
			});
			btnConsultar.setBackground(Color.WHITE);
			btnConsultar.setIcon(new ImageIcon(EliminacionVen.class.getResource("/imagenes/icon-buscar-cli.png")));
			btnConsultar.setBounds(200, 405, 45, 40);
			contentPane.add(btnConsultar);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setIcon(new ImageIcon(EliminacionVen.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.setBounds(300, 405, 45, 40);
			contentPane.add(btnCerrar);
		}
		{
			btnEliminar = new JButton("");
			btnEliminar.setBackground(Color.WHITE);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnEliminar(e);
				}
			});
			btnEliminar.setVisible(false);
			btnEliminar.setIcon(new ImageIcon(EliminacionVen.class.getResource("/imagenes/icon-eliminar.png")));
			btnEliminar.setBounds(100, 405, 45, 40);
			contentPane.add(btnEliminar);
		}
		{
			lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCategoria.setBounds(20, 110, 122, 25);
			contentPane.add(lblCategoria);
		}
		{
			txtCategoria = new JTextField();
			txtCategoria.setEditable(false);
			txtCategoria.setColumns(10);
			txtCategoria.setBounds(150, 110, 260, 25);
			contentPane.add(txtCategoria);
		}
		{
			cbxCodVen = new JComboBox();
			cbxCodVen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCbxCodVen(e);
				}
			});
			cbxCodVen.setModel(new DefaultComboBoxModel(ArregloVendedor.opcionesCbx()));
			cbxCodVen.setBounds(150, 53, 260, 25);
			contentPane.add(cbxCodVen);
		}
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		try {
			consultar();
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS DATOS", "FALTAN DATOS",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminar();
	}

	protected void actionPerformedCbxCodVen(ActionEvent e) {
		reestablecer();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	//METODOS PRIVADOS
	private void consultar() {
		int cod = Integer.parseInt(String.valueOf(cbxCodVen.getSelectedItem()));
		Vendedor vendedor = ArregloVendedor.obtener(ArregloVendedor.encontrar(cod));

		txtCategoria.setText("" + vendedor.getCategoria());
		txtNomVen.setText("" + vendedor.getNombres());
		txtApeVen.setText("" + vendedor.getApellidos());
		txtTelfVen.setText("" + vendedor.getTelefono());
		txtDniVen.setText("" + vendedor.getDni());

		btnEliminar.setVisible(true);
	}

	private void eliminar() {
		int cod = Integer.parseInt(String.valueOf(cbxCodVen.getSelectedItem()));
		int c = JOptionPane.showConfirmDialog(this,
				"¿Esta seguro de eliminar al Vendedor : " + cbxCodVen.getSelectedItem() + "?", "CONFIRMAR ELIMINACION",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (c == 0) {
			ArregloVendedor.eliminar(ArregloVendedor.encontrar(cod));
			cerrar();
		}
	}

	private void reestablecer() {
		txtCategoria.setText("");
		txtNomVen.setText("");
		txtApeVen.setText("");
		txtTelfVen.setText("");
		txtDniVen.setText("");

		btnEliminar.setVisible(false);
	}

	private void cerrar() {
		this.dispose();
	}
}
