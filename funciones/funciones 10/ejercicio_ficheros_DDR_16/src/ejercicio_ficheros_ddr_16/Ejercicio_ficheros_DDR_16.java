package ejercicio_ficheros_ddr_16;

import java.util.ArrayList;

public class Ejercicio_ficheros_DDR_16 {

    public static void main(String[] args) {
        
        GestorFicheroSerializado<Persona> gestor = new GestorFicheroSerializado("datos.ddr");
        
       /* Persona p1 = new Persona(20, "Fernando");
        Persona p2 = new Persona(30, "Manuel");
        Persona p3 = new Persona(40, "Fernando");
        
        gestor.guardarDato(p1);
        gestor.guardarDato(p2);
        gestor.guardarDato(p3);
        
        System.out.println("Guardado con exito");*/
        
        gestor.mostrarDatos();
        
        Persona p1 = new Persona("Fernando");
        System.out.println(gestor.existeDato(p1));
        
        gestor.borrarDato(p1);
        
        System.out.println("");
        
        gestor.mostrarDatos();
        
        
       /*
       ArrayList<Persona> personas = gestor.getDatos();

        for (Persona p: personas) {
            System.out.println(p);
        }*/
       
       
       
        
    }
    
}
