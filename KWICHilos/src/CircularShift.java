
public class CircularShift extends Thread {
    private Tube entrada; 
    private Tube salida;
    

    public CircularShift(Tube entrada, Tube salida) {
        this.entrada = entrada;
        this.salida = salida;        
    }

    @Override
    public void run() {
        while (entrada.isConexion() || entrada.isInformacion()) {
            if (entrada.isInformacion()) {
                String linea = entrada.getInformacion();
                String[] palabras = linea.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    String nuevaLinea = "";
                    for (int j = i; j < palabras.length; j++) {
                        nuevaLinea += palabras[j] + " ";
                    }
                    for (int j = 0; j < i; j++) {
                        nuevaLinea += palabras[j] + " ";
                    }
                    salida.addInformacion(nuevaLinea);
                }
            }
        }
        
        salida.setConexion(false);

       

    }





    
}
