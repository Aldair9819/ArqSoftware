

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorPalabras  {

    public static ArrayList<String> obtenerPalabras(String Ruta){
        ArrayList<String> palabras = new ArrayList<String>();
        try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){
            String s;
            while((s = bf.readLine())!=null) {
                if(!s.replace(" ", "").equals(""))
                palabras.add(s);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return palabras;
    }




}
