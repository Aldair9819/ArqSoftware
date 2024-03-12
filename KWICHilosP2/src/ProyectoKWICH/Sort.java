package ProyectoKWICH;
import java.util.ArrayList;

public class Sort extends Thread {
    private Tube entrada, salida; 
    private ArrayList<String> salidaA = new ArrayList<String>();
    
    public Sort(Tube entrada, Tube salida) {
        this.entrada = entrada;
        this.salida = salida;
    }
    public void run() {
        while (entrada.isConexion() || entrada.isInformacion()) {
            if (entrada.isInformacion()) {
                boolean swapped;
                while (entrada.isInformacion()) {
                    salidaA.add(entrada.getInformacion());
                }

                int n = salidaA.size();

                do {
                    swapped = false;
                    for (int i = 1; i < n; i++) {
                        // Si la oración actual es mayor que la anterior, las intercambiamos
                        if (salidaA.get(i - 1).toLowerCase().compareTo(salidaA.get(i).toLowerCase()) > 0) {
                            String temp = salidaA.get(i - 1);
                            salidaA.set(i - 1, salidaA.get(i));
                            salidaA.set(i, temp);
                            swapped = true;
                        }
                    }
                    n--;
                } while (swapped);
            }
        }
        while(!salidaA.isEmpty()){
            salida.addInformacion(salidaA.get(0));
            salidaA.remove(0);
        }
    }




}
