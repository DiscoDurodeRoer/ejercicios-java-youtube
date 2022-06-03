package ejercicio_poo_ddr_04;

/**
 * Clase Espectador, lleva todo lo relativo a la información del espectador
 *
 * @author DiscoDurodeRoer
 */
public class Espectador {

    /*Atributos*/
    private String nombre;
    private int edad;
    private double dinero;

    /*Constructores*/
    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    /*Metodos*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    /**
     * Pagamos la entrada del cine
     *
     * @param precio
     */
    public void pagar(double precio) {
        dinero -= precio;
    }

    /**
     * Indicamos si el espectador tiene edad para ver la pelicula (en el video
     * estaba en la clase pelicula tiene mas sentido que sea un metodo del
     * espectador)
     *
     * @param edadMinima
     * @return
     */
    public boolean tieneEdad(int edadMinima) {
        return edad >= edadMinima;
    }

    /**
     * Indicamos si el espectador tiene dinero (en el video estaba en la clase
     * cine tiene mas sentido que sea un metodo del espectador)
     *
     * @param precioEntrada
     * @return
     */
    public boolean tieneDinero(double precioEntrada) {
        return dinero >= precioEntrada;
    }

    @Override
    public String toString() {
        return "el nombre del espectador es " + nombre + " de " + edad + " años y con " + dinero + " euros en su bolsillo";
    }

}
