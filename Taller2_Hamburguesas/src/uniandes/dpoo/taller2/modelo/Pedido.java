package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Pedido {
	
	static private int numeroPedidos;
	
	private int idPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();
	
	public Pedido(String idnombreCliente, String iddireccionCliente) {
		
		nombreCliente = idnombreCliente;
		
		direccionCliente = iddireccionCliente;
		
		numeroPedidos += 1;
		
		idPedido = numeroPedidos;
		
		}
	
	public int getIdPedido() {
		
		return this.idPedido;
	
		}
	
	public void agregarProducto(Producto nuevoItem) {
		
		itemsPedido.add(nuevoItem);
		
		}
	
	private int getPrecioNetoPedido() {
		
		int totalneto = 0;
		for(int i=0; i<itemsPedido.size(); i++){
			totalneto += itemsPedido.get(i).getPrecio();
			}
		return totalneto;
		}
	
	private int getPrecioIVAPedido() {
		
		int precioIVA = getPrecioNetoPedido()*19/100;
		
		return precioIVA;
		}
	
	private int getPrecioTotalPedido() {
		
		int totalpedido = getPrecioIVAPedido()+ getPrecioNetoPedido();
		
		return totalpedido;
		}
	
	private String generarTextoFactura() {
		
		String texto = "Restaurante\n";
		texto.concat("Pedido: "+getIdPedido()+"\n");
		texto.concat("Cliente: "+this.nombreCliente+"\n");
		texto.concat("Direccion: "+this.direccionCliente+"\n");
		texto.concat("--------Productos--------");
		for(int i=0; i<itemsPedido.size(); i++) {
			texto.concat(itemsPedido.get(i).generarTextoFactura()+"\n");
			}
		texto.concat("Total neto: "+getPrecioNetoPedido()+"\n");
		texto.concat("IVA: "+getPrecioIVAPedido()+"\n");
		texto.concat("Total: "+getPrecioTotalPedido()+"\n");
		return texto;
		}
	
	public void guardarFactura(){
		try{
		File archivo = new File("./data/facturas/"+getIdPedido());
		FileWriter escritor = new FileWriter(archivo);
		
		escritor.write(generarTextoFactura());
		escritor.close();
		}
		catch(IOException e) {
			System.out.println("Ha ocurrido un error al guardar la factura");
			e.printStackTrace();
		}
	}
		
}
	
