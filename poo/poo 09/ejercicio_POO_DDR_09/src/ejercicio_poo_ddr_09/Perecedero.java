package ejercicio_poo_ddr_09;

/**
 * Clase Perecedero, clase hija de Producto
 * @author DiscoDurodeRoer
 */
public class Perecedero extends Producto {

    //Atributos
    private int dias_a_caducar;

    //Constructores
    public Perecedero(int dias_a_caducar, String nombre, double precio) {
        super(nombre, precio);
        this.dias_a_caducar = dias_a_caducar;
    }

    //Metodos
    public int getDias_a_caducar() {
        return dias_a_caducar;
    }

    public void setDias_a_caducar(int dias_a_caducar) {
        this.dias_a_caducar = dias_a_caducar;
    }

    @Override
    public String toString() {
        return super.toString() + " dias_a_caducar=" + dias_a_caducar;
    }

    /**
     * Calcula el precio segun una cantidad,
     * tambien segun los dias que le queden al prodcuto,
     * se reducira el precio.
     * <ul>
     * <li>1: 4 veces menos</li>
     * <li>2: 3 veces menos</li>
     * <li>3: 2 veces menos</li>
     * </ul>
     * @param cantidad
     * @return 
     */
    @Override
    public double calcular(int cantidad) {

        double precioFinal = super.calcular(cantidad);

        switch (dias_a_caducar) {
            case 1:
                precioFinal /= 4;
                break;
            case 2:
                precioFinal /= 3;
                break;
            case 3:
                precioFinal /= 2;
                break;
        }
        
        return precioFinal;

    }

}
