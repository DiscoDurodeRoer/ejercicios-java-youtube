package ejercicio_poo_ddr_07;

/**
 * @author Discoduroderoer
 */
public class Jugador {

    //Atributos
    private int id;
    private String nombre;
    private boolean vivo;

    //Contructor
    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador " + id;
        this.vivo = true;
    }

    //Propiedades
    
    /**
     * El jugador dispara el revolver
     * @param r 
     */
    public void disparar(Revolver r) {

        System.out.println("El " + nombre + " se apunta con la pistola");

        //El jugador se pone el revolver y...
        if (r.disparar()) {
            this.vivo = false; //muere
            System.out.println("El " + nombre + " ha muerto...");
        } else {
            System.out.println("El " + nombre + " se ha librado..."); //No muere
        }

    }

    public boolean isVivo() {
        return vivo;
    }

}
