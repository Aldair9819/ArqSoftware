import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicia el programa");
        String rutaPDF = RutaArchivos.rutaEntrada("pdf");
        String rutaPalabra = RutaArchivos.rutaEntrada("txt");
        String rutaSalida = RutaArchivos.rutaSalida();
        
        ArrayList<String> word = Input.obtenerPalabras(rutaPalabra);

        Tube Input_CS = new Tube();
        Tube CS_Sort = new Tube();
        Tube Sort_Out = new Tube();

        Input input = new Input(rutaPDF,Input_CS);
        WordInPage cs = new WordInPage(Input_CS, CS_Sort,word);
        Sort sortObj = new Sort(CS_Sort, Sort_Out, word);
        
        input.start();
        cs.start();
        sortObj.start();

        try {
            sortObj.join(); // Espera a que el hilo termine
            Output.salidaEnArchivo(Sort_Out, rutaSalida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    }

