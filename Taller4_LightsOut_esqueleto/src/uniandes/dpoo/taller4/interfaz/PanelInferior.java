package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import javax.swing.*;

public class PanelInferior extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal vPrincipal;
	private JLabel labelMovimientos;
	private JLabel labelNumMovimientos;
	private JLabel labelJugador;
	private JLabel labelNombJugador;
	
	
	public PanelInferior(VentanaPrincipal vePrincipal) {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		vPrincipal = vePrincipal;
		
		// Label "Movimientos"
        labelMovimientos = new JLabel("Movimientos :");
        add(labelMovimientos);
        
        // Label NumMovimientos
        labelNumMovimientos = new JLabel(" 0 ");
        add(labelNumMovimientos);
        
        // Label "Jugador"
        labelJugador = new JLabel("Jugador :");
        add(labelJugador);
        
        // Label NombJugador
        labelNombJugador = new JLabel(" --- ");
        add(labelNombJugador);
		
	}
	
	public void actualizarNumMovimientos(int numMovimientos) {
        labelNumMovimientos.setText(String.valueOf(numMovimientos));
    }
    
    public void actualizarNombreJugador(String nombreJugador) {
        labelNombJugador.setText(nombreJugador);
    }
}
