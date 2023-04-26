package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class VentanaPrincipal extends JFrame implements WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tablero tableroJuego = new Tablero(5);
	private PanelTablero panelTableroJuego;
	private PanelSuperior panelSuperior;
	private PanelDerecho panelDerecho;
	private PanelInferior panelInferior;
	private int dificultad;
	private String nomb = "---";
	private Top10 top10 = new Top10 ();
	private File infoTop = new File("./data/top10.csv");
	
	public VentanaPrincipal() {
		setSize(800,720);
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setTitle( "Lights Off" );
        setResizable(false);
		setLayout(new BorderLayout());
		panelTableroJuego = new PanelTablero(this);
		panelSuperior = new PanelSuperior(this);
		panelDerecho = new PanelDerecho(this);
		panelInferior = new PanelInferior(this);
		add(panelTableroJuego, BorderLayout.CENTER);
		add(panelSuperior, BorderLayout.NORTH);
		add(panelDerecho, BorderLayout.EAST);
		add(panelInferior, BorderLayout.SOUTH);
		addWindowListener(this);
		cargarTop();
		
		
	}
	
	public boolean[][] darTableroPanel(){
		return tableroJuego.darTablero();
	}
	
	public void jugar(int x,int y) {
		System.out.println(tableroJuego.jugar(x,y));
		panelInferior.actualizarNumMovimientos(tableroJuego.darJugadas());
		System.out.print(tableroJuego.tableroIluminado());
		System.out.println(tableroJuego.darTablero());
		
		if (tableroJuego.tableroIluminado()) {
			System.out.println("Completo");
			int puntaje = tableroJuego.calcularPuntaje();
			if (top10.esTop10(puntaje)) { 
				top10.agregarRegistro(nomb, puntaje);
				JOptionPane.showMessageDialog(null,"Felicidades ahorae eres parte del top 10","Logro", JOptionPane.INFORMATION_MESSAGE);
			}
			JOptionPane.showMessageDialog(null,"Terminaste el juego inicia una nueva partida! Sacaste "+puntaje,"Logro", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void actualizarTableroTamano(int tamano) {
		tableroJuego = new Tablero (tamano);
		panelTableroJuego.actualizarTablero();;
	}
	
	public void actualizarDificultad(int dif) {
		dificultad = dif;
	}
	
	public void iniciarNuevaPartida() {
		tableroJuego.desordenar(dificultad);
		tableroJuego.reiniciar();
		panelTableroJuego.actualizarTablero();
		panelInferior.actualizarNumMovimientos(tableroJuego.darJugadas());
	}
	
	public boolean comprobarDificultad() {
		return this.dificultad > 0;
	}
	
	public void reiniciarPartida() {
		tableroJuego.reiniciar();
		panelTableroJuego.actualizarTablero();
		panelInferior.actualizarNumMovimientos(tableroJuego.darJugadas());
	}
	
	public void cambiarNombreJugador() {
		nomb = JOptionPane.showInputDialog("Ingrese el nombre del jugador");
		panelInferior.actualizarNombreJugador(nomb);
	}
	
	public void cargarTop() {
		top10.cargarRecords(infoTop);
	}
	
	public Collection<RegistroTop10> retornarTop(){
		return top10.darRegistros();
	}
	
	public void guardarTop() {
		try {top10.salvarRecords(infoTop);
		JOptionPane.showMessageDialog(null, "Se guardaron los records", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al guardar los records", "Error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(null, "Error al guardar los records", "Error", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();	
		}
	}
	
	public void abrirVentanaTop() {
		VentanaTop vTop = new VentanaTop(this);
		vTop.setLocationRelativeTo(null);
		vTop.setVisible(true);
	}
	
	public static void main (String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setLocationRelativeTo(null);
		ventanaPrincipal.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		guardarTop();
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
