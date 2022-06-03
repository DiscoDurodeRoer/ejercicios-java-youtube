package baraja;

import pila.PilaDinamica;

/**
 * Clase Baraja
 *
 * @author Disco Duro de Roer
 */
public abstract class Baraja<T> {

    //Atributos
    protected PilaDinamica<Carta<T>> cartas;
    protected PilaDinamica<Carta<T>> cartasMonton;
    protected int numCartas;
    protected int cartasPorPalo;

    public Baraja() {
        this.cartas = new PilaDinamica<>();
        this.cartasMonton = new PilaDinamica<>();
    }

    /**
     * Metodo abstracto crearBaraja
     */
    public abstract void crearBaraja();

    /**
     * Baraja todas las cartas
     */
    public void barajar() {

        int posAleatoria = 0;
        Carta c;

        while (!this.cartasMonton.isEmpty()) {
            this.cartas.push(this.cartasMonton.pop());
        }

        Carta cartasBarajar[] = new Carta[this.numCartas];

        int indiceCarta = 0;
        while (!this.cartas.isEmpty()) {
            cartasBarajar[indiceCarta] = this.cartas.pop();
            indiceCarta++;
        }

        for (int i = 0; i < cartasBarajar.length; i++) {

            do {
                posAleatoria = Metodos.generaNumeroEnteroAleatorio(0, numCartas - 1);
                c = cartasBarajar[posAleatoria];
            } while (c == null);

            this.cartas.push(c);
            cartasBarajar[posAleatoria] = null;
            
        }

    }

    /**
     * Devuelve la casta donde se encuentre "posSiguienteCarta"
     *
     * @return carta del arreglo
     */
    public Carta siguienteCarta() {

        Carta c = null;

        if (this.cartas.isEmpty()) {
            System.out.println("Ya no hay mas cartas, barajea de nuevo");
        } else {
            c = cartas.pop();
            this.cartasMonton.push(c);
        }

        return c;

    }

    /**
     * Devuelve un numero de cartas. Controla si hay mas cartas de las que se
     * piden
     *
     * @param numCartas
     * @return
     */
    public Carta[] darCartas(int numCartas) {

        if (numCartas > numCartas) {
            System.out.println("No se puede dar mas cartas de las que hay");
        } else if (cartasDisponible() < numCartas) {
            System.out.println("No hay suficientes cartas que mostrar");
        } else {

            Carta[] cartasDar = new Carta[numCartas];

            //recorro el array que acabo de crear para rellenarlo
            for (int i = 0; i < cartasDar.length; i++) {
                cartasDar[i] = siguienteCarta(); //uso el metodo anterior
            }

            //Lo devuelvo
            return cartasDar;

        }

        //solo en caso de error
        return null;

    }

    /**
     * Indica el numero de cartas que hay disponibles
     *
     * @return
     */
    public int cartasDisponible() {
        return this.cartas.size();
    }

    /**
     * Muestro las cartas que ya han salido
     */
    public void cartasMonton() {

        if (cartasDisponible() == numCartas) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            System.out.println(this.cartasMonton.toString());
        }

    }

    /**
     * Muestro las cartas que aun no han salido
     */
    public void mostrarBaraja() {

        if (cartasDisponible() == 0) {
            System.out.println("No hay cartas que mostrar");
        } else {
            System.out.println(this.cartas.toString());
        }

    }

}
