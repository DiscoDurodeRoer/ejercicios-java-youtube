package ejercicio_ed_3_discoduroderoer;

/**
 * Lista Dinamica Version 1.0
 *
 * @author DiscoDurodeRoer
 */
public class ListaDinamica<T> {

    //Atributos
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanio;

    public ListaDinamica() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    /**
     * Indica si esta la lista vacia o no
     *
     * @return
     */
    public boolean isEmpty() {
        return tamanio == 0;
    }

    /**
     * Devuelve el tamaño de la lista
     *
     * @return
     */
    public int size() {
        return tamanio;
    }

    /**
     * Devuelve el elemento en la posicion indicada
     *
     * @param index
     * @return
     */
    public T get(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return getFirst(); //Cojo el primero
        } else if (index == size() - 1) {
            return getLast(); //Cojo el ultimo
        } else {

            //Uso la funcion getNode para coger el nodo deseado
            Nodo<T> buscado = getNode(index);

            return buscado.getElemento();

        }

    }

    /**
     * Devuelve el primer elemento, null si esta vacia la lista
     *
     * @return
     */
    public T getFirst() {
        //Si esta vacia, no hay primero que coger
        if (isEmpty()) {
            return null;
        } else {
            return primero.getElemento();
        }
    }

    /**
     * Devuelve el ultimo elemento, null si esta vacia la lista
     *
     * @return
     */
    public T getLast() {
        //Si esta vacia, no hay ultimo que coger
        if (isEmpty()) {
            return null;
        } else {
            return ultimo.getElemento();
        }
    }

    /**
     * Devuelve el nodo completo de una posicion concreta
     *
     * @param index
     * @return
     */
    private Nodo<T> getNode(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return primero; //devuelvo el primero
        } else if (index == size() - 1) {
            return ultimo; //devuelvo el ultimo
        } else {

            Nodo<T> buscado = primero;

            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }

            //Me devuelve el buscado
            return buscado;

        }

    }

    /**
     * Añade un elemento al final de la lista
     *
     * @param elemento
     * @return elemento añadido
     */
    public T addLast(T elemento) {

        Nodo<T> aux;

        //Si esta vacia, hago lo mismo que si fuera añadir el primero
        if (isEmpty()) {
            return addFirst(elemento);
        } else {

            //Hago el intercambio
            aux = new Nodo<>(elemento, null);

            ultimo.setSiguiente(aux);
            ultimo = aux;

        }

        //Aumento el tamanño
        tamanio++;
        return ultimo.getElemento();

    }

    /**
     * Añade el elemento al principio de la lista
     *
     * @param elemento
     * @return elemento añadido
     */
    public T addFirst(T elemento) {

        Nodo<T> aux;

        //si esta vacia, el nodo será el primero y ultimo
        if (isEmpty()) {
            aux = new Nodo<>(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            //Hago el intercambio
            Nodo<T> primeroActual = primero;
            aux = new Nodo<>(elemento, primeroActual);
            primero = aux;

        }

        //Aumento el tamanño
        tamanio++;
        return primero.getElemento();

    }

    /**
     * Añade un elemento en una posicion indicada
     *
     * @param elemento
     * @param index debe ser un indice valido
     * @return elemento añadido
     */
    public T add(T elemento, int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (index == 0) {
            return addFirst(elemento); //Añade en la primera posicion
        } else if (index == size()) {
            return addLast(elemento); //añade en la ultima posicion
        } else if ((index < 0 || index >= size())) {
            return null;
        } else {

            //Cojo el anterior nodo al que estoy buscando
            Nodo<T> buscado_anterior = getNode(index - 1);

            //Cojo el nodo de la posicion indicada
            Nodo<T> buscado_actual = getNode(index);

            //Creo el nuevo novo, este apuntara al de la posicion actual
            Nodo<T> aux = new Nodo<>(elemento, buscado_actual);

            //el nodo anterior apunta a nuestro nuevo nodo
            buscado_anterior.setSiguiente(aux);

            //Aumento el tamaño
            tamanio++;
            return getNode(index).getElemento();

        }

    }

    /**
     * Devuelve el estado de la lista
     *
     * @return
     */
    public String toString() {

        String contenido = "";

        //Si esta vacia, lo indica
        if (isEmpty()) {
            contenido = "Lista vacia";
        } else {

            Nodo<T> aux = primero;

            //Recorre la lista, mostrando el contenido
            while (aux != null) {
                contenido += aux.toString();
                aux = aux.getSiguiente();
            }

        }

        return contenido;

    }

}
