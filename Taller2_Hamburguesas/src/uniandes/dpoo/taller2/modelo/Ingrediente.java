package uniandes.dpoo.taller2.modelo;

public class Ingrediente {
	
	private String nombre;
	
	private int costoAdicional;
	
	public Ingrediente(String idnombre, int idcosto) {
		
		nombre = idnombre;
		
		costoAdicional = idcosto;
		
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public int getCostoAdicional() {
		
		return costoAdicional;
	}
}
