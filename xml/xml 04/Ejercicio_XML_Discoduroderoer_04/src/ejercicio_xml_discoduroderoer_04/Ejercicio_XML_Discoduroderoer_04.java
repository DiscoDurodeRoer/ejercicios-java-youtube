package ejercicio_xml_discoduroderoer_04;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Ejercicio_XML_Discoduroderoer_04 {

    public static void main(String[] args) {

        try {
            Element concesionario = new Element("concesionario");
            Document doc = new Document(concesionario);

            Element coches = new Element("coches");
            concesionario.addContent(coches);

            // Coche 1
            Element coche = new Element("coche");

            Element matricula = new Element("matricula");
            matricula.setText("1111AAA");
            Element marca = new Element("marca");
            marca.setText("AUDI");
            Element precio = new Element("precio");
            precio.setText("30000");

            coche.addContent(matricula);
            coche.addContent(marca);
            coche.addContent(precio);

            coches.addContent(coche);

            // Coche 2
            coche = new Element("coche");

            matricula = new Element("matricula");
            matricula.setText("2222BBB");
            marca = new Element("marca");
            marca.setText("SEAT");
            precio = new Element("precio");
            precio.setText("10000");

            coche.addContent(matricula);
            coche.addContent(marca);
            coche.addContent(precio);

            coches.addContent(coche);

            // Coche 3
            coche = new Element("coche");

            matricula = new Element("matricula");
            matricula.setText("3333CCC");
            marca = new Element("marca");
            marca.setText("BMW");
            precio = new Element("precio");
            precio.setText("20000");

            coche.addContent(matricula);
            coche.addContent(marca);
            coche.addContent(precio);

            coches.addContent(coche);

            // Coche 4
            coche = new Element("coche");

            matricula = new Element("matricula");
            matricula.setText("4444DDD");
            marca = new Element("marca");
            marca.setText("TOYOTA");
            precio = new Element("precio");
            precio.setText("10000");

            coche.addContent(matricula);
            coche.addContent(marca);
            coche.addContent(precio);

            coches.addContent(coche);

            XMLOutputter xml = new XMLOutputter();
            xml.setFormat(Format.getPrettyFormat());
            xml.output(doc, new FileWriter("concesionario.xml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
