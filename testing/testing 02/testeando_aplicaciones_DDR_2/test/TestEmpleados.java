/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import testeando_aplicaciones_ddr_2.Comercial;
import testeando_aplicaciones_ddr_2.Repartidor;

/**
 *
 * @author Fernando
 */
public class TestEmpleados {
    
    static Repartidor r;
    static Comercial c;
    
    
    
    public TestEmpleados() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @BeforeClass
    public static void iniciar(){
        
        c = new Comercial(300, "DDR", 37, 1000);
        r = new Repartidor("zona 3", "Fer", 20, 900);
        
    }
    
    @Test
    public void testPlus(){
        
        c.plus();
        
        assertEquals(1000+c.PLUS, c.getSalario(), 0);
        
        r.plus();
        
        assertEquals(900+r.PLUS, r.getSalario(), 0);
        
        c.setEdad(20);
        c.plus();
        assertEquals(1300, c.getSalario(), 0);
        
        
        r.setEdad(30);
        r.plus();
        assertEquals(1200, r.getSalario(), 0);
        
        
        
        
    } 
    
    
    
}
