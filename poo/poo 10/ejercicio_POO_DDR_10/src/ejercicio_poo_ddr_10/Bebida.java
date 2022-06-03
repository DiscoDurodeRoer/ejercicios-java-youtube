
package ejercicio_poo_ddr_10;

public class Bebida {
    
    private static int idActual=1;
    
    private int id;
    private double cantidad;
    private double precio;
    private String marca;
    
    public Bebida(double cantidad, double precio, String marca){
        
        this.id=idActual++;
        
        this.cantidad=cantidad;
        this.precio=precio;
        this.marca=marca;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return  "id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", marca=" + marca + " ";
    }
    
}
