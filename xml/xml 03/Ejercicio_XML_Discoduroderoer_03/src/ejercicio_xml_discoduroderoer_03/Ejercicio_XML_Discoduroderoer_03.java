package ejercicio_xml_discoduroderoer_03;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Ejercicio_XML_Discoduroderoer_03 {

    public static void main(String[] args) {

        try {
            SAXBuilder builder = new SAXBuilder();
            File xml = new File("concesionario.xml");

            Document document = builder.build(xml);
            
            Element root = document.getRootElement();
            
            List<Element> list = root.getChildren("coches");
            
            System.out.println("Matricula\tMarca\tPrecio");
            
            for (int i = 0; i < list.size(); i++) {
                
                Element coche = list.get(i);
                
                List<Element> valores_coche = coche.getChildren();
           
                
                for (int j = 0; j < valores_coche.size(); j++) {
                    
                    Element campo = valores_coche.get(j);
                    
                    String matricula = campo.getChildTextTrim("matricula");
                    String marca = campo.getChildTextTrim("marca");
                    String precio = campo.getChildTextTrim("precio");
                    
                    System.out.println(matricula + "\t\t" + marca + "\t" + precio);
                    
                }
            }
            
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(Ejercicio_XML_Discoduroderoer_03.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
