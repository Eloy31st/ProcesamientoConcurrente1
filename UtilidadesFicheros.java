import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class UtilidadesFicheros{
    public static long sumaTransacciones(String fichero){
        long suma = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String linea = br.readLine();
            while(linea != null){
                suma += Long.parseLong(linea);
                linea = br.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();     
        }
        return suma;
    }

    public static void escribirResultado(String fichero, long result){
        try(FileWriter fw = new FileWriter(fichero)){
            fw.write(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}