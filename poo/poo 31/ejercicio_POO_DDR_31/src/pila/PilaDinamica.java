package pila;

/**
 * Clase Pila Dinamica
 *
 * @author DiscoDurodeRoer
 * @param <T>
 */
public class PilaDinamica<T> {

    //Atributos
    private Nodo<T> top; //Ultimo nodo que se ha incluido
    private int tamanio;

    //Constructores
    public PilaDinamica() {
        top = null; //No hay elementos
        this.tamanio = 0;
    }

    /**
     * Indica si esta vacia o no
     *
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Indica el tamaño
     *
     * @return
     */
    public int size() {
        return this.tamanio;
    }

    /**
     * Devuelve el que esta más arriba en la pila
     *
     * @return
     */
    public T top() {
        if (isEmpty()) {
            return null;
        } else {
            return top.getElemento();
        }
    }

    /**
     * Saca y devuelve el elemento que mas arriba esta en la pila
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T elemento = top.getElemento();
            Nodo<T> aux = top.getSiguiente();
            top = null; //marco para borrar
            top = aux; //actualizo el top
            this.tamanio--;
            return elemento;
        }
    }

    /**
     * Mete un elemento a la pila
     *
     * @param elemento
     * @return
     */
    public T push(T elemento) {

        Nodo<T> aux = new Nodo<>(elemento, top);
        top = aux; //actualizo el top
        this.tamanio++;
        return aux.getElemento();
    }

    /**
     * Devuelve el estado de la pila
     *
     * @return
     */
    public String toString() {

        if (isEmpty()) {
            return "La pila esta vacia";
        } else {

            String resultado = "";
            Nodo<T> aux = top;
            //Recorro la pila
            while (aux != null) {
                resultado += aux.toString();
                aux = aux.getSiguiente();
            }

            return resultado;

        }

    }

}
