package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clases.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import arreglos.*;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ConsultaCli extends JFrame {

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
	private JComboBox cbxCodCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCli frame = new ConsultaCli();
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
	public ConsultaCli() {
		setTitle("CONSULTAR CLIENTE");
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
			btnConsultar.setBackground(Color.WHITE);
			btnConsultar.setIcon(new ImageIcon(ConsultaCli.class.getResource("/imagenes/icon-buscar-cli.png")));
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnConsultar(e);
				}
			});
			btnConsultar.setBounds(100, 345, 45, 40);
			contentPane.add(btnConsultar);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setIcon(new ImageIcon(ConsultaCli.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBounds(300, 345, 45, 40);
			contentPane.add(btnCerrar);
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

	public void actionPerformedBtnConsultar(ActionEvent e) {
		try {
			consultar();
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(this, "COMPLETE TODOS LOS DATOS", "FALTAN DATOS",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	protected void actionPerformedCbxCodCli(ActionEvent e) {
		reestablecer();
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void consultar() {
		int cod = Integer.parseInt(String.valueOf(cbxCodCli.getSelectedItem()));
		Cliente cliente = ArregloCliente.obtener(ArregloCliente.encontrar(cod));

		txtNomCli.setText("" + cliente.getNombres());
		txtApeCli.setText("" + cliente.getApellidos());
		txtTelfCli.setText("" + cliente.getTelefono());
		txtDniCli.setText("" + cliente.getDni());
	}

	private void reestablecer() {
		txtNomCli.setText("");
		txtApeCli.setText("");
		txtTelfCli.setText("");
		txtDniCli.setText("");
	}

	private void cerrar() {
		this.dispose();
	}
}
