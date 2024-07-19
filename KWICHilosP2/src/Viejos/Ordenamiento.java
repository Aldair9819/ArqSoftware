package Viejos;
import java.util.ArrayList;

public class Ordenamiento {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hola"); 
        list.add("Gato");
        list.add("Lápiz");
        list.add("Manzana");
        list.add("Perro");
        list.add("Libro");
        list.add("Café");
        list.add("Teclado");
        
        ArrayList<String> listaOrdenada = sort(list);
        for(String word: listaOrdenada){
            System.out.println(word);
        }
        
        
        
        
        
        
        
        
    }

    private static ArrayList<String> sort(ArrayList<String> list){
        ArrayList<String> sortedList = new ArrayList<String>();
        for(String word:list){
            boolean notAdded = true;
            if(sortedList.size()==0){
                sortedList.add(word);
            }else{
                for(int i = 0; i<sortedList.size();i++){
                    if(word.compareTo(sortedList.get(i))<0){
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
