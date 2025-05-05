package trackingBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class PanelRuta   extends JPanel {
    private Image background; // Imagen de fondo

    public PanelRuta(Ventana ventana) {
        setLayout(null);
        // Cargar la imagen de fondo
        URL backgroundUrl = getClass().getResource("/trackingBus/resources/preview_2.png");
        if (backgroundUrl != null) {
            background = new ImageIcon(backgroundUrl).getImage();
        }
        JButton botonregistro = new JButton();
        botonregistro.setBounds(850, 600, 120, 40); // x = 150, y = 100, ancho = 120, alto = 30
        botonregistro.setContentAreaFilled(true);
        botonregistro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar al panel de juego
                ventana.cambiarPanel("PanelRegistro");
            }
        });
        add(botonregistro);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo si está disponible
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
