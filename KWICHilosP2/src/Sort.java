

import java.util.ArrayList;
import java.util.HashMap;

public class Sort extends Thread {
    private Tube entrada, salida; 
    HashMap<String, ArrayList<String>> palabras = new HashMap<String, ArrayList<String>>();
    ArrayList<String> initialWords;
    
    public Sort(Tube entrada, Tube salida, ArrayList<String> initialWords) {
        this.entrada = entrada;
        this.salida = salida;
        this.initialWords = initialWords;
        
    }
    public void run() {
        ArrayList<String> sortedList = SortMethod(initialWords);
        for(String word:sortedList){
            palabras.put(word, new ArrayList<String>());
        }

        while (entrada.isConexion() || entrada.isInformacion()) {
            if (entrada.isInformacion()) {
                String linea = entrada.getInformacion();
                String[] lineaSplit = linea.split("=");
                if(palabras.containsKey(lineaSplit[0])){
                    palabras.get(lineaSplit[0]).add(lineaSplit[1]);
                }
            }
        }

        for (String key : palabras.keySet()) {
            salida.addInformacion(key+"->"+palabras.get(key));
        }

    }


    private static ArrayList<String> SortMethod(ArrayList<String> lista){
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
