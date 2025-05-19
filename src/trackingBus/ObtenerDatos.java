package trackingBus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Esta clase lee datos desde un archivo CSV y los carga en memoria utilizando ArrayList<GPSData>,
// lo cual es eficiente para aplicaciones de análisis en tiempo real o desarrollo local.

public class ObtenerDatos {


    public static ArrayList<GPSData> leerArchivo(String nombreArchivo) {
        ArrayList<GPSData> listaDatos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            br.readLine(); // Leer la cabecera del CSV

            while ((line = br.readLine()) != null) {

                String[] lineas = line.split(",");


                String busId = lineas[0].trim();
                try {
                    LocalDateTime timestamp = LocalDateTime.parse(lineas[1].trim(), formatter); // Usar el formatter aquí
                    double lat = Double.parseDouble(lineas[2].trim().replace(',', '.'));
                    double lon = Double.parseDouble(lineas[3].trim().replace(',', '.'));
                    double speed = Double.parseDouble(lineas[4].trim().replace(',', '.'));

                    // Validación de datos (coordenadas, velocidad)
                    if (lat < -90 || lat > 90 || lon < -180 || lon > 180 || speed < 0) {
                        System.out.println("Datos inválidos en la línea: " + line);
                        continue; // Omitir los datos inválidos
                    }

                    listaDatos.add(new GPSData(busId, timestamp, lat, lon, speed));

                } catch (Exception e) {
                    System.out.println("Error al parsear la línea: " + line);
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDatos;
    }
}