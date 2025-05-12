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

        // Botón atrás
        JButton botonAtras = new JButton("Volver");
        botonAtras.setBounds(880, 600, 120, 40);
        botonAtras.setContentAreaFilled(true);
        botonAtras.addActionListener(e -> ventana.cambiarPanel("PanelRuta"));
        add(botonAtras);

        // Área de texto para mostrar registros
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(60, 150, 550, 400);
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

        StringBuilder sb = new StringBuilder("Últimos 5 registros de BUS-" + lineaSeleccionada + ":\n\n");
        for (String registro : ultimas5) {
            sb.append(registro).append("\n");
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
