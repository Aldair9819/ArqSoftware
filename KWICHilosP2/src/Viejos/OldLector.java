package Viejos;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class OldLector {
    
    public static void main(String[] args) {
        try {
            // Ruta del archivo PDF que deseas leer
            String rutaPDF = "src\\harry-potter-1.pdf";

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
            String texto1 = pdfTextStripper.getText(documentosPDF.get(2));
            System.out.println("Titulo: " + texto1);
            /* 
            // Crear un objeto PDFTextStripper para extraer texto del PDF
            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            // Obtener el texto del documento PDF
            String textoPDF = pdfTextStripper.getText(documentoPDF);

            // Imprimir el texto en la consola
            System.out.println("Texto extraído del PDF:\n" + textoPDF);
            //*/
            // Cerrar el documento PDF
            documentoPDF.close();
            // Guardar el texto en un archivo de texto
            //guardarTextoEnArchivo(textoPDF, "texto_extraido.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* 
    private static void guardarTextoEnArchivo(String texto, String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo);
            writer.write(texto);
            writer.close();
            System.out.println("Texto guardado en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
}
