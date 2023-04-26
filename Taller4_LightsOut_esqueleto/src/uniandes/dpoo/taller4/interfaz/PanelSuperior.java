package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class PanelSuperior extends JPanel implements ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VentanaPrincipal vPrincipal;
	JComboBox<String> comboBoxTamano;
	JRadioButton radioButtonFacil;
	JRadioButton radioButtonMedio;
	JRadioButton radioButtonDificil;
	
    public PanelSuperior(VentanaPrincipal vePrincipal) {
    	
    	vPrincipal = vePrincipal;
    	
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Label "Tama�o"
        JLabel labelTamano = new JLabel("Tama�o :");
        add(labelTamano);

        // Lista desplegable
        String[] opcionesTamano = {"5x5", "7x7", "9x9"};
        comboBoxTamano = new JComboBox<>(opcionesTamano);
        add(comboBoxTamano);
        comboBoxTamano.addItemListener(this);

        // Label "Dificultad"
        JLabel labelDificultad = new JLabel("Dificultad : ");
        add(labelDificultad);

        // Botones de opci�n
        radioButtonFacil = new JRadioButton("F�cil");
        radioButtonMedio = new JRadioButton("Medio");
        radioButtonDificil = new JRadioButton("Dif�cil");

        // Agrupar los botones de opci�n para que solo uno pueda estar seleccionado a la vez
        ButtonGroup grupoDificultad = new ButtonGroup();
        radioButtonFacil.addItemListener(this);
        grupoDificultad.add(radioButtonFacil);
        radioButtonMedio.addItemListener(this);
        grupoDificultad.add(radioButtonMedio);
        radioButtonDificil.addItemListener(this);
        grupoDificultad.add(radioButtonDificil);

        // Agregar los botones de opci�n al panel
        add(radioButtonFacil);
        add(radioButtonMedio);
        add(radioButtonDificil);
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == comboBoxTamano) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String selection = (String) e.getItem();
	
				if (selection == "5x5") {
					vPrincipal.actualizarTableroTamano(5);
				}else if(selection == "7x7") {
					vPrincipal.actualizarTableroTamano(7);
				}else {
					vPrincipal.actualizarTableroTamano(9);
				}
			}
		}
		else if (radioButtonFacil.isSelected()) {
			System.out.println("Facil");
			vPrincipal.actualizarDificultad(1);
		}
		else if (radioButtonMedio.isSelected()) {
			System.out.println("Medio");
			vPrincipal.actualizarDificultad(2);
		}
		else if (radioButtonDificil.isSelected()) {
			System.out.println("Dificil");
			vPrincipal.actualizarDificultad(3);
		}
	}
}
