public class ProcesadorContabilidad implements Runnable {
    private String nombreArchivo;

    public ProcesadorContabilidad(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void run() {
        long suma = UtilidadesFicheros.sumaTransacciones(nombreArchivo);
        UtilidadesFicheros.escribirResultado(nombreArchivo + ".res", suma);
    }
}