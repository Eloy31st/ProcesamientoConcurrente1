import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {
    public static void lanzarProcesadores(String[] archivos) {
        ExecutorService executorService = Executors.newFixedThreadPool(archivos.length);

        for (String archivo : archivos) {
            executorService.execute(new ProcesadorContabilidad(archivo));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            
        }
    }
}