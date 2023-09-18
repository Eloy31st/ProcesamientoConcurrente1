import java.util.List;

import Metodos.Lanzador;
import Metodos.UtilidadesFicheros;

public class Main {
    
    public static void main(String[] args) {
        String[] depars = {"Comercio.txt", "Contabilidad.txt", "Gerencia.txt", "Informática.txt", "RecursosHumanos.txt"};
        Lanzador.lanzarProcesadores(depars);
        while (Lanzador.hayProcesadoresActivos()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long sumaTotal = UtilidadesFicheros.obtenerSumaTransacciones(List.of(depars));
        UtilidadesFicheros.escribirResultado("Resultado_global.txt", sumaTotal);
    }
}
