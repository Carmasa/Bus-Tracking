package trackingBus;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class PanelRuta extends JPanel {
    private Image background;
    private JTextPane areaParadas;
    private Ventana ventana;
    private JLabel labelLinea;
    private JLabel labelMapa;
    private JLabel labelTemporizador;
    private Timer refrescoUI;

    public PanelRuta(Ventana ventana) {
        this.ventana = ventana;
        setLayout(null);

        // Etiqueta de línea
        labelLinea = new JLabel();
        labelLinea.setBounds(128, 54, 200, 40);
        labelLinea.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(labelLinea);

        // Temporizador
        labelTemporizador = new JLabel();
        labelTemporizador.setFont(new Font("SansSerif", Font.BOLD, 18));
        labelTemporizador.setBounds(700, 555, 300, 30);
        add(labelTemporizador);

        // Fondo
        URL backgroundUrl = getClass().getResource("/trackingBus/resources/preview_2.png");
        if (backgroundUrl != null) {
            background = new ImageIcon(backgroundUrl).getImage();
        }

        // Área de paradas
        areaParadas = new JTextPane();
        areaParadas.setContentType("text/html");
        areaParadas.setEditable(false);
        areaParadas.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaParadas);
        scrollPane.setBounds(80, 120, 400, 400);
        add(scrollPane);

        // Label de mapa
        labelMapa = new JLabel();
        labelMapa.setBounds(500, 120, 450, 400);
        add(labelMapa);

        // Botón a registros
        JButton botonRegistro = new JButton("Ver registros");
        botonRegistro.setContentAreaFilled(false);
        botonRegistro.setBounds(840, 560, 120, 40);
        botonRegistro.addActionListener(e -> ventana.cambiarPanel("PanelRegistro"));
        add(botonRegistro);

        // Botón volver
        JButton botonVolver = new JButton("Volver");
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBounds(840, 610, 120, 40);
        botonVolver.addActionListener(e -> ventana.cambiarPanel("PanelInicio"));
        add(botonVolver);

        // Refrescar UI con un pequeño temporizador (cada segundo)
        refrescoUI = new Timer(1000, e -> refrescarUI());
        refrescoUI.start();
    }

    public void actualizarParadas() {
        String linea = ventana.getLineaSeleccionada();
        if (linea == null || linea.isEmpty()) {
            areaParadas.setText("Ninguna línea seleccionada.");
            labelLinea.setText("");
            labelMapa.setIcon(null);
            return;
        }

        labelLinea.setText("Línea: " + linea);

        // Cargar mapa
        String imagenNombre = "/trackingBus/resources/" + linea + ".png";
        URL imagenURL = getClass().getResource(imagenNombre);
        if (imagenURL != null) {
            ImageIcon icono = new ImageIcon(imagenURL);
            Image imagenEscalada = icono.getImage().getScaledInstance(labelMapa.getWidth() - 100, labelMapa.getHeight() - 100, Image.SCALE_SMOOTH);
            labelMapa.setIcon(new ImageIcon(imagenEscalada));
        } else {
            labelMapa.setIcon(null);
            System.err.println("Imagen no encontrada: " + imagenNombre);
        }

        refrescarUI();
    }

    private void refrescarUI() {
        String linea = ventana.getLineaSeleccionada();
        if (linea == null) return;

        Ventana.EstadoLinea estado = ventana.getEstadoActual();
        if (estado == null || estado.paradas == null || estado.paradas.isEmpty()) return;

        // Mostrar parada actual en rojo
        StringBuilder html = new StringBuilder("<html><body style='font-family: SansSerif;'>");
        for (int i = 0; i < estado.paradas.size(); i++) {
            String parada = estado.paradas.get(i);
            if (i == estado.indiceParada) {
                html.append("<p style='color:red;'><b>").append(parada).append("</b></p>");
            } else {
                html.append("<p>").append(parada).append("</p>");
            }
        }
        html.append("</body></html>");
        areaParadas.setText(html.toString());
        areaParadas.setCaretPosition(0);

        // Actualizar temporizador
        labelTemporizador.setText(estado.tiempoRestante + "s");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
