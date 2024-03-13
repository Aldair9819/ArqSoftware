import java.util.ArrayList;

public class WordInPage extends Thread {
    private Tube entrada; 
    private Tube salida;
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> initialWords;

    public WordInPage(Tube entrada, Tube salida, ArrayList<String> initialWords) {
        this.entrada = entrada;
        this.salida = salida;
        this.initialWords = initialWords;
    }

    @Override
    public void run() {
        for(String word:initialWords){
            words.add(word);
        }
        int pagina = 0;
        while (entrada.isConexion() || entrada.isInformacion()) {
            if (entrada.isInformacion()) {
                pagina++;
                String linea = entrada.getInformacion();
                for(String word: words){
                    if (linea.toLowerCase().contains(word.toLowerCase())) {
                        salida.addInformacion(word + "=" + pagina);
                    }
                }
            }
        }
        
        salida.setConexion(false);

       

    }





    
}
