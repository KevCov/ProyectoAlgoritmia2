package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.*;
import arreglos.*;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ModificacionCli extends JFrame {

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
	private JButton btnModificar;
	private JComboBox cbxCodCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificacionCli frame = new ModificacionCli();
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
	public ModificacionCli() {
		setTitle("MODIFICAR CLIENTE");
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
			btnCerrar.setIcon(new ImageIcon(ModificacionCli.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBounds(300, 345, 45, 40);
			contentPane.add(btnCerrar);
		}
		{
			btnModificar = new JButton("");
			btnModificar.setBackground(Color.WHITE);
			btnModificar.setVisible(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnModificar(e);
				}
			});
			btnModificar.setIcon(new ImageIcon(ModificacionCli.class.getResource("/imagenes/icon-modifi.png")));
			btnModificar.setBounds(100, 345, 45, 40);
			contentPane.add(btnModificar);
		}
		{
			cbxCodCli = new JComboBox();
			cbxCodCli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCbxCodCli(e);
				}
			});
			cbxCodCli.setModel(new DefaultComboBoxModel(ArregloCliente.opcionesCbx()));
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

	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificar();
	}

	protected void actionPerformedCbxCodCli(ActionEvent e) {
		reestablecer();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// Metodos privados
	private void consultar() {
		int cod = Integer.parseInt(String.valueOf(cbxCodCli.getSelectedItem()));
		Cliente cliente = ArregloCliente.obtener(ArregloCliente.encontrar(cod));

		txtNomCli.setText("" + cliente.getNombres());
		txtNomCli.setEditable(true);
		txtApeCli.setText("" + cliente.getApellidos());
		txtApeCli.setEditable(true);
		txtTelfCli.setText("" + cliente.getTelefono());
		txtTelfCli.setEditable(true);
		txtDniCli.setText("" + cliente.getDni());
		txtDniCli.setEditable(true);

		btnModificar.setVisible(true);
	}

	private void modificar() {
		int c = JOptionPane.showConfirmDialog(this, "¿Esta seguro de guardar los cambios?", "CONFIRMAR CAMBIOS",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (c == 0) {
			Cliente cliente = modify(cbxCodCli.getSelectedItem());
			cliente.setNombres(txtNomCli.getText());
			cliente.setApellidos(txtApeCli.getText());
			cliente.setTelefono(txtTelfCli.getText());
			cliente.setDni(txtDniCli.getText());
			cerrar();
		}
	}

	private void reestablecer() {
		txtNomCli.setText("");
		txtApeCli.setText("");
		txtTelfCli.setText("");
		txtDniCli.setText("");
		btnModificar.setVisible(false);
	}

	private Cliente modify(Object cod) {
		return ArregloCliente.obtener(ArregloCliente.encontrar(Integer.parseInt(String.valueOf(cod))));
	}

	private void cerrar() {
		this.dispose();
	}
}
