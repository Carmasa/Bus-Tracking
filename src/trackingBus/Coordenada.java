package trackingBus;
//Clase que  representa una coordenada geográfica con latitud y longitud.
public class Coordenada {
    private double latitud;
    private double longitud;

    public Coordenada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public String toString() {
        return "(" + latitud + ", " + longitud + ")";
    }
}
