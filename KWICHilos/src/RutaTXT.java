import java.io.File;
import java.util.ArrayList;

public class RutaTXT {
    private static String RutaLinux = System.getProperty("user.dir")+"/src/";
    private static String RutaWindows = System.getProperty("user.dir")+"\\src\\";


    private static ArrayList<String> obtenerArchivosTXT(String rutaCarpeta) {

        String nombreRemover = "salida";

        File carpeta = new File(rutaCarpeta);

        // Verificar si la ruta es un directorio
        if (!carpeta.isDirectory()) {
            System.out.println("La ruta no es un directorio.");
            return new ArrayList<String>(); // Devolver una ArrayList vacía si no es un directorio
        }

        // Obtener la lista de archivos en la carpeta
        File[] archivos = carpeta.listFiles();

        // Lista para almacenar nombres de archivos con extensión .txt
        ArrayList<String> archivosTxtList = new ArrayList<String>();

        // Verificar cada archivo
        for (File archivo : archivos) {
            if(archivo.getName().toLowerCase().endsWith(".txt"))
                archivosTxtList.add(archivo.getName());
            
        }

        // Remover elementos que contengan el nombre "salida"
        archivosTxtList.removeIf(nombre -> nombre.toLowerCase().contains(nombreRemover));

        return archivosTxtList;
    }

    public static String rutaSalida(){
        return Path()+"textoSalida.txt";
    }

    
    public static String rutaEntrada(){

        ArrayList<String> nombreArchivosTexto = new ArrayList<String>();

        nombreArchivosTexto = obtenerArchivosTXT(Path());
        
        String opcion = "";
        if(nombreArchivosTexto.size()==0){
            System.out.println("No hay archivos de texto en la carpeta");
            System.out.println("Saliendo del programa");
            System.exit(0);
        }

        while(true){
            System.out.println("Selecciona el archivo de entrada:");
            for(int i=0;i<nombreArchivosTexto.size();i++){
                System.out.println("->"+nombreArchivosTexto.get(i));
            }
            System.out.print("Opcion:");
            try{
                opcion = System.console().readLine();
                if(!opcion.contains(".txt")){
                    opcion += ".txt";
                }
                if(nombreArchivosTexto.contains(opcion)){
                    return Path()+opcion;
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
            return RutaWindows;
        }else{
            return RutaLinux;
        }
    }

}
