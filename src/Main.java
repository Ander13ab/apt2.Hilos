import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Completar Codigo
        Balsa Acasta = new Balsa(1,0.5);
        Balsa Banff = new Balsa(2,1);
        Balsa Cadiz = new Balsa(3,2);
        Balsa Deimos = new Balsa(4,4);
        Balsa Expedicion = new Balsa(5,8);

        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        for (int i = 0; i < 352; i++) {
            int priority = (int) (Math.random() * 4) + 1;
            Pasajero pasajero = new Pasajero(i + 1, priority);
            pasajeros.add(pasajero);
        }
    }
}