package trackingBus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ObtenerDatos {

    public static ArrayList<GPSData> leerArchivo(String nombreArchivo) {
        ArrayList<GPSData> listaDatos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] lineas = line.split(",");
                if (lineas.length != 5) continue;

                String busId = lineas[0];
                LocalDateTime timestamp = LocalDateTime.parse(lineas[1]);
                double lat = Double.parseDouble(lineas[2]);
                double lon = Double.parseDouble(lineas[3]);
                double speed = Double.parseDouble(lineas[4]);

                if (lat < -90 || lat > 90 || lon < -180 || lon > 180 || speed < 0) continue;

                listaDatos.add(new GPSData(busId, timestamp, lat, lon, speed));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDatos;
    }
}

