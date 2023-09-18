package Metodos;
import java.util.List;

public class ProcesadorContabilidad implements Runnable {
    private String archivo;

    public ProcesadorContabilidad(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void run() {
        List<String> archivos = List.of(archivo);
        long sumaTransacciones = UtilidadesFicheros.obtenerSumaTransacciones(archivos);
        UtilidadesFicheros.escribirResultado(archivo + ".res", sumaTransacciones);
    }
}