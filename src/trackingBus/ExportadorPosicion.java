package trackingBus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

//Clase que  exporta la última posición conocida de un autobús desde un archivo CSV a un archivo JSON.
public class ExportadorPosicion {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void exportarPosicion(String busId) {
        PosicionBus ultimaPosicion = obtenerUltimaPosicionDeCSV(busId);

        if (ultimaPosicion == null) {
            System.err.println("No se encontró posición para " + busId);
            return;
        }

        try (FileWriter writer = new FileWriter(busId.toLowerCase() + "_status.json")) {
            gson.toJson(ultimaPosicion, writer);
            System.out.println("Exportado: " + busId.toLowerCase() + "_status.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Busca en el archivo CSV la posición más reciente del autobús indicado.
    private static PosicionBus obtenerUltimaPosicionDeCSV(String busId) {
        String rutaCSV = "gps_data.csv";
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaCSV));
            PosicionBus ultimaPosicion = null;
            LocalDateTime timestampMasReciente = null;

            for (String linea : lineas) {
                if (linea.trim().isEmpty() || linea.startsWith("busId")) continue;

                String[] partes = linea.split(",");
                if (partes.length < 5) continue;

                if (partes[0].equalsIgnoreCase(busId)) {
                    LocalDateTime timestamp = LocalDateTime.parse(partes[1].trim());
                    double latitud = Double.parseDouble(partes[2].trim());
                    double longitud = Double.parseDouble(partes[3].trim());

                    if (timestampMasReciente == null || timestamp.isAfter(timestampMasReciente)) {
                        timestampMasReciente = timestamp;
                        ultimaPosicion = new PosicionBus(busId, latitud, longitud, timestamp.toString());
                    }
                }
            }

            if (ultimaPosicion == null) {
                System.out.println("No se encontró posición para " + busId);
            }

            return ultimaPosicion;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Clase interna para el JSON
    private static class PosicionBus {
        String busId;
        double latitude;
        double longitude;
        String timestamp;

        public PosicionBus(String busId, double latitude, double longitude, String timestamp) {
            this.busId = busId;
            this.latitude = latitude;
            this.longitude = longitude;
            this.timestamp = timestamp;
        }
    }
}
