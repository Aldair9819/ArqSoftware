

import java.io.File;
import java.util.ArrayList;

public class RouteFile {
    private static String routeLinux = System.getProperty("user.dir")+"/src/";
    private static String routeWindows = System.getProperty("user.dir")+"\\src\\";


    private static ArrayList<String> getFile(String rutaCarpeta, String extension) {

        String removeFilesWithName = "salida";

        File folder = new File(rutaCarpeta);

        // Verificar si la ruta es un directorio
        if (!folder.isDirectory()) {
            System.out.println("La ruta no es una carpeta.");
            return new ArrayList<String>(); // Devolver una ArrayList vacía si no es un directorio
        }

        // Obtener la lista de archivos en la carpeta
        File[] fileArray = folder.listFiles();

        // Lista para almacenar nombres de archivos con extensión .txt
        ArrayList<String> fileTXT = new ArrayList<String>();

        // Verificar cada archivo
        for (File file : fileArray) {
            if(file.getName().toLowerCase().endsWith("."+extension.toLowerCase()))
                fileTXT.add(file.getName());
            
        }

        // Remover elementos que contengan el nombre "salida"
        fileTXT.removeIf(nombre -> nombre.toLowerCase().contains(removeFilesWithName));

        return fileTXT;
    }

    public static String routeOutput(){
        return Path()+"textoSalida.txt";
    }

    
    public static String routeInput(String extension){

        ArrayList<String> nameFileTXT = new ArrayList<String>();

        nameFileTXT = getFile(Path(), extension);
        
        String option = "";
        if(nameFileTXT.size()==0){
            System.out.println("No hay archivos de texto en la carpeta");
            System.out.println("Saliendo del programa");
            System.exit(0);
        }

        while(true){
            System.out.println("Selecciona el archivo de entrada:");
            for(int i=0;i<nameFileTXT.size();i++){
                System.out.println("->"+nameFileTXT.get(i));
            }
            System.out.print("Opcion:");
            try{
                option = System.console().readLine();
                if(!option.contains("."+extension.toLowerCase())){
                    option += "."+extension.toLowerCase();
                }
                if(nameFileTXT.contains(option)){
                    System.out.println();
                    return Path()+option;
                }else{
                    System.out.println("Opcion invalida\n");
                    
                }
            }catch(Exception e){
                System.out.println("Opcion invalida");
            }
        }
        

    }

    private static String Path(){
        if(System.getProperty("os.name").contains("Windows")) {
            return routeWindows;
        }else{
            return routeLinux;
        }
    }

}
