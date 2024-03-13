import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicia el programa");
        String rutaPDF = RutaArchivos.rutaEntrada("pdf");
        String rutaPalabra = RutaArchivos.rutaEntrada("txt");
        String rutaSalida = RutaArchivos.rutaSalida();
        
        ArrayList<String> word = Input.obtenerPalabras(rutaPalabra);

        Tube Input_WIP = new Tube();
        Tube WIP_Sort = new Tube();
        Tube Sort_Out = new Tube();

        Input input = new Input(rutaPDF,Input_WIP);
        WordInPage wip = new WordInPage(Input_WIP, WIP_Sort,word);
        Sort sortObj = new Sort(WIP_Sort, Sort_Out, word);
        
        input.start();
        wip.start();
        sortObj.start();

        try {
            sortObj.join(); // Espera a que el hilo termine
            Output.salidaEnArchivo(Sort_Out, rutaSalida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 

    }
    }

