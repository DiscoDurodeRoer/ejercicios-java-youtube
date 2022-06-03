package ejercicio_ed_22_discoduroderoer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio_ED_22_Discoduroderoer {

    public static void main(String[] args) {

        HashMap<String, Integer> inventario = new HashMap<>();
        TreeMap<String, Integer> tree;

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
            System.out.println("6. Ordenar productos ascendentemente");
            System.out.println("7. Ordenar productos descendentemente");
            System.out.println("8. Salir");

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

                        System.out.println("Escribe el nombre del producto");
                        producto = sn.next();

                        if (inventario.containsKey(producto)) {

                            System.out.println("Stock a eliminar");
                            stock = sn.nextInt();

                            if (stock > 0) {
                                stockActual = inventario.get(producto);

                                if (stockActual > stock) {
                                    inventario.put(producto, stockActual - stock);
                                } else {
                                    System.out.println("No hay suficiente stock a eliminar");
                                }

                            } else {
                                System.out.println("No puedo eliminar un stock negativo");
                            }

                        } else {
                            System.out.println("No existe el producto");
                        }

                        break;
                    case 4:

                        for (String p : inventario.keySet()) {
                            stock = inventario.get(p);
                            System.out.println("Clave: " + p + ", Valor: " + stock);
                        }

                        break;
                    case 5:

                        System.out.println("Escribe el producto a eliminar");
                        producto = sn.next();

                        if (inventario.containsKey(producto)) {
                            inventario.remove(producto);
                            System.out.println("Producto eliminado");
                        } else {
                            System.out.println("No existe el producto");
                        }

                        break;
                    case 6:

                        tree = new TreeMap<>(new OrdenarProductosAsc());

                        tree.putAll(inventario);

                        for (String p : tree.keySet()) {
                            stock = tree.get(p);
                            System.out.println("Clave: " + p + ", Valor: " + stock);
                        }

                        break;
                    case 7:
                        tree = new TreeMap<>(new OrdenarProductosDesc());

                        tree.putAll(inventario);

                        for (String p : tree.keySet()) {
                            stock = tree.get(p);
                            System.out.println("Clave: " + p + ", Valor: " + stock);
                        }
                        break;
                    case 8:
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
