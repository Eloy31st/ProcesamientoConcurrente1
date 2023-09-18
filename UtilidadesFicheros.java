import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UtilidadesFicheros {

    public static long obtenerSumaTransacciones(List<String> archivos) {
        long sumaTotal = 0;

        for (String archivo : archivos) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    long transactionAmount = Long.parseLong(line);
                    sumaTotal += transactionAmount;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sumaTotal;
    }

    public static void escribirResultado(String archivo, long resultado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(String.valueOf(resultado));
            writer.newLine(); // Agregar una nueva línea para el siguiente resultado
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}