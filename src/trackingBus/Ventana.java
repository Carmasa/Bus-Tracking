package trackingBus;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.List;
import java.util.TimerTask;

public class Ventana extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelContenedor;
    private String lineaSeleccionada;
    private java.util.Timer exportTimer;

    // Mapa de estado por línea
    private Map<String, EstadoLinea> estadoLineas = new HashMap<>();

    public Ventana() {
        setTitle("TrackingBus");
        setSize(1000, 707);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setResizable(false);
        iniciarExportadorJSON();


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

        // Si no existe un estado para esta línea, lo crea
        estadoLineas.computeIfAbsent(linea, l -> new EstadoLinea(l));
    }

    public String getLineaSeleccionada() {
        return lineaSeleccionada;
    }

    public EstadoLinea getEstadoActual() {
        return estadoLineas.get(lineaSeleccionada);
    }

    private void iniciarExportadorJSON() {
        exportTimer = new java.util.Timer(); // Usa el nombre completo aquí
        exportTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ExportadorPosicion.exportarPosicion("BUS-027");
                ExportadorPosicion.exportarPosicion("BUS-029");
                ExportadorPosicion.exportarPosicion("BUS-C1");
            }
        }, 0, 60000); // cada 60 segundos
    }

    // Clase interna para mantener el estado de cada línea
    public class EstadoLinea {
        public final String nombreLinea;
        public int indiceParada = 0;
        public int tiempoRestante;
        public Timer timer;
        public List<String> paradas;
        private Timer exportTimer;

        public EstadoLinea(String nombreLinea) {
            this.nombreLinea = nombreLinea;
            this.paradas = new Autobus(nombreLinea).getParadas();
            iniciarTemporizador();
        }


        private void iniciarTemporizador() {
            tiempoRestante = (int) (Math.random() * (150 - 60 + 1)) + 60;

            if (timer != null && timer.isRunning()) {
                timer.stop();
            }

            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tiempoRestante--;
                    if (tiempoRestante <= 0) {
                        tiempoRestante = (int) (Math.random() * (150 - 60 + 1)) + 60;
                        indiceParada = (indiceParada + 1) % paradas.size();
                    }
                }
            });

            timer.start();
        }

    }

}
