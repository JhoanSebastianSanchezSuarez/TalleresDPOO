package uniandes.dpoo.taller2.modelo;

public class ProductoMenu implements Producto
{
	private String Nombre;
	private int PrecioBase;
	
	public ProductoMenu(String idnombre, int idprecio) {
		// Construye un productoMenu
		Nombre = idnombre;
		PrecioBase = idprecio;
		
	}
	public int getPrecio() {
		// Retorna el precio base(Sin adiciones) del producto.
		return PrecioBase;
	}

	@Override
	public String getNombre() {
		// Retorna el nombre del producto.
		return Nombre;
	}

	@Override
	public String generarTextoFactura() {
		// Retorna cadena con el precio base y el nombre del producto.
		String Texto = "$"+PrecioBase+" "+Nombre;
		return Texto;
	}

}