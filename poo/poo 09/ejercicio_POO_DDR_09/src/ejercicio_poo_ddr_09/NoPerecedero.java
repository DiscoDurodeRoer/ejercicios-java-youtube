package ejercicio_poo_ddr_09;

/**
 * Clase NoPerecedero, clase hija de Producto
 * No se ha implementado calcular, llama al del padre
 * @author DiscoDurodeRoer
 */
public class NoPerecedero extends Producto{
    
    //Atributos
    private String tipo;

    //constructores
    public NoPerecedero(String tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    //Metodos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " tipo=" + tipo + '}';
    }
    
    
}
