import java.util.ArrayList;

public class Tube {
    private ArrayList<String> informacion = new ArrayList<String>();
    private boolean conexion = true;

    public synchronized String getInformacion() {
        String informacion = this.informacion.get(0);
        this.informacion.remove(0);
        return informacion;
    }

    public synchronized void addInformacion(String informacion) {
        this.informacion.add(informacion);
    }

    public synchronized boolean isConexion() {
        return conexion;
    }

    public synchronized void setConexion(boolean conexion) {
        this.conexion = conexion;
    }

    public synchronized boolean isInformacion(){
        return !informacion.isEmpty();
    }
    
}
