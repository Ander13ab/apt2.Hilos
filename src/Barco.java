import java.util.ArrayList;
import java.util.List;

public class Barco {

    private static final List<Pasajero> pasajeros = new ArrayList<>();

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros.addAll(pasajeros);
    }

    public static boolean noHayPasajeros(){
        return !pasajeros.isEmpty();
    }

    public int pasajerosRestantes(){
        return pasajeros.size();
    }
}
