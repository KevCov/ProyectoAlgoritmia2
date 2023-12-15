package arreglos;

import java.util.ArrayList;

import clases.*;

public class ArregloFactura {
	private static ArrayList<Factura> facturas = new ArrayList();;

	public static Factura obtener(int pos) {
		return facturas.get(pos);
	}

	public static void agregar(Factura fc) {
		facturas.add(fc);
	}

	public static void eliminar(int pos) {
		facturas.remove(pos);
	}

	public static int tamanio() {
		return facturas.size();
	}

	// OTROS METODOS
	public static int encontrar(int cod) {
		for (int i = 0; i < facturas.size(); i++) {
			if (cod == facturas.get(i).getCodFact())
				return i;
		}
		return -1;
	}

	// Número de ventas efectuadas por producto
	public static int ventasEfectuadasXPro(Producto prod) {
		int cantidad = 0;
		int cod = prod.getCodPro();
		for (int i = 0; i < tamanio(); i++) {
			if (cod == facturas.get(i).getCodigoProducto())
				cantidad++;
		}
		return cantidad;
	}

	// Unidades vendidas acumuladas por producto
	public static int unidadesVendidasXPro(Producto prod) {
		int unidades = 0;
		int cod = prod.getCodPro();
		for (int i = 0; i < tamanio(); i++) {
			if (cod == facturas.get(i).getCodigoProducto())
				unidades += facturas.get(i).getUnidades();
		}
		return unidades;
	}

	// Importe total acumulado por producto
	public static double totalAcumuladoXPro(Producto prod) {
		int total = 0;
		int cod = prod.getCodPro();
		for (int i = 0; i < tamanio(); i++) {
			if (cod == facturas.get(i).getCodigoProducto())
				total += facturas.get(i).importeTotal();
		}
		return total;
	}

	// Número de ventas efectuadas por vendedor
	public static int ventasEfectuadasXVen(Vendedor vend) {
		int cantidad = 0;
		int cod = vend.getCodVen();
		for (int i = 0; i < tamanio(); i++) {
			if (cod == facturas.get(i).getCodigoVendedor())
				cantidad++;
		}
		return cantidad;
	}

	// Unidades vendidas acumuladas por vendedor
	public static int unidadesVendidasXVen(Vendedor vend) {
		int unidades = 0;
		int cod = vend.getCodVen();
		for (int i = 0; i < tamanio(); i++) {
			if (cod == facturas.get(i).getCodigoVendedor())
				unidades += facturas.get(i).getUnidades();
		}
		return unidades;
	}

	// Importe total acumulado por vendedor
	public static double totalAcumuladoXVen(Vendedor vend) {
		int total = 0;
		int cod = vend.getCodVen();
		for (int i = 0; i < tamanio(); i++) {
			if (cod == facturas.get(i).getCodigoVendedor())
				total += facturas.get(i).importeTotal();
		}
		return total;
	}
}
