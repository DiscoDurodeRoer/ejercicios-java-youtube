package ejercicio_arrays_ddr_17;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_arrays_DDR_17 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        // Limite de nuestra mochila
        final int LIMITE_MOCHILA = 20;

        // Variables necesarias
        String[] objetos = new String[LIMITE_MOCHILA];
        int[] cantidades = new int[LIMITE_MOCHILA];

        int cantidad, numObjetos = 0, indiceObjeto, nuevaCantidad;
        String objeto;

        // Menu
        while (!salir) {

            System.out.println("1. Guardar objeto");
            System.out.println("2. Mostrar mochila");
            System.out.println("3. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        // Pedimos los valores
                        System.out.println("Introduce un objeto");
                        objeto = sn.next();

                        System.out.println("Introduce una cantidad");
                        cantidad = sn.nextInt();

                        // Validamos la cantidad
                        if (cantidad >= 1 && cantidad <= 99) {

                            // Comprobamos si el objeto existe
                            indiceObjeto = -1;
                            for (int i = 0; i < numObjetos; i++) {
                                if (objetos[i].trim().equalsIgnoreCase(objeto.trim())) {
                                    indiceObjeto = i;
                                }
                            }

                            // Si existe, actualizo el objeto, sino lo creo
                            if (indiceObjeto != -1) {
                                // Compruebo si se pasa de 100
                                nuevaCantidad = cantidades[indiceObjeto] + cantidad;
                                if (nuevaCantidad > 100) {
                                    // Si hay sitio en la mochila
                                    if (numObjetos < LIMITE_MOCHILA) {
                                        // Dejamos el actual objeto a 99
                                        cantidades[indiceObjeto] = 99;
                                        // creamos otro con la diferencia
                                        objetos[numObjetos] = objeto;
                                        cantidades[numObjetos] = nuevaCantidad - 99;
                                        numObjetos++;
                                        System.out.println("Se ha actualizado el objeto");
                                    } else {
                                        System.out.println("No hay sitio en la mochila");
                                    }
                                } else {
                                    // Actualizamos el objeto
                                    cantidades[indiceObjeto] = nuevaCantidad;
                                    System.out.println("se ha actualizado el objeto");
                                }
                            } else {
                                // Si hay sitio en la mochila
                                if (numObjetos < LIMITE_MOCHILA) {
                                    // creamos el objeto y su cantidad
                                    objetos[numObjetos] = objeto;
                                    cantidades[numObjetos] = cantidad;
                                    numObjetos++;
                                    System.out.println("Se ha creado un objeto");
                                } else {
                                    System.out.println("No hay sitio en la mochila");
                                }
                            }

                        } else {
                            System.out.println("La cantidad no es valida");
                        }

                        break;
                    case 2:
                        // Mostramos los objetos con el formato: objeto x cantidad
                        for (int i = 0; i < numObjetos; i++) {
                            System.out.println(objetos[i] + " x " + cantidades[i]);
                        }
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }
}
