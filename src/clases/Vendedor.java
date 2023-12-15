package clases;

public class Vendedor {
	public static int codigoVendedor = 2001; // autogenerado y correlativo a partir del 2001
	private int codVen;
	private int categoria;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String dni;

	// Constructor
	public Vendedor(int categoria, String nombres, String apellidos, String felefono, String dni) {
		this.categoria = categoria;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = felefono;
		this.dni = dni;
		this.codVen = codigoVendedor;
		codigoVendedor++;
	}

	// Metodos get and set para los atributos
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String felefono) {
		this.telefono = felefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodVen() {
		return codVen;
	}

	public void setCodVen(int codVen) {
		this.codVen = codVen;
	}

	// Metodos de acceso para el atributo de la clase
	public static int getCodigoVendedor() {
		return codigoVendedor;
	}

	public static void setCodigoVendedor(int codigoVendedor) {
		Vendedor.codigoVendedor = codigoVendedor;
	}
	
	//METODO QUE DEVUELVE UN ARRAY CON LOS DATOS DEL VENDEDOR PARA EL REPORTE POR VENDEDOR
	//SE DEBE EJECUTAR EN UN FOR RECORRIENDO LAS FACTURAS Y PASARLAS COMO PARAMETRO
	//VERIFICAR QUE EL COD.VENDEDOR DE LA FACTURA SEA IGUAL AL COD.VENDEDOR DEL CUAL SE QUIERE EL REPORTE
	//SI COINCIDEN LOS CODIGOS, LLAMAR A ESTE METODO.
	public static Double[] extraerVendedor(Factura fact) {
		Double[] report = new Double[4];
		report[0] = (double) fact.getCodFact();
		report[1] = (double) fact.getCodigoProducto();
		report[2] = (double) fact.getUnidades();
		report[3] = fact.getPrecio();
		return report;
	}
}
