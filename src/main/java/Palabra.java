public class Palabra {

    int identificador;
    String estado;
    String mensaje;

    public Palabra(int identificador, String estado, String mensaje) {
        this.identificador = identificador;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Palabra { " +
                "identificador = " + identificador +
                ", estado = " + estado +
                ", mensaje = " + mensaje +
                " }";
    }
}
