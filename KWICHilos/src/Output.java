import java.io.BufferedWriter;
import java.io.FileWriter;
public class Output extends Thread{

    private String ruta ;
    private Tube entrada;

    public Output(Tube entrada, String ruta){
        this.entrada = entrada;
        this.ruta = ruta;

    }
    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
            while (entrada.isConexion() || entrada.isInformacion()) {
                if (entrada.isInformacion()) {
                    String info = entrada.getInformacion();
                    writer.write(info);
                    writer.newLine(); // Agrega una nueva línea después de cada elemento
                }
            }
            writer.close();
            System.out.println("El ArrayList se ha escrito correctamente en el archivo.");
        } catch (Exception e) {
            System.err.println("Error al escribir el ArrayList en el archivo: " + e.getMessage());
        }
    }
}
