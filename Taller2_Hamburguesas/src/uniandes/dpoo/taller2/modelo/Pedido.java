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
	
	private ArrayList<String> generarTextoFactura() {
		
		ArrayList<String> texto = new ArrayList<String>();
		texto.add("Restaurante\n");
		texto.add("Pedido: "+getIdPedido()+"\n");
		texto.add("Cliente: "+this.nombreCliente+"\n");
		texto.add("Direccion: "+this.direccionCliente+"\n");
		texto.add("--------Productos--------\n");
		for(int i=0; i<itemsPedido.size(); i++) {
			texto.add(itemsPedido.get(i).generarTextoFactura()+"\n");
			}
		texto.add("Total neto: "+getPrecioNetoPedido()+"\n");
		texto.add("IVA: "+getPrecioIVAPedido()+"\n");
		texto.add("Total: "+getPrecioTotalPedido()+"\n");
		return texto;
		}
	
	public void guardarFactura(){
		try{
		File archivo = new File("./data/facturas/"+getIdPedido()+".txt");
		FileWriter escritor = new FileWriter(archivo);
		
		ArrayList<String> texto = generarTextoFactura();
		
		for(int x = 0; x < texto.size(); x++) {
		escritor.write(texto.get(x));
		}
		escritor.close();
		}
		catch(IOException e) {
			System.out.println("Ha ocurrido un error al guardar la factura");
			e.printStackTrace();
		}
	}
	
	public String toString() {
		
		return idPedido +" "+ nombreCliente +" "+ direccionCliente +" "+ itemsPedido;
	}
		
}
	
