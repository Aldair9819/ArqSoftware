import java.util.ArrayList;

public class Input extends Thread {
    private ArrayList<String> lineas = new ArrayList<String>();
    private String nombre = "Base";
   
    @Override
    public void run() {
        /* 
        for(int i=0;i<200;i++){
            lineas.add("Linea"+i);
            System.out.println("Funcion entrada: Linea"+i);
        }
        */
        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Funcion entrada: "+nombre);
        }

    }

    public void setLineas(ArrayList<String> lineas) {
        this.lineas = lineas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
