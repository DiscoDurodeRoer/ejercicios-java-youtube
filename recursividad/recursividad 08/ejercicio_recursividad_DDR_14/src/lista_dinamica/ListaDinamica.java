package lista_dinamica;

import java.util.Iterator;


/**
 * Lista Dinamica Version 2.0
 *
 * @author DiscoDurodeRoer
 * @param <T>
 */
public class ListaDinamica<T> implements Iterable<T>{

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

    /**
     * Indica si existe el elemento indicado
     *
     * @param elemento
     * @return
     */
    public boolean exists(T elemento) {

        //Si esta vacio, devuelve el false
        if (isEmpty()) {
            return false;
        } else {

            Nodo<T> aux = primero;

            //Recorremos la lista
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { //Mejor .equals que ==
                    return true; //Existe
                }
                aux = aux.getSiguiente();
            }

            //Si no lo encuentra devuelve false
            return false;

        }
    }

    /**
     * Indica la posición del elemento
     *
     * @param elemento
     * @return
     */
    public int indexOf(T elemento) {

        //Si esta vacio, devuelvemos -1
        if (isEmpty()) {
            return -1;
        } else {

            Nodo<T> aux = primero;

            int posicion = 0;
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { //Mejor .equals que ==
                    return posicion; //Existe
                }
                posicion++;
                aux = aux.getSiguiente();
            }
            //Si no lo encuentra devuelve -1
            return -1;

        }

    }

    /**
     * Elimina el primer elemento de la lista
     *
     * @return
     */
    public T removeFirst() {

        //Si la lista esta vacia, devolvemos null
        if (isEmpty()) {
            return null;
        } else {

            //Guardo el elemento antes
            T elemento = primero.getElemento();

            //Cojo el segundo
            Nodo<T> aux = primero.getSiguiente();
            primero = null; //Lo marco como null para el recolector
            primero = aux; //Este es mi nuevo primero

            //En caso de que borremos el ultimo elemento,el ultimo también
            if (size() == 1) {
                ultimo = null;
            }

            tamanio--;

            return elemento;

        }

    }

    /**
     * Borra el ultimo elemento de la lista
     *
     * @return
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        } else {

            //Coge el elemento antes de borrar
            T elemento = ultimo.getElemento();

            //Cojo el penultimo
            Nodo<T> aux = getNode(size() - 2);

            //En caso de que sea null
            //Hay 1 o dos elementos
            if (aux == null) {

                //marco el ultimo como nulo
                ultimo = null;
                //Si hay dos, el primero y el ultimo seran el mismo
                //Si hay 1 elemento, significa que borramos la lista
                if (size() == 2) {
                    ultimo = primero;
                } else {
                    primero = null;
                }

            } else {
                //el penultimo es el nuevo ultimo 
                //y le ponemos como siguiente nulo
                ultimo = null;
                ultimo = aux;
                ultimo.setSiguiente(null);
            }

            tamanio--;

            return elemento;

        }

    }

    /**
     * Elimina el nodo de la lista en una posicion concreta
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {

            //Cojo el nodo anterior al que quiero borrar
            Nodo<T> nodo_anterior = getNode(index - 1);

            //Cojo el nodo que quiero borrar
            Nodo<T> nodo_actual = getNode(index);

            //Cojo el elemento antes de borrar
            T elemento = nodo_actual.getElemento();

            //Cojo el nodo siguiente al que quiero borrar
            Nodo<T> nodo_siguiente = nodo_actual.getSiguiente();

            //Lo marco para borrar para el recolector
            nodo_actual = null;

            //El nodo anterior apunta al nodo siguiente
            nodo_anterior.setSiguiente(nodo_siguiente);

            tamanio--;

            return elemento;

        }
    }

    /**
     * Modifico el elemento de una posicion No afecta a la estructura de la
     * lista
     *
     * @param elemento
     * @param index
     * @return
     */
    public T modify(T elemento, int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else {

            //Nodo actual
            Nodo<T> aux = getNode(index);

            //modifico
            aux.setElemento(elemento);

            return aux.getElemento();

        }

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    //Creo la clase interna MyIterator, que implementa la interfaz Iterator
    private class MyIterator<ListaDinamica> implements Iterator<T>{

        //Indica el siguiente elemento que se va a devolver 
        private int siguiente;
        
        //Indica si hay un elemento
        @Override
        public boolean hasNext() {
            return getNode(siguiente)!=null;
        }

        //Devuelve el elemento actual e incrementa al siguiente
        @Override
        public T next() {
            T elemento = getNode(siguiente).getElemento();
            siguiente++;
            return elemento;
        }
        
    }
    

}
