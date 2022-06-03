package ejercicio_ficheros_ddr_15;

import java.util.ArrayList;

public class Ejercicio_ficheros_DDR_15 {

    public static void main(String[] args) {
        
        GestorFicheroSerializado<Persona> gestor = new GestorFicheroSerializado("datos.ddr");
        
        Persona p1 = new Persona(20, "Fernando");
        Persona p2 = new Persona(30, "Manuel");
        Persona p3 = new Persona(40, "Pablo");
        
        gestor.guardarDato(p1);
        gestor.guardarDato(p2);
        gestor.guardarDato(p3);
        
        System.out.println("Guardado con exito");
       /*
       ArrayList<Persona> personas = gestor.getDatos();

        for (Persona p: personas) {
            System.out.println(p);
        }*/
       
       
       
        
    }
    
}
