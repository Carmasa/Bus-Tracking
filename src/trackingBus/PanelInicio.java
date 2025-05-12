package trackingBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class PanelInicio extends JPanel {
    private Image background;

    public PanelInicio(Ventana ventana) {
        // Desactiva el layout para usar posiciones absolutas
        setLayout(null);

        // Cargar la imagen de fondo
        URL backgroundUrl = getClass().getResource("/trackingBus/resources/preview_1.png");
        if (backgroundUrl != null) {
            background = new ImageIcon(backgroundUrl).getImage();
        }

        // Botón ruta 1
        JButton botonruta1 = new JButton("Linea 27");
        botonruta1.setBounds(40, 75, 130, 30);
        botonruta1.setContentAreaFilled(false);
        botonruta1.addActionListener(e -> {
            ventana.setLineaSeleccionada("BUS-027");
            ventana.cambiarPanel("PanelRuta");});
        add(botonruta1);

        // Botón ruta 2
        JButton botonruta2 = new JButton("Linea 29");
        botonruta2.setBounds(40, 140, 130, 30);
        botonruta2.setContentAreaFilled(false);
        botonruta2.addActionListener(e -> {
            ventana.setLineaSeleccionada("BUS-029");
            ventana.cambiarPanel("PanelRuta");});
        add(botonruta2);

        // Botón ruta 3
        JButton botonruta3 = new JButton("Linea C1");
        botonruta3.setBounds(40, 210, 130, 30);
        botonruta3.setContentAreaFilled(false);
        botonruta3.addActionListener(e -> {
            ventana.setLineaSeleccionada("BUS-C1");
            ventana.cambiarPanel("PanelRuta");});
        add(botonruta3);

        // Botón salir
        JButton botonsalir = new JButton("Salir");
        botonsalir.setBounds(900, 550, 30, 30);
        botonsalir.setContentAreaFilled(true);
        botonsalir.addActionListener(e -> System.exit(0));
        add(botonsalir);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
