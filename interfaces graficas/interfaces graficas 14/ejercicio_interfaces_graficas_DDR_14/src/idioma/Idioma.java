/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idioma;

import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties {

    private static final long serialVersionUID = 1L;

    public Idioma(String idioma) {

        //Modificar si quieres añadir mas idiomas
        //Cambia el nombre de los ficheros o añade los necesarios
        switch (idioma) {
            case "Español":
                getProperties("espanol.properties");
                break;
            case "Inglés":
                getProperties("ingles.properties");
                break;
            default:
                getProperties("espanol.properties");
        }

    }

    private void getProperties(String idioma) {
        try {
            this.load(getClass().getResourceAsStream(idioma));
        } catch (IOException ex) {

        }
    }
}
