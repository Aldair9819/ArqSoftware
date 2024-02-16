import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input extends Thread {
    String RutaLinux = "KWICHilos/src/texto.txt";
    String RutaWindows = "src\\texto.txt";
    String Ruta;
    private Tube salida;

   
    public Input(Tube salida) {
        this.salida = salida;
    }

    @Override
    public void run() {
        if(System.getProperty("os.name").contains("Linux")) {
            Ruta = RutaLinux;
        } else if(System.getProperty("os.name").contains("Windows")) {
            Ruta = RutaWindows;
        } else {
            System.out.println("Otro");
        }


        try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){
            String s;
            while((s = bf.readLine())!=null) {
                salida.addInformacion(s);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        salida.setConexion(false);
        
        

    }



}
