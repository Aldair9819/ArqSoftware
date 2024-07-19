import java.util.ArrayList;
import java.util.HashMap;

public class WordInPage extends Thread {
    private Tube in; 
    private Tube out;
    private HashMap<String,ArrayList<String>> word_page = new HashMap<String,ArrayList<String>>();
    private ArrayList<String> initialWords;
    private ArrayList<String> positionOfFile;

    public WordInPage(Tube in, Tube out, ArrayList<String> initialWords, ArrayList<String> positionOfFile) {
        this.in = in;
        this.out = out;
        this.initialWords = initialWords;
        this.positionOfFile = positionOfFile;
    }

    @Override
    public void run() {
        for(String word:initialWords){
            word_page.put(word, new ArrayList<String>());
        }
        int numberPage = -1;
        while (in.isConnection() || in.isInformation()) {
            if (in.isInformation()) {
                numberPage++;
                String line = in.getInformation();
                for(String word: initialWords){
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        word_page.get(word).add(positionOfFile.get(numberPage)+"");
                    }
                }
            }
        }
        for(String word: initialWords){
            out.addInformation(word + "-->" + word_page.get(word).toString());
        }
        
        out.setConnection(false);

       

    }





    
}
