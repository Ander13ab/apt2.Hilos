import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //cambio la creación de balsas para que sea un array de ellas
        ArrayList<Balsa> balsas = new ArrayList<>();
        balsas.add(new Balsa("Acasta",1,0.5));
        balsas.add(new Balsa("Banff",2,1));
        balsas.add(new Balsa("Cadiz",3,2));
        balsas.add(new Balsa("Deimos",4,4));
        balsas.add(new Balsa("Expedicion",5,8));

        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        for (int i = 0; i < 352; i++) {
            int priority = (int) (Math.random() * 4) + 1;
            Pasajero pasajero = new Pasajero(i + 1, priority);
            pasajeros.add(pasajero);
        }
        //Creo el barco con el array de pasajeros
        new Barco(pasajeros);

        Thread rescate = new Thread(new Rescate(balsas));
        rescate.start();
    }
}