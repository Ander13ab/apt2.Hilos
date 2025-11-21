import java.util.ArrayList;

public class Balsa {

    private String nombre;
    private int capacidad;
    private double tiempo;
    ArrayList<Pasajero> pasajerosBalsa = new ArrayList<>();

    public Balsa(String nombre, int capacidad, double tiempo) {
        this.nombre= nombre;
        this.capacidad = capacidad;
        this.tiempo = tiempo;
        this.pasajerosBalsa =new ArrayList<Pasajero>();
    }

    public ArrayList<Pasajero> getPasajerosBalsa() {
        return pasajerosBalsa;
    }

    public void setPasajerosBalsa(ArrayList<Pasajero> pasajerosBalsa) {
        this.pasajerosBalsa = pasajerosBalsa;
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

    public void agregarPasajeros(){
        for (int i = 0; i < getCapacidad(); i++) {
            System.out.println(getNombre());
            //Añadir pasajeros del barco al arraylist de pasajerosBalsa para mostrarlos
            System.out.println(pasajerosBalsa.toString());
        }
    }

}
