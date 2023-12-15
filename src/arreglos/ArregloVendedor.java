package arreglos;

import java.util.ArrayList;

import clases.*;

public class ArregloVendedor {
	private static ArrayList<Vendedor> vendedores = new ArrayList();;

	public static Vendedor obtener(int pos) {
		return vendedores.get(pos);
	}

	public static void agregar(Vendedor vn) {
		vendedores.add(vn);
	}

	public static void eliminar(int pos) {
		vendedores.remove(pos);
	}

	public static int tamanio() {
		return vendedores.size();
	}

	//OTROS METODOS
	public static int encontrar(int cod) {
		for (int i = 0; i < vendedores.size(); i++) {
			if (cod == vendedores.get(i).getCodVen())
				return i;
		}
		return -1;
	}

	public static String[] opcionesCbx() {
		String[] opciones = new String[tamanio()];
		for (int i = 0; i < tamanio(); i++) {
			opciones[i] = String.valueOf(obtener(i).getCodVen());
		}
		return opciones;
	}
}
