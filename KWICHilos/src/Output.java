import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
    private static String ruta;

    public static void salidaEnArchivo(Tube entrada, String rutaSalida){
        ruta = rutaSalida;

         try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
            while(entrada.isInformacion()){
                writer.write(entrada.getInformacion());
                writer.newLine();
            }
            writer.close();
            System.out.println("El ArrayList se ha escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir el ArrayList en el archivo: " + e.getMessage());
        }
    }

}
