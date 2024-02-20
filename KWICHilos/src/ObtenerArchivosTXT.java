import java.io.File;
import java.util.ArrayList;

public class ObtenerArchivosTXT {

    private static String Ruta;
    private static String RutaLinux = "KWICHilos/src/";
    private static String RutaWindows = "src\\";
    /* 
    public static void main(String[] args) {
        // Ruta de la carpeta que deseas verificar
        String rutaCarpeta = "src";

        // Obtener nombres de archivos con extensión .txt
        List<String> archivosTxt = obtenerArchivosTXT(rutaCarpeta);

        // Imprimir los nombres de archivos obtenidos
        System.out.println("Archivos con extensión .txt:");
        for (String archivo : archivosTxt) {
            System.out.println(archivo);
        }
    }
    */

    public static ArrayList<String> obtenerArchivosTXT(String rutaCarpeta) {
        String nombreRemover = "salida";

        File carpeta = new File(rutaCarpeta);

        // Verificar si la ruta es un directorio
        if (!carpeta.isDirectory()) {
            System.out.println("La ruta no es un directorio.");
            return new ArrayList<>(); // Devolver una ArrayList vacía si no es un directorio
        }

        // Obtener la lista de archivos en la carpeta
        File[] archivos = carpeta.listFiles();

        // Lista para almacenar nombres de archivos con extensión .txt
        ArrayList<String> archivosTxtList = new ArrayList<String>();

        // Verificar cada archivo
        for (File archivo : archivos) {
            if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt")) {
                archivosTxtList.add(archivo.getName());
            }
        }

        // Remover elementos que contengan el nombre "salida"
        archivosTxtList.removeIf(nombre -> nombre.toLowerCase().contains(nombreRemover));

        return archivosTxtList;
    }

    public static ArrayList<String> nombresEntrada(){
        ArrayList<String> nombreArchivosTexto = obtenerArchivosTXT("src");
        nombreArchivosTexto.removeIf(nombre -> nombre.toLowerCase().contains("salida"));
        return nombreArchivosTexto;
    }

    public static ArrayList<String> nombresSalida(){
        ArrayList<String> nombreArchivosTexto = obtenerArchivosTXT("src");
        nombreArchivosTexto.removeIf(nombre -> !nombre.toLowerCase().contains("salida"));
        return nombreArchivosTexto;
    }

    public static String rutaEntrada(){
        ArrayList<String> nombreArchivosTexto = obtenerArchivosTXT("src");
        int opcion = 0;
        while(true){
            System.out.println("Selecciona el archivo de entrada:");
            for(int i=0;i<nombreArchivosTexto.size();i++){
                System.out.println(i+"-"+nombreArchivosTexto.get(i));
            }
            System.out.println("Opcion:");
            try{
                opcion = Integer.parseInt(System.console().readLine());
                if(opcion>=0 && opcion<nombreArchivosTexto.size()){
                    if(System.getProperty("os.name").contains("Windows")) {
                        Ruta = RutaWindows;
                    }else{
                        Ruta = RutaLinux;
                    }
                    return Ruta+nombreArchivosTexto.get(opcion);
                }else{
                    System.out.println("Opcion invalida\n");
                    
                }
            }catch(Exception e){
                System.out.println("Opcion invalida");
            }
        }

    }
}
