/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import testeando_aplicaciones_ddr_3.ListaDinamica;

public class TestListaDinamica {
    
    public TestListaDinamica() {
    }

    @Test
    public void testEmpty() {
        
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        assertEquals(true, lista.isEmpty());
        
        lista.addFirst(1);
        assertEquals(false, lista.isEmpty());
        
        lista.addFirst(1);
        assertEquals(false, lista.isEmpty());
        
        lista.removeFirst();
        lista.removeFirst();
        
        assertEquals(true, lista.isEmpty());
        
    }
    
    @Test
    public void testSize() {
        
        ListaDinamica<Integer> lista = new ListaDinamica<>();
    
        assertEquals(0, lista.size());

        lista.addFirst(1);
        assertEquals(1, lista.size());

        for (int i = 0; i < 100; i++) {
            lista.addFirst(i);
        }
        assertEquals(101, lista.size());
        
        for (int i = 0; i < 101; i++) {
            lista.removeFirst();
        }
        
        assertEquals(0, lista.size());
        
    }
    
    @Test
    public void testExists() {
    
        ListaDinamica<Integer> lista = new ListaDinamica<>();
    
        assertEquals(false, lista.exists(1));  
        
        lista.addFirst(1);
        assertEquals(true, lista.exists(1));  
        assertEquals(false, lista.exists(2));  
        
        for (int i = 0; i < 100; i++) {
            lista.addFirst(i);
        }
        
        assertEquals(true, lista.exists(50)); 
        assertEquals(true, lista.exists(1)); 
        assertEquals(false, lista.exists(100));  
        
    }
    
}
