/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import testeando_aplicaciones_ddr_5.ListaDinamica;

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

    @Test
    public void testAddFirst() {
        
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        assertEquals(null, lista.getFirst());

        lista.addFirst(1);
        assertEquals(1, lista.getFirst().intValue());
        
        lista.addFirst(2);
        assertEquals(2, lista.getFirst().intValue());
        
        lista.addFirst(3);
        lista.addFirst(4);
        assertEquals(4, lista.getFirst().intValue());
        
        
    }
    
    @Test
    public void testAddLast() {
    
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        assertEquals(null, lista.getLast());
        
        lista.addLast(1);
        assertEquals(1, lista.getLast().intValue());
        
        lista.addLast(2);
        assertEquals(2, lista.getLast().intValue());
        
        lista.addLast(3);
        lista.addLast(4);
        assertEquals(4, lista.getLast().intValue());
        
    }
    
    @Test
    public void testAdd() {
    
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        lista.add(1, 0);
        lista.add(2, 1);
        lista.add(3, 2);
        lista.add(4, 3);
        lista.add(5, 4);
        lista.add(6, 5);
        
        assertEquals(5, lista.get(4).intValue());
        assertEquals(1, lista.getFirst().intValue());
        assertEquals(6, lista.getLast().intValue());
        
        lista.add(7, 2);
        lista.add(8, 10); // no se va a insertar
        lista.add(9, 7);
        
        assertEquals(3, lista.get(3).intValue());
        assertEquals(9, lista.getLast().intValue());
        
    } 
    
    @Test
    public void testRemoveFirst() {
    
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        lista.addFirst(1);
        lista.addFirst(2);
        
        lista.removeFirst();
        
        assertEquals(1, lista.getFirst().intValue());
        
        lista.addFirst(3);
        lista.addFirst(4);
        
        lista.removeFirst();
        lista.removeFirst();
        
        assertEquals(1, lista.getFirst().intValue());
        
        lista.addFirst(5);
        lista.addFirst(6);
        
        lista.removeFirst();
        
        assertEquals(5, lista.getFirst().intValue());
        
    }

    @Test
    public void testRemoveLast() {
    
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        lista.addLast(1);
        lista.addLast(2);
        
        lista.removeLast();
        
        assertEquals(1, lista.getLast().intValue());
        
        lista.addLast(3);
        lista.addLast(4);
        
        lista.removeLast();
        lista.removeLast();
        
        assertEquals(1, lista.getLast().intValue());
        
        lista.addLast(5);
        lista.addLast(6);
        
        lista.removeLast();
        
        assertEquals(5, lista.getLast().intValue());
        
    }
    
    @Test
    public void testRemove() {
        
        ListaDinamica<Integer> lista = new ListaDinamica<>();
        
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);
        lista.addLast(6);
        
        lista.remove(0);
        
        assertEquals(2, lista.getFirst().intValue());
        
        lista.remove(lista.size() - 1);
        
        assertEquals(5, lista.getLast().intValue());
        
        lista.remove(1);
        
        assertEquals(4, lista.get(1).intValue());
        
        lista.remove(1);
        
        assertEquals(5, lista.get(1).intValue());
        
        lista.remove(8);
        
        assertEquals(5, lista.get(1).intValue());
    }
    
}
