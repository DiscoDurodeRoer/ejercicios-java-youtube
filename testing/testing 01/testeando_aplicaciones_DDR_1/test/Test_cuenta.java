/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import testeando_aplicaciones_ddr_1.Cuenta;

/**
 *
 * @author Fernando
 */
public class Test_cuenta {
    
    public Test_cuenta() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testCreacionCuenta(){
        
        Cuenta c = new Cuenta("Fer", -500);
        
        assertEquals(0, c.getCantidad(), 0);
        
        Cuenta c1 = new Cuenta("Fernando", 500);
        
        assertEquals(500, c1.getCantidad(),0);
        
    }
    
    @Test
    public void testIngresar(){
        
        Cuenta c = new Cuenta("Fer", 500);
        
        c.ingresar(1000);
        
        assertEquals(1500, c.getCantidad(), 0);
        
        c.ingresar(-1000);
        
        assertEquals(1500, c.getCantidad(), 0);
        
    }
    
    
    @Test
    public void testRetirar(){
        
        Cuenta c = new Cuenta("Fer", 500);
        
        c.retirar(200);
        
        assertEquals(300, c.getCantidad(), 0);
        
        c.retirar(500);
        
        assertEquals(0, c.getCantidad(), 0);
        
        c.ingresar(1000);
        c.retirar(-500);
        
        assertEquals(500, c.getCantidad(), 0);
        
        
    }
    
    
    
}
