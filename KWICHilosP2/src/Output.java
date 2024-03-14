
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Output {

    public static void writeInFile(Tube in, String routeOutput){
         try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(routeOutput));
            while(in.isInformation()){
                writer.write(in.getInformation());
                writer.newLine();
            }
            writer.close();
            System.out.println("El ArrayList se ha escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir el ArrayList en el archivo: " + e.getMessage());
        }
    }


}
