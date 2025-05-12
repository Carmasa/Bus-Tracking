package trackingBus;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelRuta extends JPanel {
    private Image background;
    private JTextArea areaParadas;
    private Ventana ventana;
    private JLabel labelLinea;
    private JLabel labelMapa;  // Para mostrar el mapa

    public PanelRuta(Ventana ventana) {
        this.ventana = ventana;
        setLayout(null);

        // Etiqueta para mostrar el nombre de la línea
        labelLinea = new JLabel();
        labelLinea.setBounds(128, 54, 200, 40);
        labelLinea.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(labelLinea);

        // Fondo
        URL backgroundUrl = getClass().getResource("/trackingBus/resources/preview_2.png");
        if (backgroundUrl != null) {
            background = new ImageIcon(backgroundUrl).getImage();
        }

        // Área de paradas
        areaParadas = new JTextArea();
        areaParadas.setEditable(false);
        areaParadas.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaParadas);
        scrollPane.setBounds(80, 120, 400, 400);
        add(scrollPane);

        // Label para mostrar el mapa
        labelMapa = new JLabel();
        labelMapa.setBounds(500, 120, 450, 400); // ajusta tamaño según imagen
        add(labelMapa);

        // Botón a registros
        JButton botonRegistro = new JButton("Ver registros");
        botonRegistro.setBounds(850, 520, 120, 40);
        botonRegistro.addActionListener(e -> ventana.cambiarPanel("PanelRegistro"));
        add(botonRegistro);

        // Botón volver
        JButton botonVolver = new JButton("Volver");
        botonVolver.setBounds(850, 600, 120, 40);
        botonVolver.addActionListener(e -> ventana.cambiarPanel("PanelInicio"));
        add(botonVolver);
    }

    public void actualizarParadas() {
        String linea = ventana.getLineaSeleccionada();
        if (linea == null || linea.isEmpty()) {
            areaParadas.setText("Ninguna línea seleccionada.");
            labelLinea.setText("");
            labelMapa.setIcon(null); // Limpiar mapa
            return;
        }

        labelLinea.setText("Línea: " + linea);

        // Mostrar paradas
        Autobus bus = new Autobus(linea);
        StringBuilder sb = new StringBuilder();
        for (String parada : bus.getParadas()) {
            sb.append(parada).append("\n\n");
        }
        areaParadas.setText(sb.toString());

        // Cargar imagen del mapa
        String imagenNombre = "/trackingBus/resources/" + linea + ".png";
        URL imagenURL = getClass().getResource(imagenNombre);
        if (imagenURL != null) {
            ImageIcon icono = new ImageIcon(imagenURL);
            Image imagenEscalada = icono.getImage().getScaledInstance(labelMapa.getWidth()-100, labelMapa.getHeight()-100, Image.SCALE_SMOOTH);
            labelMapa.setIcon(new ImageIcon(imagenEscalada));
        } else {
            labelMapa.setIcon(null);
            System.err.println("Imagen no encontrada: " + imagenNombre);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
