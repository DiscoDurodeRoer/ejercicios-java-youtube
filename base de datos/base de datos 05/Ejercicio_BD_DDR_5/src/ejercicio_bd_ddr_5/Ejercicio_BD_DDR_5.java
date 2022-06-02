package ejercicio_bd_ddr_5;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;

public class Ejercicio_BD_DDR_5 {

    public static void main(String[] args) {
     
        Persona p1 = new Persona("Fernando", 30, 1.73, 73);
        Persona p2 = new Persona("Pepe", 30, 1.75, 80);
        Persona p3 = new Persona("Alfredo", 20, 1.9, 90);
        Persona p4 = new Persona("Roberto", 35, 1.70, 70);
        Persona p5 = new Persona("Domingo", 30, 1.73, 80);
        
        File f = new File("personas.db4o");
        f.delete();
        
        ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
        
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        db.store(p5);
        
        Persona p = new Persona(null, 30, 1.73, 0);
        ObjectSet<Persona> result = db.queryByExample(p);
        
        while(result.hasNext()){
            System.out.println(result.next());
        }
        
        db.close();
        
    }

}
