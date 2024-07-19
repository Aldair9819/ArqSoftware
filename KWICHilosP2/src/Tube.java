
import java.util.ArrayList;

public class Tube {
    private ArrayList<String> information = new ArrayList<String>();
    private boolean connection = true;

    public synchronized String getInformation() {
        String line_info = this.information.get(0);
        this.information.remove(0);
        return line_info;
    }

    public synchronized void addInformation(String informacion) {
        this.information.add(informacion);
    }

    public synchronized boolean isConnection() {
        return connection;
    }

    public synchronized void setConnection(boolean connection) {
        this.connection = connection;
    }

    public synchronized boolean isInformation(){
        return !information.isEmpty();
    }


    
}
