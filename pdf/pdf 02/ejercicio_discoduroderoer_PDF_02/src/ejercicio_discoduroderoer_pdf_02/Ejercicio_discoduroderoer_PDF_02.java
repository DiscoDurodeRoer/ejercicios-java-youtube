package ejercicio_discoduroderoer_pdf_02;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_discoduroderoer_PDF_02 {

    public static void main(String[] args) {

        File file = new File("hello_world.pdf");

        try (PdfWriter pdfWriter = new PdfWriter(file)) {

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            Paragraph p = new Paragraph("Hello world");

            document.add(p);

            document.close();
            pdfDocument.close();
            
            System.out.println("PDF creado");
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
