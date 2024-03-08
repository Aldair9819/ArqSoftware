import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Input extends Thread {
    private String Ruta;
    private Tube salida;
  
    public Input(Tube salida, String Ruta) {
        this.salida = salida;
        this.Ruta = Ruta;
    }

    @Override
    public void run() {
        try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){
            String s;
            while((s = bf.readLine())!=null) {
                if(!s.replace(" ", "").equals(""))
                salida.addInformacion(s);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        salida.setConexion(false);
    }
}
