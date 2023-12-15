package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import arreglos.*;
import clases.*;

public class ReportePrecios extends JFrame {

	private JPanel contentPane;
	private JButton btnReporte;
	private JButton btnCerrar;
	private JTextArea txtR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportePrecios frame = new ReportePrecios();
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
	public ReportePrecios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 465, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnReporte = new JButton("");
			btnReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnReporte(e);
				}
			});
			btnReporte.setIcon(new ImageIcon(ReportePrecios.class.getResource("/imagenes/icon-listar.png")));
			btnReporte.setBackground(Color.WHITE);
			btnReporte.setBounds(100, 30, 45, 40);
			contentPane.add(btnReporte);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setIcon(new ImageIcon(ReportePrecios.class.getResource("/imagenes/icon-exit.png")));
			btnCerrar.setBackground(Color.WHITE);
			btnCerrar.setBounds(300, 30, 45, 40);
			contentPane.add(btnCerrar);
		}
		{
			txtR = new JTextArea();
			txtR.setMargin(new Insets(15, 2, 2, 2));
			txtR.setFont(new Font("Monospaced", Font.PLAIN, 13));
			txtR.setEditable(false);
			txtR.setBounds(10, 88, 434, 207);
			contentPane.add(txtR);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {
		try {
			reporte();
		} catch (IndexOutOfBoundsException e2) {
			JOptionPane.showMessageDialog(this, "NO HAY DATOS, INGRESE PRODUCTOS", "FALTAN DATOS",
					JOptionPane.INFORMATION_MESSAGE);
			txtR.setText("");
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrar();
	}

	// METODOS PRIVADOS
	private void reporte() {
		txtR.setText("");
		txtR.append(" Precio Promedio     : " + ArregloProducto.precioPromedio() + "\n");
		txtR.append(" Precio Mayor        : " + ArregloProducto.mayorPrecio() + "\n");
		txtR.append(" Precio Menor        : " + ArregloProducto.menorPrecio() + "\n");
	}

	private void cerrar() {
		this.dispose();
	}
}
