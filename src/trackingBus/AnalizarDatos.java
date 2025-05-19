package trackingBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Esta clase analiza la lista de datos cargada en memoria (ArrayList<GPSData>) para obtener estadísticas por autobús.

public class AnalizarDatos {

    public static void analizar(ArrayList<GPSData> listaDatos) {
        Map<String, ArrayList<Double>> speeds = new HashMap<>();
        Map<String, Integer> stops = new HashMap<>();

        for (GPSData data : listaDatos) {
            String busId = data.getBusId();
            double speed = data.getSpeed();

            // Agrupar velocidades por busId
            speeds.putIfAbsent(busId, new ArrayList<>());
            speeds.get(busId).add(speed);

            // Contar paradas (velocidad 0)
            if (speed == 0.0) {
                stops.put(busId, stops.getOrDefault(busId, 0) + 1);
            }
        }

        for (String busId : speeds.keySet()) {
            ArrayList<Double> speedList = speeds.get(busId);
            double velocidadMedia = speedList.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            int contadorParadas = stops.getOrDefault(busId, 0);

            System.out.println("🚍 " + busId);
            System.out.printf(" - Velocidad media:"+ velocidadMedia + "km/h\n");
            System.out.println(" - Número de paradas: " + contadorParadas);
        }
                /*
         * En un entorno real, estos análisis podrían realizarse:
         *   Usando consultas SQL (ej. AVG, COUNT WHERE speed = 0)
         *   Mediante agregaciones en MongoDB con pipelines
         *   A través de funciones  procesan datos desde Firebase
         *
         * Las ventajas de usar bases de datos son entre otras:
         * - Los datos recogidos permaneceran amacenados en la base de datos
         *   y podras conectarte a ellos desde cualquier dispositivo que tenga acceso.
         * - Posibilidad de almacenar grandes cantidades de datos
         * - Soporte para múltiples usuarios
         */
    }
}

