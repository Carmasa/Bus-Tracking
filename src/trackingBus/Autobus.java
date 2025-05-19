package trackingBus;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa un autobús con su nombre, paradas y coordenadas.
 */
public class Autobus {
    private String nombre;
    private List<String> paradas;
    private List<Coordenada> coordenadas;

    public Autobus(String nombre) {
        this.nombre = nombre;
        this.paradas = new ArrayList<>();
        this.coordenadas = new ArrayList<>();

        switch (nombre) {
            case "BUS-027":
                inicializarParadasLinea27();
                break;
            case "BUS-029":
                inicializarParadasLinea29();
                break;
            case "BUS-C1":
                inicializarParadasLineaC1();
                break;
        }
    }

    private void inicializarParadasLinea27() {
        paradas.add("🚌 Av. La Aeronáutica (Andal. Residencial)");
        coordenadas.add(new Coordenada(37.3925, -5.9201));

        paradas.add("🚌 Aeronautica Av. (Edif.Helios)");
        coordenadas.add(new Coordenada(37.3919, -5.9195));

        paradas.add("🚌 Av. Las Ciencias (Edif. Las Camelias)");
        coordenadas.add(new Coordenada(37.3903, -5.9181));

        paradas.add("🚌 Avda. Las Ciencias (Edif. Albéniz)");
        coordenadas.add(new Coordenada(37.3891, -5.9173));

        paradas.add("🚌 Avda. Las Ciencias (Edif. Entreflores)");
        coordenadas.add(new Coordenada(37.3880, -5.9162));

        paradas.add("🚌 Av. Las Ciencias (Doctor Madrazo)");
        coordenadas.add(new Coordenada(37.3872, -5.9151));

        paradas.add("🚌 Avenida de Las Ciencias (Osaka)");
        coordenadas.add(new Coordenada(37.3863, -5.9143));

        paradas.add("🚌 Alcalde Luis Uruñuela (Parque Alcosa)");
        coordenadas.add(new Coordenada(37.3849, -5.9132));

        paradas.add("🚌 Alcalde Luis Uruñuela (Pal. Congresos)");
        coordenadas.add(new Coordenada(37.3835, -5.9123));

        paradas.add("🚌 Alcalde Luis Uruñuela (Jardines Edén)");
        coordenadas.add(new Coordenada(37.3822, -5.9114));

        paradas.add("🚌 Alcalde Luis Uruñuela (Resid. Al Alba)");
        coordenadas.add(new Coordenada(37.3810, -5.9105));

        paradas.add("🚌 Alcalde Luis Uruñuela (Las Góndolas)");
        coordenadas.add(new Coordenada(37.3797, -5.9096));

        paradas.add("🚌 Montes Sierra (Se-30)");
        coordenadas.add(new Coordenada(37.3775, -5.9074));

        paradas.add("🚌 Montes Sierra (Santa Clara de Cuba)");
        coordenadas.add(new Coordenada(37.3758, -5.9059));

        paradas.add("🚌 Montes Sierra (Rafael Beca Mateos)");
        coordenadas.add(new Coordenada(37.3743, -5.9045));

        paradas.add("🚌 Montes Sierra (Tesalónica)");
        coordenadas.add(new Coordenada(37.3730, -5.9032));

        paradas.add("🚌 Avda. Andalucía (Los Arcos)");
        coordenadas.add(new Coordenada(37.3720, -5.9019));

        paradas.add("🚌 Luis Montoto (Marqués de Nervión)");
        coordenadas.add(new Coordenada(37.3707, -5.9006));

        paradas.add("🚌 Luis Montoto (Kansas City)");
        coordenadas.add(new Coordenada(37.3695, -5.8994));

        paradas.add("🚌 Luis Montoto (Cefiro)");
        coordenadas.add(new Coordenada(37.3683, -5.8982));

        paradas.add("🚌 Luis Montoto (San Benito)");
        coordenadas.add(new Coordenada(37.3670, -5.8968));

        paradas.add("🚌 Amador de Los Ríos (Puerta Carmona)");
        coordenadas.add(new Coordenada(37.3656, -5.8952));

        paradas.add("🚌 Amador de Los Ríos (Júpiter)");
        coordenadas.add(new Coordenada(37.3642, -5.8937));

        paradas.add("🚌 Gonzalo Bilbao (Puerta Osario)");
        coordenadas.add(new Coordenada(37.3628, -5.8923));

        paradas.add("🚌 Ponce de León");
        coordenadas.add(new Coordenada(37.3615, -5.8910));

        paradas.add("🚌 Imagen (Plaza Encarnación)");
        coordenadas.add(new Coordenada(37.3601, -5.8897));

        paradas.add("🚌 Campana (Sierpes)");
        coordenadas.add(new Coordenada(37.3588, -5.8883));
    }

