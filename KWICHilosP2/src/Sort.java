import java.util.ArrayList;

public class Sort extends Thread {
    private Tube in, out; 
    
    public Sort(Tube in, Tube out) {
        this.in = in;
        this.out = out;
    }
    public void run() {
        ArrayList<String> sortedList = new ArrayList<String>();

        while (in.isConnection() || in.isInformation()) {
            if (in.isInformation()) {
                String line = in.getInformation();
                boolean notAdded = true;
            if(sortedList.size()==0){
                sortedList.add(line);
            }else{
                for(int i = 0; i<sortedList.size();i++){
                    if(line.toLowerCase().compareTo(sortedList.get(i).toLowerCase())<0){
                        sortedList.add(i, line);
                        notAdded = false;
                        break;
                    }
                }
                if(notAdded){
                    sortedList.add(line);
                }
                
            }
                
            }
        }
        for(String line: sortedList){
            out.addInformation(line);
        }
        
        out.setConnection(false);
    }






}
