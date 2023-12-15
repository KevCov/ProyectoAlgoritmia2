package clases;

import java.util.ArrayList;

public class Producto {
	public static int codigoProducto = 3001; //autogenerado y correlativo a partir de 3001
	private int codPro;
	private String descripcion;
	private double precio; //no incluye el 18% de IGV
	
	public Producto(String descripcion, double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.codPro = codigoProducto;
		codigoProducto++;
	}

	//Metodos set and get de los atributos
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getCodPro() {
		return codPro;
	}

	public void setCodPro(int codPro) {
		this.codPro = codPro;
	}

	//Metodos set and get de los atributos de clase
	public static int getCodigoProducto() {
		return codigoProducto;
	}

	public static void setCodigoProducto(int codigoProducto) {
		Producto.codigoProducto = codigoProducto;
	}
	
	//METODO QUE DEVUELVE UN ARRAY CON LOS DATOS DEL PRODUCTO PARA EL REPORTE POR PRODUCTO
	//SE DEBE EJECUTAR DENTRO DE UN FOR RECORRIENDO LAS FACTURAS Y PASARLAS COMO PARAMETRO
	//VERIFICAR QUE EL COD.PRODUCTO DE LA FACTURA SEA IGUAL AL COD.PRODUCTO DEL CUAL SE QUIERE EL REPORTE
	//SI COINCIDEN LOS CODIGOS, LLAMAR A ESTE METODO.
	public static Double[] extraerProducto(Factura fact) {
		Double report[] = new Double[4];
		report[0] = (double) fact.getCodFact();
		report[1] = (double) fact.getCodigoVendedor();
		report[2] = (double) fact.getUnidades();
		report[3] = fact.getPrecio();
		return report;
	}
}