    private void inicializarParadasLinea29() {
        paradas.add("🚌 Aux. Autovia Málaga (Torrecilla)");
        coordenadas.add(new Coordenada(37.4101, -5.9130));

        paradas.add("🚌 Aux. Autovia Málaga (Torrebermeja)");
        coordenadas.add(new Coordenada(37.4095, -5.9125));

        paradas.add("🚌 Aux. Autovía Málaga (Canal Bajo Guadal.)");
        coordenadas.add(new Coordenada(37.4087, -5.9118));

        paradas.add("🚌 Aux. Autovia Málaga (Alanís)");
        coordenadas.add(new Coordenada(37.4080, -5.9111));

        paradas.add("🚌 Glorieta Torreblanca");
        coordenadas.add(new Coordenada(37.4072, -5.9105));

        paradas.add("🚌 Andalucía Residencial (Edificio Málaga)");
        coordenadas.add(new Coordenada(37.4063, -5.9098));

        paradas.add("🚌 Andalucía Residencial");
        coordenadas.add(new Coordenada(37.4055, -5.9091));

        paradas.add("🚌 Autovía de Málaga (C. de Automovilismo)");
        coordenadas.add(new Coordenada(37.4048, -5.9085));

        paradas.add("🚌 Avda. Andalucía (Resid. Sta. Isabel)");
        coordenadas.add(new Coordenada(37.4039, -5.9076));

        paradas.add("🚌 Avenida de Andalucía (Tussam)");
        coordenadas.add(new Coordenada(37.4027, -5.9064));

        paradas.add("🚌 Avenida de Andalucía (Los Pájaros)");
        coordenadas.add(new Coordenada(37.4013, -5.9052));

        paradas.add("🚌 Av. Andalucía (Rda. Del Tamarguillo)");
        coordenadas.add(new Coordenada(37.4000, -5.9040));

        paradas.add("🚌 Avda. Andalucía (Los Arcos)");
        coordenadas.add(new Coordenada(37.3985, -5.9027));

        paradas.add("🚌 Avda. Cruz Del Campo (Tordesillas)");
        coordenadas.add(new Coordenada(37.3970, -5.9015));

        paradas.add("🚌 Gran Plaza");
        coordenadas.add(new Coordenada(37.3955, -5.9000));

        paradas.add("🚌 Eduardo Dato (Estadio Sánchez Pizjuan)");
        coordenadas.add(new Coordenada(37.3940, -5.8985));

        paradas.add("🚌 Av. San Fco. Javier (Av. Ramón y Cajal)");
        coordenadas.add(new Coordenada(37.3925, -5.8970));

        paradas.add("🚌 Enramadilla (Apeadero San Bernardo)");
        coordenadas.add(new Coordenada(37.3910, -5.8955));

        paradas.add("🚌 Prado de San Sebastián");
        coordenadas.add(new Coordenada(37.3895, -5.8940));
    }

    private void inicializarParadasLineaC1() {
        paradas.add("🚌 Av. Carlos V (Juzgados)");
        coordenadas.add(new Coordenada(37.3820, -5.9912));

        paradas.add("🚌 Avda. María Luisa (Teatro Lope de Vega)");
        coordenadas.add(new Coordenada(37.3795, -5.9895));

        paradas.add("🚌 Virgen de Luján (Sebastián Elcano)");
        coordenadas.add(new Coordenada(37.3760, -5.9863));

        paradas.add("🚌 Virgen de Luján (Juan Ramón Jiménez)");
        coordenadas.add(new Coordenada(37.3751, -5.9854));

        paradas.add("🚌 Virgen de Luján (Virgen de África)");
        coordenadas.add(new Coordenada(37.3742, -5.9845));

        paradas.add("🚌 Santa Fe (Niebla)");
        coordenadas.add(new Coordenada(37.3733, -5.9836));

        paradas.add("🚌 López de Gomara (Instituto Bécquer)");
        coordenadas.add(new Coordenada(37.3724, -5.9827));

        paradas.add("🚌 López de Gomara (San Martín de Porres)");
        coordenadas.add(new Coordenada(37.3715, -5.9818));

        paradas.add("🚌 Ronda de Triana (San Vicente de Paúl)");
        coordenadas.add(new Coordenada(37.3706, -5.9809));

        paradas.add("🚌 Ronda de Triana (Manuel Arellano)");
        coordenadas.add(new Coordenada(37.3697, -5.9800));

        paradas.add("🚌 Ronda Triana (C.D. Álvarez Gordón)");
        coordenadas.add(new Coordenada(37.3688, -5.9791));

        paradas.add("🚌 Jiménez de Quesada (Torre Sevilla)");
        coordenadas.add(new Coordenada(37.3679, -5.9782));

        paradas.add("🚌 Inca Garcilaso (Caixa Forum)");
        coordenadas.add(new Coordenada(37.3670, -5.9773));

        paradas.add("🚌 Inca Garcilaso (Francisco de Montesinos)");
        coordenadas.add(new Coordenada(37.3661, -5.9764));

        paradas.add("🚌 Américo Vespucio (Monasterio)");
        coordenadas.add(new Coordenada(37.3652, -5.9755));

        paradas.add("🚌 Américo Vespucio (Helipuerto)");
        coordenadas.add(new Coordenada(37.3643, -5.9746));

        paradas.add("🚌 Américo Vespucio (Fundacion Once)");
        coordenadas.add(new Coordenada(37.3634, -5.9737));

        paradas.add("🚌 Américo Vespucio (Jacques Cousteau)");
        coordenadas.add(new Coordenada(37.3625, -5.9728));

        paradas.add("🚌 Américo Vespucio (F. de Comunicación)");
        coordenadas.add(new Coordenada(37.3616, -5.9719));
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getParadas() {
        return paradas;
    }

    public List<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public Coordenada getCoordenadaDeParada(String nombreParada) {
        int index = paradas.indexOf(nombreParada);
        if (index >= 0 && index < coordenadas.size()) {
            return coordenadas.get(index);
        }
        return null;
    }
}
