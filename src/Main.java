import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Completar Codigo
        Balsa b1 = new Balsa("Acasta",1,0.5);
        Balsa b2 = new Balsa("Banff",2,1);
        Balsa b3 = new Balsa("Cadiz",3,2);
        Balsa b4 = new Balsa("Deimos",4,4);
        Balsa b5 = new Balsa("Expedicion",5,8);

        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        for (int i = 0; i < 352; i++) {
            int priority = (int) (Math.random() * 4) + 1;
            Pasajero pasajero = new Pasajero(i + 1, priority);
            pasajeros.add(pasajero);
        }
    }
}