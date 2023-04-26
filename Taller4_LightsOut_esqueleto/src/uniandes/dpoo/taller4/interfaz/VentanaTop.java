package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class VentanaTop extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static VentanaPrincipal vPrincipal;
	
	private Color[] topColors = new Color[5];
	
	
	public VentanaTop(VentanaPrincipal vePrincipal) {
		vPrincipal = vePrincipal;
		setSize(150,200);
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setTitle( "Top 10" );
        setResizable(false);
		setLayout(new BorderLayout());
		JPanel panelSuperior = new JPanel();
        JLabel numeral = new JLabel("#");
        JLabel nombre = new JLabel("Nombre");
        JLabel puntaje = new JLabel("Puntaje");
        topColors[0] = new Color(239,184,16);
        topColors[1] = new Color(192,192,192);
        topColors[2] = new Color(205,127,50);
        topColors[3] = new Color(37,40,80);
        topColors[4] = Color.BLACK;

        panelSuperior.add(numeral);
        panelSuperior.add(nombre);
        panelSuperior.add(puntaje);
        
        add(panelSuperior,BorderLayout.NORTH);
        
        Collection<RegistroTop10> valores = vPrincipal.retornarTop();
        JLabel[] labels = new JLabel[10];
        int i = 0;
        DefaultListModel<JLabel> model = new DefaultListModel<>();
        for (RegistroTop10 registro : valores) {
        	String texto = (i+1)+ "." + registro.toString();
        	labels[i] = new JLabel(texto);
        	if(i<3) {
        		labels[i].setForeground(topColors[i]);
        		labels[i].setBackground(topColors[i]);
        	}else if(i<5) {
        		labels[i].setForeground(topColors[3]);
        		labels[i].setBackground(topColors[3]);
        	}else {labels[i].setForeground(topColors[4]);
        	labels[i].setBackground(topColors[4]);}
        	model.addElement(labels[i]);
        	i++;
        }
        JList<JLabel> listaTop = new JList<>(model);
        
        listaTop.setCellRenderer(new ListCellRenderer<JLabel>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends JLabel> list, JLabel value, int index, boolean isSelected, boolean cellHasFocus) {
                value.setHorizontalAlignment(SwingConstants.CENTER);
            	if (isSelected) {
            		value.setForeground(Color.YELLOW);
            	}else {
            		value.setForeground(value.getBackground());;
            	}
                return value;
            }
        });
        
        JScrollPane scrollePane = new JScrollPane();
        
        scrollePane.add(listaTop);
        
        scrollePane.setViewportView(listaTop);
        add(scrollePane, BorderLayout.CENTER);
	}

}
