public class LecturaArchivo {
    
    private static String Ruta;
    private static String RutaLinux = "KWICHilos/src/";
    private static String RutaWindows = "src\\";
    private static String nombreArchivo;

    public static String rutaArchivo(String nombreArchivo){

        
         if(System.getProperty("os.name").contains("Windows")) {
            Ruta = RutaWindows + nombreArchivo+".txt";
        }else{
            Ruta = RutaLinux + nombreArchivo+".txt";
        }
        return Ruta;
    }

    
}
