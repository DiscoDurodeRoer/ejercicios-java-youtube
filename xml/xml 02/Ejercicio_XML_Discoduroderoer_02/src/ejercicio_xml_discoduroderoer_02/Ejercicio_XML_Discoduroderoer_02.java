package ejercicio_xml_discoduroderoer_02;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio_XML_Discoduroderoer_02 {

    public static void main(String[] args) {

        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("concesionario.xml"));

            // Cojo todas las etiquetas coche del documento
            NodeList listaCoches = documento.getElementsByTagName("coche");

            // Recorro las etiquetas
            for (int i = 0; i < listaCoches.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaCoches.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            System.out.println("Propiedad: " + hijo.getNodeName() + ", Valor: " + hijo.getTextContent());
                        }

                    }
                    System.out.println("");
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
