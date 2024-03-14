

import java.util.ArrayList;
import java.util.HashMap;

public class Sort extends Thread {
    private Tube in, out; 
    private HashMap<String, ArrayList<String>> wordLocation = new HashMap<String, ArrayList<String>>();
    private ArrayList<String> initialWord;
    
    public Sort(Tube in, Tube out, ArrayList<String> initialWord) {
        this.in = in;
        this.out = out;
        this.initialWord = initialWord;
        
    }
    public void run() {
        ArrayList<String> sortedList = this.sortMethod(initialWord);
        for(String word:sortedList){
            wordLocation.put(word, new ArrayList<String>());
        }

        while (in.isConnection() || in.isInformation()) {
            if (in.isInformation()) {
                String line = in.getInformation();
                String[] lineSplit = line.split("\\|");
                if(wordLocation.containsKey(lineSplit[0])){
                    wordLocation.get(lineSplit[0]).add(lineSplit[1]);
                }
            }
        }
        
        for(String word:sortedList){
            out.addInformation(word + "->" + wordLocation.get(word) );
        }
    }


    private ArrayList<String> sortMethod(ArrayList<String> list){
        ArrayList<String> sortedList = new ArrayList<String>();
        for(String word:list){
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
