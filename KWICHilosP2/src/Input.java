
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
    
    private Tube out;
    private String route;
    
    public Input( String route, Tube out) {
        this.out = out;       
        this.route = route;
    }

    @Override
    public void run() {
        try {
            // route del file PDF que deseas leer
            String routePDF = route;

            // Crear un objeto File con la route del file PDF
            File filePDF = new File(routePDF);

            // Verificar si el file PDF existe
            if (!filePDF.exists()) {
                System.err.println("PDF no existe.");
                return;
            }

            
            // Crear un objeto PDDocument para representar el document PDF
            PDDocument documentPDF = Loader.loadPDF(filePDF);
            Splitter splitter = new Splitter();

            List<PDDocument> pagePDF = splitter.split(documentPDF);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            for(PDDocument doc : pagePDF){
                String text = pdfTextStripper.getText(doc);
                out.addInformation(text);
            }
           
            documentPDF.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        out.setConnection(false);
       

       

    }

    public static ArrayList<String> getWord(String route){
        ArrayList<String> word = new ArrayList<String>();
        try(BufferedReader bf = new BufferedReader(new FileReader(route))){
            String s;
            while((s = bf.readLine())!=null) {
                if(!s.replace(" ", "").equals(""))
                word.add(s);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return word;
    }
    


}
