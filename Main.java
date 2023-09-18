import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona la ruta de los archivos como argumentos.");
            return;
        }

        Lanzador.lanzarProcesadores(args);

        // Calcular el resultado global
        long sumaTotal = UtilidadesFicheros.obtenerSumaTransacciones(List.of(args));
        UtilidadesFicheros.escribirResultado("Resultado_global.txt", sumaTotal);
    }
}
