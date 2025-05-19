package trackingBus;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class PanelRegistro extends JPanel {
    private Image background;
    private JTextArea textArea;
    private Ventana ventana;

    public PanelRegistro(Ventana ventana) {
        this.ventana = ventana;
        setLayout(null);

        // Cargar fondo
        URL backgroundUrl = getClass().getResource("/trackingBus/resources/preview_3.png");
        if (backgroundUrl != null) {
            background = new ImageIcon(backgroundUrl).getImage();
        }

        // Botón ruta 1
        JButton botonruta1 = new JButton("Linea 27");
        botonruta1.setBounds(792, 175, 130, 30);
        botonruta1.setFont(new Font("SansSerif", Font.BOLD, 20));
        botonruta1.setContentAreaFilled(false);
        botonruta1.addActionListener(e -> {
            ventana.setLineaSeleccionada("BUS-027");
            ventana.cambiarPanel("PanelRegistro");});
        add(botonruta1);

        // Botón ruta 2
        JButton botonruta2 = new JButton("Linea 29");
        botonruta2.setBounds(792, 240, 130, 30);
        botonruta2.setFont(new Font("SansSerif", Font.BOLD, 20));
        botonruta2.setContentAreaFilled(false);
        botonruta2.addActionListener(e -> {
            ventana.setLineaSeleccionada("BUS-029");
            ventana.cambiarPanel("PanelRegistro");});
        add(botonruta2);

        // Botón ruta 3
        JButton botonruta3 = new JButton("Linea C1");
        botonruta3.setBounds(792, 300, 130, 30);
        botonruta3.setFont(new Font("SansSerif", Font.BOLD, 20));
        botonruta3.setContentAreaFilled(false);
        botonruta3.addActionListener(e -> {
            ventana.setLineaSeleccionada("BUS-C1");
            ventana.cambiarPanel("PanelRegistro");});
        add(botonruta3);

        // Botón salir
        JButton botonsalir = new JButton("Salir");
        botonsalir.setBounds(845, 615, 100, 30);
        botonsalir.setContentAreaFilled(false);
        botonsalir.addActionListener(e -> System.exit(0));
        add(botonsalir);

        // Botón atrás
        JButton botonAtras = new JButton("Volver");
        botonAtras.setBounds(845, 565, 100, 30);
        botonAtras.setContentAreaFilled(false);
        botonAtras.addActionListener(e -> ventana.cambiarPanel("PanelRuta"));
        add(botonAtras);

        // Área de texto para mostrar registros
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(60, 150, 620, 400);
        textArea.setOpaque(false);
        textArea.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        textArea.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(scrollPane);
    }

    // Este método debe llamarse cada vez que se entra en el panel
    public void actualizarRegistros() {
        String lineaSeleccionada = ventana.getLineaSeleccionada();
        if (lineaSeleccionada == null || lineaSeleccionada.isEmpty()) {
            textArea.setText("No se ha especificado una línea de autobús.");
            return;
        }

        File archivo = new File("gps_data.csv");
        if (!archivo.exists()) {
            textArea.setText("Archivo gps_data.csv no encontrado.");
            return;
        }

        List<String> coincidencias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(lineaSeleccionada)) {
                    coincidencias.add(linea);

                }
            }
        } catch (IOException e) {
            textArea.setText("Error al leer el archivo: " + e.getMessage());
            return;
        }

        List<String> ultimas5 = coincidencias.stream()
                .skip(Math.max(0, coincidencias.size() - 5))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder(lineaSeleccionada + ":\n\n");
        for (String registro : ultimas5) {
            sb.append(registro).append("\n\n");        }
        textArea.setText(sb.toString());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
