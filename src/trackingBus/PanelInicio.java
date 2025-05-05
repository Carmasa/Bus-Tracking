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
        JButton botonruta1 = new JButton("ruta1");
        botonruta1.setBounds(45, 75, 130, 30);
        botonruta1.setContentAreaFilled(true);
        botonruta1.addActionListener(e -> ventana.cambiarPanel("PanelRuta"));
        add(botonruta1);

        // Botón ruta 2
        JButton botonruta2 = new JButton("ruta2");
        botonruta2.setBounds(45, 140, 130, 30);
        botonruta2.setContentAreaFilled(true);
        botonruta2.addActionListener(e -> ventana.cambiarPanel("PanelRuta"));
        add(botonruta2);

        // Botón ruta 3
        JButton botonruta3 = new JButton("ruta3");
        botonruta3.setBounds(45, 210, 130, 30);
        botonruta3.setContentAreaFilled(true);
        botonruta3.addActionListener(e -> ventana.cambiarPanel("PanelRuta"));
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
