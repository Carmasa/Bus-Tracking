package trackingBus;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ventana extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelContenedor;
    private String lineaSeleccionada;

    public Ventana() {

        setTitle("TrackingBus");
        setSize(1000, 707);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true); // Permite que el panel reciba eventos del teclado


        // Contenedor con CardLayout
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        // Crear los paneles
        PanelInicio panel1 = new PanelInicio(this);
        PanelRuta panel2 = new PanelRuta(this);
        PanelRegistro panel3 = new PanelRegistro(this);

        // Añadir los paneles al contenedor
        panelContenedor.add(panel1, "PanelInicio");
        panelContenedor.add(panel2, "PanelRuta");
        panelContenedor.add(panel3, "PanelRegistro");
        add(panelContenedor);
        setVisible(true);
    }

    public void cambiarPanel(String nombrePanel) {
        if (nombrePanel.equals("PanelRuta")) {
            for (Component comp : panelContenedor.getComponents()) {
                if (comp instanceof PanelRuta) {
                    ((PanelRuta) comp).actualizarParadas();
                }
            }
        } else if (nombrePanel.equals("PanelRegistro")) {
            for (Component comp : panelContenedor.getComponents()) {
                if (comp instanceof PanelRegistro) {
                    ((PanelRegistro) comp).actualizarRegistros();
                }
            }
        }
        cardLayout.show(panelContenedor, nombrePanel);
    }
    public void setLineaSeleccionada(String linea) {
        this.lineaSeleccionada = linea;
    }

    public String getLineaSeleccionada() {
        return lineaSeleccionada;
    }
}
