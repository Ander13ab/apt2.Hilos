import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Rescate implements Runnable{

    private final ArrayList<Balsa> balsas;
    private static Semaphore semaphore = new Semaphore(1);

    //Cambio el constructor que tenía por uno nuevo pasando como parámetro el array de balsas
    public Rescate(ArrayList<Balsa> balsas) {
        this.balsas = balsas;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    // Recorre los pasajeros buscando por su prioridad y los elimina, empezando por el 1 -> 4
    public static Pasajero sacarPorPrioridad() {
        try {
            semaphore.acquire();
            if (Barco.pasajeros.isEmpty()) {
                semaphore.release();
                return null;
            }
            for (int i = 1; i <= 4; i++) {
                for (int j = 0; j < Barco.pasajeros.size(); j++) {
                    if (Barco.pasajeros.get(j).getPrioridad() == i) {
                        semaphore.release();
                        return Barco.pasajeros.remove(j);
                    }
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
        semaphore.release();
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
