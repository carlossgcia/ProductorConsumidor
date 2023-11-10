public class ColaLimite {


    public static final int TAMANHO_MAXIMO = 4;
    public Palabra[] palabras = new Palabra[TAMANHO_MAXIMO];

    private int posicion = 0;

    public synchronized void ponConBloqueo(Palabra nuevoValor) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        pon(nuevoValor);

    }

    public synchronized void pon(Palabra  nuevoValor) {
        if (isFull())
            throw new RuntimeException("no se pueden poner mas palabras");
        else {
            palabras[++posicion] = nuevoValor;
            notifyAll();
        }
    }


    public synchronized Palabra quitaConBloqueo() throws InterruptedException {

        while (isEmpty()) {
            wait();
        }
        return quita();
    }

    public synchronized Palabra quita() {
        if (isEmpty())
            throw new RuntimeException("Nada que quitar");

        else
            notifyAll();
        return palabras[posicion--];

    }

    private boolean isEmpty() {
        return posicion == -1;
    }

    private boolean isFull() {
        return posicion == TAMANHO_MAXIMO -1;
    }

}
