package trackingBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class PanelRegistro extends JPanel {
    private Image background;
    private JTextArea textArea;

    public PanelRegistro(Ventana ventana) {
        setLayout(null);

        // Cargar fondo
        URL backgroundUrl = getClass().getResource("/trackingBus/resources/preview_3.png");
        if (backgroundUrl != null) {
            background = new ImageIcon(backgroundUrl).getImage();
        }

        // Botón atrás
        JButton botonAtras = new JButton("Volver");
        botonAtras.setBounds(880, 650, 120, 40);
        botonAtras.setContentAreaFilled(true);
        botonAtras.addActionListener(e -> ventana.cambiarPanel("PanelRuta"));
        add(botonAtras);

        // Área de texto para mostrar registros
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(60, 150, 400, 400);
        textArea.setOpaque(false); // fondo transparente
        textArea.setBackground(new Color(0, 0, 0, 0)); // asegura que no pinte ningún fondo
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        textArea.setFont(new Font("SansSerif", Font.BOLD, 14)); // negrita

        add(scrollPane);

        // Cargar y mostrar datos
        mostrarUltimosRegistros();
    }

    private void mostrarUltimosRegistros() {
        File archivo = new File("gps_data.csv"); // Ruta relativa al proyecto
        if (!archivo.exists()) {
            textArea.setText("Archivo gps_data.csv no encontrado.");
            return;
        }

        List<String> coincidencias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("BUS-027")) {
                    coincidencias.add(linea);
                }
            }
        } catch (IOException e) {
            textArea.setText("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Obtener las últimas 5 líneas
        List<String> ultimas5 = coincidencias.stream()
                .skip(Math.max(0, coincidencias.size() - 5))
                .collect(Collectors.toList());

        // Mostrar en el área de texto
        StringBuilder sb = new StringBuilder("Últimos 5 registros de BUS-027:\n\n");
        for (String linea : ultimas5) {
            sb.append(linea).append("\n");
            sb.append(linea).append("\n");
        }
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
