package trackingBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalizarDatos {

    public static void analizar(ArrayList<GPSData> listaDatos) {
        Map<String, ArrayList<Double>> speeds = new HashMap<>();
        Map<String, Integer> stops = new HashMap<>();

        for (GPSData data : listaDatos) {
            String busId = data.getBusId();
            double speed = data.getSpeed();

            speeds.putIfAbsent(busId, new ArrayList<>());
            speeds.get(busId).add(speed);

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
    }
}

