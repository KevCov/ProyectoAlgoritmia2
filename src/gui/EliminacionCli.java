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

public class EliminacionCli extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtNomCli;
	private JTextField txtApeCli;
	private JTextField txtTelfCli;
	private JTextField txtDniCli;
	private JButton btnConsultar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JComboBox cbxCodCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminacionCli frame = new EliminacionCli();
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
	public EliminacionCli() {
		setTitle("ELIMINAR CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			txtNomCli = new JTextField();
			txtNomCli.setEditable(false);
			txtNomCli.setColumns(10);
			txtNomCli.setBounds(150, 110, 260, 25);
			contentPane.add(txtNomCli);
		}
		{
			txtApeCli = new JTextField();
			txtApeCli.setEditable(false);
			txtApeCli.setColumns(10);
			txtApeCli.setBounds(150, 170, 260, 25);
			contentPane.add(txtApeCli);
		}
		{
			txtTelfCli = new JTextField();
			txtTelfCli.setEditable(false);
			txtTelfCli.setColumns(10);
			txtTelfCli.setBounds(150, 230, 260, 25);
			contentPane.add(txtTelfCli);
		}
		{
			txtDniCli = new JTextField();
			txtDniCli.setEditable(false);
			txtDniCli.setColumns(10);
			txtDniCli.setBounds(150, 290, 260, 25);
			contentPane.add(txtDniCli);
		}
		{
			btnConsultar = new JButton("");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnConsultar(e);
				}
			});
			btnConsultar.setBackground(Color.WHITE);
			btnConsultar.setIcon(new ImageIcon(ModificacionCli.class.getResource("/imagenes/icon-buscar-cli.png")));
			btnConsultar.setBounds(200, 345, 45, 40);
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
			btnCerrar.setIcon(new ImageIcon(ModificacionCli.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.setBounds(300, 345, 45, 40);
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
			btnEliminar.setIcon(new ImageIcon(EliminacionCli.class.getResource("/imagenes/icon-eliminar.png")));
			btnEliminar.setBounds(100, 345, 45, 40);
			contentPane.add(btnEliminar);
		}
		{
			cbxCodCli = new JComboBox();
			cbxCodCli.setModel(new DefaultComboBoxModel(ArregloCliente.opcionesCbx()));
			cbxCodCli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCbxCodCli(e);
				}
			});
			cbxCodCli.setBounds(150, 50, 260, 25);
			contentPane.add(cbxCodCli);
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

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	protected void actionPerformedCbxCodCli(ActionEvent e) {
		reestablecer();
	}

	// METODOS PRIVADOS
	private void consultar() {
		int cod = Integer.parseInt(String.valueOf(cbxCodCli.getSelectedItem()));
		Cliente cliente = ArregloCliente.obtener(ArregloCliente.encontrar(cod));

		txtNomCli.setText("" + cliente.getNombres());
		txtApeCli.setText("" + cliente.getApellidos());
		txtTelfCli.setText("" + cliente.getTelefono());
		txtDniCli.setText("" + cliente.getDni());

		btnEliminar.setVisible(true);
	}

	private void eliminar() {
		int cod = Integer.parseInt(String.valueOf(cbxCodCli.getSelectedItem()));
		int c = JOptionPane.showConfirmDialog(this,
				"¿Esta seguro de eliminar al Cliente : " + cbxCodCli.getSelectedItem() + "?", "CONFIRMAR ELIMINACION",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (c == 0) {
			ArregloCliente.eliminar(ArregloCliente.encontrar(cod));
			cerrar();
		}
	}

	private void reestablecer() {
		txtNomCli.setText("");
		txtApeCli.setText("");
		txtTelfCli.setText("");
		txtDniCli.setText("");
		btnEliminar.setVisible(false);
	}

	private void cerrar() {
		this.dispose();
	}
}
