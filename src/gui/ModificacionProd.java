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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ModificacionProd extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JButton btnConsultar;
	private JButton btnCerrar;
	private JButton btnModificar;
	private JComboBox cbxCodPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificacionProd frame = new ModificacionProd();
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
	public ModificacionProd() {
		setTitle("MODIFICAR PRODUCTO");
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
			txtDescripcion = new JTextField();
			txtDescripcion.setEditable(false);
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(150, 110, 260, 25);
			contentPane.add(txtDescripcion);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(150, 170, 260, 25);
			contentPane.add(txtPrecio);
		}
		{
			btnConsultar = new JButton("");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnConsultar(e);
				}
			});
			btnConsultar.setIcon(new ImageIcon(ModificacionProd.class.getResource("/imagenes/icon-buscar-cli.png")));
			btnConsultar.setBackground(Color.WHITE);
			btnConsultar.setBounds(200, 235, 45, 40);
			contentPane.add(btnConsultar);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setIcon(new ImageIcon(ModificacionProd.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.setBounds(300, 235, 45, 40);
			contentPane.add(btnCerrar);
		}
		{
			btnModificar = new JButton("");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnModificar(e);
				}
			});
			btnModificar.setVisible(false);
			btnModificar.setIcon(new ImageIcon(ModificacionProd.class.getResource("/imagenes/icon-modifi.png")));
			btnModificar.setBackground(Color.WHITE);
			btnModificar.setBounds(100, 235, 45, 40);
			contentPane.add(btnModificar);
		}
		{
			cbxCodPro = new JComboBox();
			cbxCodPro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCbxCodPro(e);
				}
			});
			cbxCodPro.setModel(new DefaultComboBoxModel(ArregloProducto.opcionesCbx()));
			cbxCodPro.setBounds(150, 50, 260, 25);
			contentPane.add(cbxCodPro);
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

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificar();
	}

	protected void actionPerformedCbxCodPro(ActionEvent e) {
		reestablecer();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void consultar() {
		int cod = Integer.parseInt(String.valueOf(cbxCodPro.getSelectedItem()));
		Producto producto = ArregloProducto.obtener(ArregloProducto.encontrar(cod));

		txtDescripcion.setText("" + producto.getDescripcion());
		txtDescripcion.setEditable(true);
		txtPrecio.setText("" + producto.getPrecio());
		txtPrecio.setEditable(true);

		btnModificar.setVisible(true);
	}

	private void modificar() {
		int c = JOptionPane.showConfirmDialog(this, "¿Esta seguro de guardar los cambios?", "CONFIRMAR CAMBIOS",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (c == 0) {
			Producto producto = modify(cbxCodPro.getSelectedItem());
			producto.setDescripcion(txtDescripcion.getText());
			producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
			;
			cerrar();
		}
	}

	private void reestablecer() {
		txtDescripcion.setText("");
		txtPrecio.setText("");

		btnModificar.setVisible(false);
	}

	private Producto modify(Object cod) {
		return ArregloProducto.obtener(ArregloProducto.encontrar(Integer.parseInt(String.valueOf(cod))));
	}

	private void cerrar() {
		this.dispose();
	}
}
