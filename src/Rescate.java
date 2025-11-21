import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rescate implements Runnable{

    //chatGPT
    private final ArrayList<Balsa> balsas;
    //Cambio el constructpor que tenía por uno nuevo pasando como parámetro el array de balsas
    public Rescate(ArrayList<Balsa> balsas) {
        this.balsas = balsas;
    }

    //chatGPT
    // Recorre los pasajeros buscando por su prioridad y los elimina, empezando por el 1 -> 4
    public synchronized static Pasajero sacarPorPrioridad() {
        if (Barco.pasajeros.isEmpty())
            return null;
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < Barco.pasajeros.size(); j++) {
                if (Barco.pasajeros.get(j).getPrioridad() == i) {
                    return Barco.pasajeros.remove(i);
                }
            }
        }
        return null;
    }
    @Override
    public void run() {
        while (!Barco.noHayPasajeros()) {
            for (Balsa b : balsas) {
                Pasajero p = sacarPorPrioridad();
                if (b.agregarPasajeros(p) && b.estaLlena()) {
                    b.imprimirCarga();
                    b.descansar();
                }
            }
        }
    }
}
