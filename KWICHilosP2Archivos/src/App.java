import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        
        
        System.out.println("Inicia el programa");
        String routeFiles = "src/Archivos";
        String routeWord = RouteFile.routeInput("txt");
        String routeOutput = RouteFile.routeOutput();
        
        ArrayList<String> File = RouteFile.getNameFile(routeFiles);
        ArrayList<String> word = Input.getWord(routeWord);
        Tube Input_WIP = new Tube();
        Tube WIP_Sort = new Tube();
        Tube Sort_Out = new Tube();

        Input input = new Input(routeFiles,Input_WIP);
        WordInPage wip = new WordInPage(Input_WIP, WIP_Sort,word, File);
        Sort sortObj = new Sort(WIP_Sort, Sort_Out);
        
        input.start();
        wip.start();
        sortObj.start();

        try {
            sortObj.join(); //Espera a que el hilo termine
            Output.writeInFile(Sort_Out, routeOutput);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //*/

    }   
    }

