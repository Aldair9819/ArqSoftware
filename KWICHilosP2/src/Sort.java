

import java.util.ArrayList;
import java.util.HashMap;

public class Sort extends Thread {
    private Tube entrada, salida; 
    private HashMap<String, ArrayList<String>> wordLocation = new HashMap<String, ArrayList<String>>();
    private ArrayList<String> initialWords;
    
    public Sort(Tube entrada, Tube salida, ArrayList<String> initialWords) {
        this.entrada = entrada;
        this.salida = salida;
        this.initialWords = initialWords;
        
    }
    public void run() {
        ArrayList<String> sortedList = this.sortMethod(initialWords);
        for(String word:sortedList){
            wordLocation.put(word, new ArrayList<String>());
        }

        while (entrada.isConexion() || entrada.isInformacion()) {
            if (entrada.isInformacion()) {
                String linea = entrada.getInformacion();
                String[] lineaSplit = linea.split("=");
                if(wordLocation.containsKey(lineaSplit[0])){
                    wordLocation.get(lineaSplit[0]).add(lineaSplit[1]);
                }
            }
        }
        
        for(String word:sortedList){
            salida.addInformacion(word + "->" + wordLocation.get(word) );
        }
    }


    private ArrayList<String> sortMethod(ArrayList<String> lista){
        ArrayList<String> sortedList = new ArrayList<String>();
        for(String word:lista){
            boolean notAdded = true;
            if(sortedList.size()==0){
                sortedList.add(word);
            }else{
                for(int i = 0; i<sortedList.size();i++){
                    if(word.toLowerCase().compareTo(sortedList.get(i).toLowerCase())<0){
                        sortedList.add(i, word);
                        notAdded = false;
                        break;
                    }
                }
                if(notAdded){
                    sortedList.add(word);
                }
                
            }
        }
        return sortedList;
    }




}
