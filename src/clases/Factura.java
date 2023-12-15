package clases;

public class Factura {
	public static int codigoFactura = 4001; // autogenerado y correlativo a partir de 4001
	private int codFact;
	private int codigoProducto;
	private int codigoVendedor;
	private int unidades;
	private double precio; // guarda el precio del producto

	public Factura(int codigoProducto, int codigoVendedor, int unidades, double precio) {
		this.codigoProducto = codigoProducto;
		this.codigoVendedor = codigoVendedor;
		this.unidades = unidades;
		this.precio = precio;
		this.codFact = codigoFactura;
		codigoFactura++;
	}

	// Metodos set and get de los atributos
	public int getCodFact() {
		return codFact;
	}

	public void setCodFact(int codFact) {
		this.codFact = codFact;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// METODOS DE LOS ATRIBUTOS DE LA CLASE
	public static int getCodigoFactura() {
		return codigoFactura;
	}

	public static void setCodigoFactura(int codigoFactura) {
		Factura.codigoFactura = codigoFactura;
	}

	// OTROS METODOS
	public double importeSubTotal() {
		return unidades * precio;
	}

	public double importeIGV() {
		return 0.18 * importeSubTotal();
	}

	public double importeTotal() {
		return importeSubTotal() + importeIGV();

	}
}
