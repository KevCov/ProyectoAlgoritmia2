package clases;

public class Cliente {

	private static int codigoCliente = 1001; // autogenerado y correlativo a partir de 1001
	private int codCli;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String dni;

	// Constructor
	public Cliente(String nombres, String apellidos, String telefono, String dni) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
		this.codCli = codigoCliente;
		codigoCliente++;
	}

	// Metodos de acceso para los atributos
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

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodCli() {
		return codCli;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}

	// METODOS PARA LOS ATRIBUTOS DE LA CLASE
	public static int getCodigoCliente() {
		return codigoCliente;
	}

	public static void setCodigoCliente(int codigoCliente) {
		Cliente.codigoCliente = codigoCliente;
	}
}
