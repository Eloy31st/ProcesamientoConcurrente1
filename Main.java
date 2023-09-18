import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        String[] depars = {"Comercio.txt", "Contabilidad.txt", "Gerencia.txt", "Informática.txt", "RecursosHumanos.txt"};
        Lanzador.lanzarProcesadores(depars);

        long sumaTotal = UtilidadesFicheros.obtenerSumaTransacciones(List.of(depars));
        UtilidadesFicheros.escribirResultado("Resultado_global.txt", sumaTotal);
    }
}
