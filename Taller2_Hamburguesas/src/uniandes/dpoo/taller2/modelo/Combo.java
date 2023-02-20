package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;

public class Combo implements Producto {

	private double descuento;
	
	private String nombreCombo;
	
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public Combo(double iddescuento, String idnombre) {
		//Construye un combo
		descuento = iddescuento;
		nombreCombo = idnombre;
	}
	
	public void agregarItemACombo(Producto itemCombo) {
		//Agrega un item al combo.
		if (itemCombo != null){
		productos.add(itemCombo);
		}
	}
	
	public int getPrecio() {
		//Retorna el precio del combo recorriendo la lista de productios.
		int totalcombo = 0;
		for(int x = 0; x<productos.size();x++) {
			
			System.out.println(productos.get(x));
			double valorfloat = (productos.get(x).getPrecio())*descuento;
			
			int valor = (int)valorfloat;
			
			totalcombo += valor;
		}
		
		return totalcombo;
	}

	public String getNombre() {
		// Retorna el nombre del producto
		return nombreCombo;
	}

	public String generarTextoFactura() {
		// Retorna una cadena con el texto para la factura
		return "$"+getPrecio()+" "+nombreCombo;
	}
	
	public String toString() {
		return "Nombre: "+ nombreCombo +" Precio: "+ this.getPrecio()+ " Productos: "+productos;
	}
	
	

}
