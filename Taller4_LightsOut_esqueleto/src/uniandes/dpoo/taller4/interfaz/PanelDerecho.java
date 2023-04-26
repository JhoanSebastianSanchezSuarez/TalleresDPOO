package uniandes.dpoo.taller4.interfaz;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelDerecho extends JPanel implements ActionListener{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton botonNuevo;
	JButton botonReiniciar;
	JButton botonCambiarJugador;
	JButton botonTop;
	VentanaPrincipal vPrincipal;
	
	
	public PanelDerecho(VentanaPrincipal vePrincipal){
		
		vPrincipal = vePrincipal;
		setLayout( new GridLayout( 4,1 ) );
        setBorder( new TitledBorder( "Menu" ) );
        botonNuevo = new JButton("Nueva Partida");
        botonNuevo.addActionListener(this);
        add(botonNuevo);
        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.addActionListener(this);
        add(botonReiniciar);
        botonCambiarJugador = new JButton("Cambiar De Jugador");
        botonCambiarJugador.addActionListener(this);
        add(botonCambiarJugador);
        botonTop = new JButton("TOP 10");
        botonTop.addActionListener(this);
        add(botonTop);
        
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonNuevo) {
			if (vPrincipal.comprobarDificultad()) {
				vPrincipal.iniciarNuevaPartida();
				JOptionPane.showMessageDialog(null, "Iniciaste una nueva partida", "Nuevo juego", JOptionPane.INFORMATION_MESSAGE);
			}else{
			JOptionPane.showMessageDialog(null,"No seleccionaste el nivel de dificultad, eligelo antes de iniciar partida", "Alerta", JOptionPane.INFORMATION_MESSAGE );
			}
		}else if (e.getSource() == botonReiniciar) {
			vPrincipal.reiniciarPartida();
		}else if (e.getSource() == botonCambiarJugador) {
			vPrincipal.cambiarNombreJugador();
		}else if (e.getSource() == botonTop) {
			vPrincipal.abrirVentanaTop();
		}
		
	}
	
	
	
	

}
