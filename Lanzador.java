import java.io.File;

public class Lanzador {
    public static void calcularResultadoGlobal(String[] args) {
        long resultadoGlobal = 0;
        for (String directorio : args) {
            File dir = new File(directorio);
            if (dir.isDirectory()) {
                File[] archivosRes = dir.listFiles((dir1, nombre) -> nombre.endsWith(".res"));
                if (archivosRes != null) {
                    for (File archivoRes : archivosRes) {
                        if (archivoRes.isFile()) {
                            resultadoGlobal += UtilidadesFicheros.sumaTransacciones(archivoRes.getName());
                        }
                    }
                }
            }
        }

        // Escribir el resultado global en "Resultado_global.txt"
        UtilidadesFicheros.escribirResultado("Resultado_global.txt", resultadoGlobal);
    }
}
