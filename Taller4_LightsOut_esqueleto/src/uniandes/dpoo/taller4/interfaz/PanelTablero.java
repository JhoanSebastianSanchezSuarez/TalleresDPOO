package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class PanelTablero extends JPanel implements MouseListener {
    private int filas;
    private int columnas;
    private int anchoCuadro;
    private int altoCuadro;
    private VentanaPrincipal vPrincipal;

    public PanelTablero(VentanaPrincipal vePrincipal) {
    	setSize(630,630);
    	vPrincipal = vePrincipal;
    	addMouseListener(this);
        this.filas = vPrincipal.darTableroPanel().length;
        this.columnas = filas;
        this.anchoCuadro = getWidth()/columnas;
        this.altoCuadro = anchoCuadro;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        boolean[][] tablero = vPrincipal.darTableroPanel();
        Color apagado = new Color(115,183,255);
        Color bApagado = new Color(115,145,255);
        Color encendido = Color.YELLOW;
        Color bEncendido = Color.BLACK;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int x = j * anchoCuadro;
                int y = i * altoCuadro;
                if (tablero[i][j]== true) {
                	g2d.setColor(encendido);
                    g2d.fillRect(x, y, anchoCuadro, altoCuadro);
                    g2d.setColor(bEncendido);
                    g2d.drawRect(x, y, anchoCuadro, altoCuadro);
                }else{
                	g2d.setColor(apagado);
                    g2d.fillRect(x, y, anchoCuadro, altoCuadro);
                    g2d.setColor(bApagado);
                    g2d.drawRect(x, y, anchoCuadro, altoCuadro);	
                }
                
            }
        }
    }
    public int[] convertirCoordenadasACasilla(int x, int y)
    {
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / filas;
        int anchoCasilla = anchoPanelTablero / columnas;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }
    
    public void mousePressed(MouseEvent e)
    {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        vPrincipal.jugar(casilla[0], casilla[1]);
        repaint();
    }
    
    public void actualizarTablero() {
    	this.filas = vPrincipal.darTableroPanel().length;
    	this.columnas = this.filas;
    	this.anchoCuadro = getWidth()/columnas;
        this.altoCuadro = anchoCuadro;
        repaint();
    	
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
