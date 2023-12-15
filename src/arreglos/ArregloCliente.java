package arreglos;

import java.util.ArrayList;

import clases.*;

public class ArregloCliente {
	private static ArrayList<Cliente> clientes = new ArrayList();;

	public static Cliente obtener(int pos) {
		return clientes.get(pos);
	}

	public static void agregar(Cliente cl) {
		clientes.add(cl);
	}

	public static void eliminar(int pos) {
		clientes.remove(pos);
	}

	public static int tamanio() {
		return clientes.size();
	}

	// OTROS METODOS
	public static int encontrar(int cod) {
		for (int i = 0; i < clientes.size(); i++) {
			if (cod == clientes.get(i).getCodCli())
				return i;
		}
		return -1;
	}

	public static String[] opcionesCbx() {
		String[] opciones = new String[tamanio()];
		for (int i = 0; i < tamanio(); i++) {
			opciones[i] = String.valueOf(obtener(i).getCodCli());
		}

		return opciones;
	}
}
