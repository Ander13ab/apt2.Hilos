public class Rescate implements Runnable{

    private Thread rescateHilo =null;

    public Rescate(){
        rescateHilo =new Thread(this);
        rescateHilo.start();
    }
    @Override
    public void run() {
        while(!Barco.noHayPasajeros()){

        }
    }
}
