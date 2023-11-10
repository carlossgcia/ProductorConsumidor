public class Productor implements Runnable {
    ColaLimite buffer;
    Palabra[] palabras = {
            new Palabra(1, "produccion", "Patata"),
            new Palabra(2, "agotado", "Boniato"),
            new Palabra(3, "produccion", "Cebolla"),
            new Palabra(4, "produccion", "Calabaza"),
            new Palabra(5, "produccion", "Zanahoria"),
            new Palabra(6, "produccion", "Berenjena"),
            new Palabra(7, "produccion", "Tomate"),
            new Palabra(8, "produccion", "Manzana"),
            new Palabra(9, "produccion", "Tortilla"),
            new Palabra(10, "produccion", "Arroz"),
            new Palabra(11,"produccion","Pescado")
    };

    public Productor(ColaLimite buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int posicion;

        while (true) {
            esperarUnSegundo();
            try {
                posicion = (int) (Math.random() * 11);
                Palabra palabraNueva = palabras[posicion];

                this.buffer.ponConBloqueo(palabraNueva);
                System.out.println("el productor genera " + palabraNueva.toString());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
