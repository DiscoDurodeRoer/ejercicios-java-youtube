package ejercicio_discoduroderoer_pdf_01;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_discoduroderoer_PDF_01 {

    public static void main(String[] args) {

        try {
            Document document = new Document();
            String destino = "hello_world.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(destino));
            document.open();
            
            Phrase p = new Phrase("Hola mundo");
            document.add(p);
            
            document.close();
            
            System.out.println("Creado el PDF");
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Ejercicio_discoduroderoer_PDF_01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
