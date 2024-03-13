
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Input extends Thread {
    
    private Tube salida;
    private String ruta;
    
    public Input( String ruta, Tube salida) {
        this.salida = salida;       
        this.ruta = ruta;
    }

    @Override
    public void run() {
        try {
            // Ruta del archivo PDF que deseas leer
            String rutaPDF = ruta;

            // Crear un objeto File con la ruta del archivo PDF
            File archivoPDF = new File(rutaPDF);

            // Verificar si el archivo PDF existe
            if (!archivoPDF.exists()) {
                System.err.println("El archivo PDF no existe.");
                return;
            }

            
            // Crear un objeto PDDocument para representar el documento PDF
            PDDocument documentoPDF = Loader.loadPDF(archivoPDF);
            Splitter splitter = new Splitter();

            List<PDDocument> documentosPDF = splitter.split(documentoPDF);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            for(PDDocument doc : documentosPDF){
                String texto = pdfTextStripper.getText(doc);
                salida.addInformacion(texto);
            }
           
            documentoPDF.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        salida.setConexion(false);
       

       

    }

    public static ArrayList<String> obtenerPalabras(String Ruta){
        ArrayList<String> palabras = new ArrayList<String>();
        try(BufferedReader bf = new BufferedReader(new FileReader(Ruta))){
            String s;
            while((s = bf.readLine())!=null) {
                if(!s.replace(" ", "").equals(""))
                palabras.add(s);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return palabras;
    }
    


}
