import java.util.ArrayList;

public class CircularShift extends Thread {
    private String nombre = "Base";
    private ArrayList<String> lineas = new ArrayList<String>();

    @Override
    public void run() {
        while (true) {
            if(lineas != null){
                
            }
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLineas(ArrayList<String> lineas) {
        this.lineas = lineas;
    }



    
}
