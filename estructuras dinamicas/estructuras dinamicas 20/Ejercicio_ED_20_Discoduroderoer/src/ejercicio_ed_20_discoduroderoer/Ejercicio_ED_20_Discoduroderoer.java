package ejercicio_ed_20_discoduroderoer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_ED_20_Discoduroderoer {

    public static void main(String[] args) {

        HashMap<String, Integer> inventario = new HashMap<>();

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Añadir producto");
            System.out.println("2. Aumentar stock de un producto");
            System.out.println("3. Eliminar stock de un producto");
            System.out.println("4. Mostrar productos y su stock");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                String producto;
                int stock, stockActual;
                switch (opcion) {
                    case 1:

                        System.out.println("Escribe el nombre del producto");
                        producto = sn.next();

                        if (inventario.containsKey(producto)) {
                            System.out.println("Ya existe el producto");
                        } else {
                            inventario.put(producto, 0);
                            System.out.println("Se ha añadido el producto");
                        }

                        break;
                    case 2:

                        System.out.println("Escribe el nombre del producto");
                        producto = sn.next();

                        if (inventario.containsKey(producto)) {

                            System.out.println("Introduce una cantidad");
                            stock = sn.nextInt();

                            if (stock > 0) {
                                stockActual = inventario.get(producto);
                                inventario.put(producto, stockActual + stock);
                                System.out.println("Se ha añadido " + stock + " de stock al producto " + producto);
                            } else {
                                System.out.println("No se puede añadir un stock negativo");
                            }

                        } else {
                            System.out.println("No existe el producto");
                        }

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}
