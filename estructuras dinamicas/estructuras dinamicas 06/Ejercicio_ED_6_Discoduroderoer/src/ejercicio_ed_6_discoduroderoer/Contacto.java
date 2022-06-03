
package ejercicio_ed_6_discoduroderoer;

import java.io.Serializable;

/**
 * Representa a un contacto
 * @author Discoduroderoer
 */
public class Contacto implements Serializable{
    
    private static final long serialVersionUID = -1L;
    
    private String nombre;
    private int telefono;

    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telefono = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //Esta funcion es muy importante de sobrescribir
    public boolean equals(Object o){
        if(o instanceof Contacto){
            Contacto c = (Contacto)o;
            return this.equals(c);
        }else{
            return false;
        }
    }
    
    public boolean equals(Contacto c) {

        if (this.nombre.trim().equalsIgnoreCase(c.getNombre().trim())) {
            return true;
        }

        return false;

    }
    
    @Override
    public String toString() {
        return "nombre=" + nombre + ", telefono=" + telefono;
    }
    
    
}
