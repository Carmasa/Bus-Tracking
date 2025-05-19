package trackingBus;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
// Esta clase genera datos simulados de autobuses y los guarda en un archivo CSV.
// En un entorno de producción real, esta clase podría modificarse para insertar datos directamente en una base de datos.

public class RegistrarDatos {
    private static final String[] AUTOBUSES = {"BUS-027", "BUS-029", "BUS-C1"};
    private static final int MINUTOS = 60;

    public static void generarArchivo(String nombreArchivo) throws IOException {
        FileWriter writer = new FileWriter(nombreArchivo);
        writer.write("busId,timestamp,latitude,longitude,speed\n");

        //Iniciaremos un temporizador al iniciar el programa para realizar la simulacion
        Random rand = new Random();
        LocalDateTime iniciarTiempo = LocalDateTime.now();

        for (String busId : AUTOBUSES) {
            double lat = 37;
            double lon = -6;
            for (int i = 0; i < MINUTOS; i++) {
                LocalDateTime timestamp = iniciarTiempo.plusMinutes(i);
                double speed = rand.nextBoolean() ? rand.nextDouble() * 180 : 0.0;
                // Simularemos pequeños desplazamientos geográficos
                lat += (rand.nextDouble() - 0.5) / 100;
                lon += (rand.nextDouble() - 0.5) / 100;
                writer.write(busId + "," + timestamp + "," + lat + "," + lon + "," + String.format("%.2f", speed) + "\n");
            }
        }

        writer.close();
        System.out.println("Datos generados en " + nombreArchivo);
    }
}

