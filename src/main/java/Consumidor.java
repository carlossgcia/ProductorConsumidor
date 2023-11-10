
public class Consumidor implements Runnable {
    ColaLimite buffer;

    public Consumidor(ColaLimite buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        esperarUnSegundo();
        while (true) {
            esperarUnSegundo();
            try {
                Palabra leido = this.buffer.quitaConBloqueo();
                System.out.println("el consumidor lee: " + leido.toString());
            } catch (InterruptedException e) {
                continue;

            }
        }

    }

    private static void esperarUnSegundo() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

