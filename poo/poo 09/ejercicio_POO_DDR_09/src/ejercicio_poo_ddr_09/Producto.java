package ejercicio_poo_ddr_09;

/**
 * Clase Producto, clase padre
 * @author DiscoDurodeRoer
 */
public class Producto {
    
    //Atributos
    private String nombre;
    private double precio;

    //Constructores
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", precio=" + precio +", ";
    }
    
    /**
     * Indica el precio total segun una cantidad
     * @param cantidad
     * @return 
     */
    public double calcular(int cantidad){
        return precio*cantidad;
    }
    
    
}
