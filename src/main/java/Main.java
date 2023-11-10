
public class Main {
    public static void main(String[] args) {
        // ESCENARIO
        ColaLimite buffer = new ColaLimite();

        // ACTORES
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread tProductor = new Thread(productor);
        Thread tConsumidor = new Thread(consumidor);
        tConsumidor.start();
        tProductor.start();


    }
}
