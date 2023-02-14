package uniandes.dpoo.taller2.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aplicacion{
	
	public void mostrarMenu()
	{
		
		System.out.println("1. Mostrar menú");
		System.out.println("2. Iniciar nuevo pedido");
		System.out.println("3. Agregar un elemento al pedido");
		System.out.println("4. Finalizar pedido");
		System.out.println("5. Consultar factura");
		
	}
	
	public String input(String mensaje)
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
	
	public void ejecutarAplicacion()
	{
		System.out.println("Bienvenido al restaurante");
		
		boolean continuar = true;
		
		while (continuar){
			
			try {
				
				mostrarMenu();
				int opcion = Integer.parseInt(input("Ingrese la opcion"));
				
				if (opcion == 1)
				
				System.out.println("Hola");
				
				else {
					
					System.out.print("Ingrese una opcion valida");
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los numeros de las opciones.");
				}
			}
		}
	}
	
	
	
