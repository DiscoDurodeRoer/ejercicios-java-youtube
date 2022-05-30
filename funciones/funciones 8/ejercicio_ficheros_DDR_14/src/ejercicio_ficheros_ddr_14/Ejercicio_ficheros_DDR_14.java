package ejercicio_ficheros_ddr_14;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_ficheros_DDR_14 {

    public static void main(String[] args) {
        
        /*Contacto c1 = new Contacto("Fer", 111111);
        Contacto c2 = new Contacto("Nando", 222222);
        Contacto c3 = new Contacto("Pepe", 333333);
        Contacto c4 = new Contacto("Jose", 444444);
        Contacto c5 = new Contacto("DDR", 555555);
        
        Agenda agenda = new Agenda();
        
        agenda.aniadirContacto(c1);
        agenda.aniadirContacto(c2);
        agenda.aniadirContacto(c3);
        agenda.aniadirContacto(c4);
        agenda.aniadirContacto(c5);
        
        agenda.exportarContactos();
        */
        
        Agenda agenda = new Agenda();
        
        try {
            
            Contacto c1 = new Contacto("Fer", 111111);
            agenda.aniadirContacto(c1);
            
            agenda.importarContactos("contactos.age");
            
            agenda.listarContactos();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio_ficheros_DDR_14.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
}
