import java.util.ArrayList;

public class WordInPage extends Thread {
    private Tube in; 
    private Tube out;
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> initialWords;

    public WordInPage(Tube in, Tube out, ArrayList<String> initialWords) {
        this.in = in;
        this.out = out;
        this.initialWords = initialWords;
    }

    @Override
    public void run() {
        for(String word:initialWords){
            words.add(word);
        }
        int numberPage = 0;
        while (in.isConnection() || in.isInformation()) {
            if (in.isInformation()) {
                numberPage++;
                String line = in.getInformation();
                for(String word: words){
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        out.addInformation(word + "|" + numberPage);
                    }
                }
            }
        }
        
        out.setConnection(false);

       

    }





    
}
