import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Input extends Thread {
    
    private Tube out;
    private String route;
    
    public Input( String route, Tube out) {
        this.out = out;       
        this.route = route;
    }

    @Override
    public void run() {
        
        readFiles();

       

    }

    public static ArrayList<String> getWord(String route){
        ArrayList<String> word = new ArrayList<String>();
        try(BufferedReader bf = new BufferedReader(new FileReader(route))){
            String s;
            while((s = bf.readLine())!=null) {
                if(!s.replace(" ", "").equals(""))
                word.add(s);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return word;
    }

    private void readFiles(){
        ArrayList<String> archivo = RouteFile.getNameFile(route);
        for (String string : archivo) {
            out.addInformation(string);
        }
        out.setConnection(false);

    }

   

}
