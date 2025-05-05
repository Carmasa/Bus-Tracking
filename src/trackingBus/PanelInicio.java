package trackingBus;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelInicio  extends JPanel {
    private Image background; // Imagen de fondo

    public PanelInicio(Ventana ventana) {
        // Cargar la imagen de fondo
        URL backgroundUrl = getClass().getResource("/resources/images/PanelInicio.png");
        if (backgroundUrl != null) {
            background = new ImageIcon(backgroundUrl).getImage();
        }

    }
    }
