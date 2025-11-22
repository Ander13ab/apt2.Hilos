import java.util.ArrayList;

public class Balsa {

    private String nombre;
    private int capacidad;
    private double tiempo;
    private ArrayList<Pasajero> pasajeros = new ArrayList<>();
    //private final ArrayListList<Pasajero> pasajeros = new ArrayList<>();

    public Balsa(String nombre, int capacidad, double tiempo) {
        this.nombre= nombre;
        this.capacidad = capacidad;
        this.tiempo = tiempo;
        //No se si hay que construirlo v
        this.pasajeros =new ArrayList<Pasajero>();
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNombre(){
        return nombre;
    }

    //Lo he cambiado a un boolean para que en el hilo de rescate pueda ver si es true o false
    public synchronized boolean agregarPasajeros(Pasajero p){
        if (pasajeros.size()< capacidad){
            pasajeros.add(p);
            return true;
        }
        return false;
    }


    public synchronized boolean estaLlena() {
        return pasajeros.size() == capacidad;
    }
    //Hace que el hilo de esa balsa esté en espera el tiempo de rescate que le corresponde
    public synchronized void descansar() {
        //no se por que en un try
        try { Thread.sleep((long) (tiempo * 1000)); } catch (Exception ignored) {}
    }

    //Parte del código es con ayuda de ChatGPT
    public synchronized void imprimirCarga() {
        System.out.println("Balsa " + nombre + " llena con " + capacidad + " pasajeros:");
        for (Pasajero p : pasajeros) {
            String tipoPers = "";
            switch (p.getPrioridad()){
                case 1:
                    tipoPers = "Niño";
                    break;
                case 2:
                    tipoPers = "Adulto";
                    break;
                case 3:
                    tipoPers = "Anciano";
                    break;
                case 4:
                    tipoPers = "Tripulación";
                    break;
            }
            System.out.println(" - ID " + p.getId() + " ( es un:  " + tipoPers + ")");
        }
        pasajeros.clear();
        System.out.println("--------------------------------");
    }
}
