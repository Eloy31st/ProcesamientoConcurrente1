import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Main <directorios>");
            System.exit(1);
        }

        for (String directorio : args) {
            File dir = new File(directorio);
            if (dir.isDirectory()) {
                File[] archivos = dir.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        if (archivo.isFile()) {
                            try {
                                // Ejecutar el procesador para cada archivo como un proceso independiente
                                ProcessBuilder processBuilder = new ProcessBuilder("java", "ProcesadorContabilidad", archivo.getName());
                                processBuilder.inheritIO();
                                Process proceso = processBuilder.start();
                                proceso.waitFor();
                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        // Calcular el resultado global después de que todos los procesos hayan terminado
        Lanzador.calcularResultadoGlobal(args);
    }
}
