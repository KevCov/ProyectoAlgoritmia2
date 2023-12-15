package arreglos;

import java.util.ArrayList;

import clases.*;

public class ArregloProducto {
	private static ArrayList<Producto> productos = new ArrayList();;

	public static Producto obtener(int pos) {
		return productos.get(pos);
	}

	public static void agregar(Producto pd) {
		productos.add(pd);
	}

	public static void eliminar(int pos) {
		productos.remove(pos);
	}

	public static int tamanio() {
		return productos.size();
	}

	// OTROS METODOS
	public static int encontrar(int cod) {
		for (int i = 0; i < productos.size(); i++) {
			if (cod == productos.get(i).getCodPro())
				return i;
		}
		return -1;
	}

	public static String[] opcionesCbx() {
		String[] opciones = new String[tamanio()];
		for (int i = 0; i < tamanio(); i++) {
			opciones[i] = String.valueOf(obtener(i).getCodPro());
		}

		return opciones;
	}

	public static double precioPromedio() {
		double pp = 0;
		for (Producto pr : productos) {
			pp += pr.getPrecio();
		}
		return pp / productos.size();
	}

	public static double mayorPrecio() {
		double mayor = obtener(0).getPrecio();
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getPrecio() > mayor) {
				mayor = obtener(i).getPrecio();
			}
		}
		return mayor;
	}

	public static double menorPrecio() {
		double menor = obtener(0).getPrecio();
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getPrecio() < menor) {
				menor = obtener(i).getPrecio();
			}
		}
		return menor;
	}

}
