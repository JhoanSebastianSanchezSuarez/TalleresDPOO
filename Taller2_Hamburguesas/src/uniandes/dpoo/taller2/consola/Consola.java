package uniandes.dpoo.taller2.consola;
import uniandes.dpoo.taller2.modelo.Pedido;
import uniandes.dpoo.taller2.modelo.Producto;
import uniandes.dpoo.taller2.modelo.ProductoAjustado;
import uniandes.dpoo.taller2.modelo.ProductoMenu;
import uniandes.dpoo.taller2.modelo.Combo;
import uniandes.dpoo.taller2.modelo.Ingrediente;
import uniandes.dpoo.taller2.procesamiento.Restaurante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Consola{
	
	static Restaurante restaurante = new Restaurante();
	
	static HashMap<Integer, Producto> menuProductos = new HashMap<Integer, Producto>();
	
	static HashMap<Integer, Ingrediente> menuIngredientes = new HashMap<Integer, Ingrediente>();
	
	
	
	public static void mostrarMenu()
	{
		
		System.out.println("1. Mostrar menú");
		System.out.println("2. Iniciar nuevo pedido");
		System.out.println("3. Agregar un elemento al pedido");
		System.out.println("4. Cerrar pedido y guardar la factura");
		System.out.println("5. Consultar factura con su id");
		System.out.println("6. Cerrar aplicacion");
		
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void ejecutarAplicacion()
	{
		System.out.println("Bienvenido al restaurante");
		ejecutarCargaInformacion();
		System.out.println("Se han cargado los datos exitosamente.");
		
		boolean continuar = true;
		
		while (continuar){
			
			try {
				mostrarMenu();
				
				int opcion = 0;
				try {
					opcion = Integer.parseInt(input("Ingrese la opcion"));
				} catch (Exception e) {
					System.out.println("Ingrese un valor valido");
					e.printStackTrace();
				}
				
				if (opcion == 1) {
					ejecutarMostrarMenuRestaurante();
				}
				else if (opcion == 2){
					ejecutarNuevoPedido();
					System.out.println("Se ha iniciado el pedido exitosamente");
				}
				else if (opcion == 3){
					ejecutarAgregarProducto();
				}
				else if (opcion == 4) {
					ejecutarCerrarYGuardarPedido();
				}
				else if (opcion == 5) {
					ejecutarConsultarFacturaId();
				}
				else if (opcion == 6) {
					continuar = false;
				}
				}catch (NumberFormatException | IOException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}}
				
		}
	
	public static void ejecutarCargaInformacion() {
		
		File archivoIngredientes = new File("./data/ingredientes.txt");
		
		File archivoMenu = new File("./data/menu.txt");
		
		File archivoCombo = new File("./data/combos.txt");
		
		restaurante.cargarInformacionRestaurante( archivoIngredientes, archivoMenu, archivoCombo);
		
		ArrayList<Producto> menuRestaurante = restaurante.getMenuBase();
		
		ArrayList<Combo> menuCombos = restaurante.getCombos();
		
		ArrayList<Ingrediente> menuIngrediente = restaurante.getIngredientes();
		
		for(int i = 0; i < menuIngrediente.size(); i++) {
			Ingrediente unIngrediente = menuIngrediente.get(i);
			menuIngredientes.put(i, unIngrediente);
		}
		
		int conteoMenu = 1;
		System.out.println("Lista de productos");
		for(int i = 0; i < menuRestaurante.size(); i++) {
			Producto unProducto = menuRestaurante.get(i);
			menuProductos.put(conteoMenu ,unProducto);
			conteoMenu ++;
			}
		System.out.println("Lista de combos");
		for(int i = 0; i < menuCombos.size(); i++) {
			Combo unCombo = menuCombos.get(i);
			menuProductos.put(conteoMenu, unCombo);
			conteoMenu ++;
			}
		}
	
	public static void ejecutarMostrarMenuRestaurante() {
		
		menuProductos.size();
		
		int conteoMenu = 1;
		System.out.println("Lista de productos");
		for(int i = 0; i < menuProductos.size(); i++) {
			Producto unProducto = menuProductos.get(i);
			if (unProducto != null) {
			String nombreProducto = unProducto.generarTextoFactura();
			
			System.out.println(conteoMenu+". " + nombreProducto);
			conteoMenu ++;}}
	}
	
	public static void ejecutarNuevoPedido() throws IOException {
		String nombreCliente = input("Ingrese el nombre del cliente");
		String direccionCliente = input("Ingrese la direccion del cliente");
		restaurante.iniciarPedido(nombreCliente, direccionCliente);
		}
	
	public static void ejecutarAgregarProducto() throws NumberFormatException {
		
		int ingreseProductoAgregar = Integer.parseInt(input("Ingrese el codigo del producto que desea agregar"));
		int deseaModificarProducto = Integer.parseInt(input("Desea modificar su producto (1. Si - 0. No)"));
		
		Producto productoAAgregar = (Producto) menuProductos.get(ingreseProductoAgregar);
		if(deseaModificarProducto == 1 && deseaModificarProducto <= 22){
			ProductoAjustado productoModAAgregar = new ProductoAjustado(productoAAgregar);
			int modificarProducto = Integer.parseInt(input("Ingrese la opcion (1. Agregar - 2. Eliminar - 3.Finalizar)"));
			while(modificarProducto != 3) {
				
				for (int x = 0; x < menuIngredientes.size(); x++) {
					Ingrediente unIngrediente = (Ingrediente) menuIngredientes.get(x);
					System.out.println(x+". "+unIngrediente.getNombre());
				}
				
				if(modificarProducto == 1) {
					Ingrediente ingredienteMod = menuIngredientes.get(Integer.parseInt(input("Ingrese el ingrediente a agregar")));
					productoModAAgregar.agregarIngrediente(ingredienteMod);
				}
				else if(modificarProducto == 2) {
					Ingrediente ingredienteMod = menuIngredientes.get(Integer.parseInt(input("Ingrese el ingrediente a eliminar")));
					productoModAAgregar.eliminarIngrediente(ingredienteMod);
				}
				else {
					System.out.println("Ingrese una opcion valida");
				}
				modificarProducto = Integer.parseInt(input("Ingrese la opcion (1. Agregar - 2. Eliminar - 3.Finalizar)"));
				}
			restaurante.getPedidoEnCurso().agregarProducto(productoModAAgregar);

		}else if(deseaModificarProducto == 0){
			restaurante.getPedidoEnCurso().agregarProducto(productoAAgregar);
		}else
		{
			System.out.println("Ingrese una opcion valida (Recuerde que los combos no se pueden modificar)");
		}
	}
	
	public static void ejecutarCerrarYGuardarPedido() {
		
		restaurante.cerrarYGuardarPedido();
	}
	
	public static void ejecutarConsultarFacturaId() throws IOException {
		
		String texto = "";
		
		String nombreArchivo = input("Ingrese el nombre del archivo");
		
		File archivo = new File ("./data/facturas/"+nombreArchivo+".txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			
			while (linea != null) {
				
				texto += linea +"\n";
				
				linea = br.readLine();
				
			}	
			System.out.println(texto);
				
		} catch (FileNotFoundException e) {
			System.out.println("No hay una factura con ese ID");
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		ejecutarAplicacion();
	}
	
}
	
	
	
