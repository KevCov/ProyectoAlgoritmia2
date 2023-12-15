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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class Venta extends JFrame {

	private JPanel contentPane;
	private JLabel lblCodigoCliente;
	private JLabel lblCodigoVendedor;
	private JLabel lblCodigoProducto;
	private JLabel lblUnidades;
	private JComboBox cbxCodCli;
	private JComboBox cbxCodVen;
	private JComboBox cbxCodPro;
	private JTextField txtUnidades;
	private JTextArea txtBoleta;
	private JButton btnVender;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta frame = new Venta();
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
	public Venta() {
		setTitle("PUNTO DE VENTA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblCodigoCliente = new JLabel("Codigo Cliente");
			lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCodigoCliente.setBounds(20, 32, 122, 25);
			contentPane.add(lblCodigoCliente);
		}
		{
			lblCodigoVendedor = new JLabel("Codigo Vendedor");
			lblCodigoVendedor.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCodigoVendedor.setBounds(150, 32, 122, 25);
			contentPane.add(lblCodigoVendedor);
		}
		{
			lblCodigoProducto = new JLabel("Codigo Producto");
			lblCodigoProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCodigoProducto.setBounds(295, 32, 122, 25);
			contentPane.add(lblCodigoProducto);
		}
		{
			lblUnidades = new JLabel("Unidades");
			lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblUnidades.setBounds(435, 32, 122, 25);
			contentPane.add(lblUnidades);
		}
		{
			cbxCodCli = new JComboBox();
			cbxCodCli.setModel(new DefaultComboBoxModel(ArregloCliente.opcionesCbx()));
			cbxCodCli.setBounds(20, 70, 100, 25);
			contentPane.add(cbxCodCli);
		}
		{
			cbxCodVen = new JComboBox();
			cbxCodVen.setModel(new DefaultComboBoxModel(ArregloVendedor.opcionesCbx()));
			cbxCodVen.setBounds(150, 70, 100, 25);
			contentPane.add(cbxCodVen);
		}
		{
			cbxCodPro = new JComboBox();
			cbxCodPro.setModel(new DefaultComboBoxModel(ArregloProducto.opcionesCbx()));
			cbxCodPro.setBounds(295, 70, 100, 25);
			contentPane.add(cbxCodPro);
		}
		{
			txtUnidades = new JTextField();
			txtUnidades.setBounds(435, 70, 100, 25);
			contentPane.add(txtUnidades);
			txtUnidades.setColumns(10);
		}
		{
			txtBoleta = new JTextArea();
			txtBoleta.setMargin(new Insets(15, 2, 2, 2));
			txtBoleta.setFont(new Font("Monospaced", Font.PLAIN, 16));
			txtBoleta.setEditable(false);
			txtBoleta.setBounds(20, 153, 536, 250);
			contentPane.add(txtBoleta);
		}
		{
			btnVender = new JButton("VENDER");
			btnVender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnVender(e);
				}
			});
			btnVender.setBackground(Color.WHITE);
			btnVender.setBounds(232, 115, 85, 25);
			contentPane.add(btnVender);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setIcon(new ImageIcon(Venta.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setBounds(463, 110, 45, 35);
			contentPane.add(btnCerrar);
		}
	}

	protected void actionPerformedBtnVender(ActionEvent e) {
		try {
			generarBoleta();
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS DATOS", "FALTAN DATOS",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IndexOutOfBoundsException e3) {
			JOptionPane.showMessageDialog(this, "LAS UNIDADES NO PUEDEN SER CERO", "ERROR UNIDADES",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void generarBoleta() {
		txtBoleta.setText("");
		int codCli = Integer.parseInt(String.valueOf(cbxCodCli.getSelectedItem()));
		int codVen = Integer.parseInt(String.valueOf(cbxCodVen.getSelectedItem()));
		int codPro = Integer.parseInt(String.valueOf(cbxCodPro.getSelectedItem()));
		int und = Integer.parseInt(txtUnidades.getText());
		Producto producto = ArregloProducto.obtener(ArregloProducto.encontrar(codPro));
		nuevaFactura(codPro, codVen, und, producto.getPrecio());
		Factura factura = ArregloFactura.obtener(ArregloFactura.encontrar(Factura.getCodigoFactura() - 1));

		texto(producto, factura);
	}

	private void nuevaFactura(int codPro, int codVen, int und, double precio) {
		if (und > 0) {
			ArregloFactura.agregar(new Factura(codPro, codVen, und, precio));
		}
	}

	private void texto(Producto pr, Factura fr) {
		imprimir(" Codigo de cliente        : " + String.valueOf(cbxCodCli.getSelectedItem()));
		imprimir(" Codigo de vendedor       : " + String.valueOf(cbxCodVen.getSelectedItem()));
		imprimir(" Codigo de producto       : " + String.valueOf(cbxCodPro.getSelectedItem()));
		imprimir(" Descripcion del producto : " + pr.getDescripcion());
		imprimir(" Precio unitario          : " + pr.getPrecio());
		imprimir(" Importe subtotal         : " + fr.importeSubTotal());
		imprimir(" Importe del IGV          : " + fr.importeIGV());
		imprimir(" Importe total a pagar    : " + fr.importeTotal());
		imprimir();

		txtUnidades.setText("");
	}

	private void imprimir() {
		imprimir("");
	}

	private void imprimir(String s) {
		txtBoleta.append(s + "\n");
	}

	private void cerrar() {
		this.dispose();
	}
}
