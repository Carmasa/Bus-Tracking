package trackingBus;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "gps_data.csv";

        try {
            RegistrarDatos.generarArchivo(nombreArchivo);

            ArrayList<GPSData> dataList = ObtenerDatos.leerArchivo(nombreArchivo);

            AnalizarDatos.analizar(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }
