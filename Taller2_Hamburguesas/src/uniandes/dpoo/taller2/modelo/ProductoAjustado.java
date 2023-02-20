package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
	
	private int precioBase;
	
	private String nombre;
	
	private ArrayList<Ingrediente> Adiciones = new ArrayList<Ingrediente>();
	
	private ArrayList<Ingrediente> Eliminaciones = new ArrayList<Ingrediente>();
	
	public ProductoAjustado(Producto base) {
		
		precioBase = base.getPrecio();
		
		nombre = base.getNombre() + " modificado ";
		
	}
	
	public void agregarIngrediente(Ingrediente adicion) {
		
		//Agrega un ingrediente si no esta ya en adiciones o tampoco en
		//eliminaciones, y si este ya estaba en eliminaciones
		//lo saca de la lista de eliminaciones
		if (Eliminaciones.contains(adicion)) {
			int i = Eliminaciones.indexOf(adicion);
			Eliminaciones.remove(i);
			
		}
		else if (!Adiciones.contains(adicion)) {
			
			Adiciones.add(adicion);			
		}

	}
	
	public void eliminarIngrediente(Ingrediente eliminacion) {
		
		//Elimina un ingrediente si no esta ya en eliminaciones o tampoco en adiciones
		// si ya esta en adiciones lo saca de la lista de adiciones
		if (Adiciones.contains(eliminacion)) {
			int i = Eliminaciones.indexOf(eliminacion);
			Eliminaciones.remove(i);
			
		}
		else if (!Eliminaciones.contains(eliminacion)) {
			Eliminaciones.add(eliminacion);
		}
	}
	
	public int getPrecio() {
		//Recorre la lista de adiciones y suma el costo adicional
		// al precio base y lo retorna.
		
		int precio = precioBase;
		
		for(int x=0; x<Adiciones.size(); x++) {
			precio += Adiciones.get(x).getCostoAdicional();
		}
		return precio;
	}

	@Override
	public String getNombre() {
		//Retorna el nombre del producto.
		return nombre;
	}

	@Override
	public String generarTextoFactura() {
		//Recorre la lista de las modificaciones para formar
		//una cadena y luego retornar la cadena para la factura
		String tempa = "Adicion de ";
		String tempb = "Sin ";
		String fin = "";
		
		if (Adiciones.size()>0) {
			for(int x=0; x<Adiciones.size(); x++) {
				tempa += (Adiciones.get(x).getNombre());
				if ((Adiciones.size()!= 1) || (Adiciones.size()!= x)){
					tempa += ", ";
				}
			}
		}
		if (Eliminaciones.size()>0) {
			for(int x=0; x<Eliminaciones.size();x++) {
				tempb += (Eliminaciones.get(x).getNombre());
				if ((Eliminaciones.size()!= 1) || (Eliminaciones.size()!= x)){
					tempb += ", ";
				}
			}
		}
		if ((Adiciones.size()>0) || (Eliminaciones.size()>0)) {
			
			fin = tempa+"/"+tempb;
		}
		else if(Adiciones.size()>0) {
			fin  = tempa;
			
		}
		else {
			fin = tempb;
		}
		
		return "$"+getPrecio()+" "+getNombre()+"("+fin+")";
	}
	
	
}
