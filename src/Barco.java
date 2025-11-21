import java.util.ArrayList;
import java.util.List;

public class Barco {

    static final List<Pasajero> pasajeros = new ArrayList<>();

    public Barco(List<Pasajero> pasajeros) {
        this.pasajeros.addAll(pasajeros);
    }

    //Agrego synchronized al método
    public  static boolean noHayPasajeros(){
        return pasajeros.isEmpty();
    }

    //Agrego synchronized al método
    public int pasajerosRestantes(){
        return pasajeros.size();
    }
}
