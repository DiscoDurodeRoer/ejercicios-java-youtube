package ejercicio_ed_7_discoduroderoer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio_ED_7_Discoduroderoer {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        //Creamos un hashmap (clave=nombre, valor=telefono)
        HashMap<String, Integer> agenda = new HashMap<>();
        
        //Creamos el teclado
        Leer teclado = new Leer();
        
        String nombre;
        int telefono;

        //menu
        while (!salir) {

            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        //pedimos los datos
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        telefono = teclado.pedirInt("Introduce el telefono");
                        
                        //Sino existe la clave, lo inserta
                        if(!agenda.containsKey(nombre)){
                            agenda.put(nombre.toLowerCase().trim(), telefono);
                            System.out.println("Se ha añadido el contacto");
                        }else{
                            System.out.println("Ya existe el contacto");
                        }
                        
                        break;
                    case 2:
                        
                        //Si esta vacio, mostramos el mensaje
                        if(agenda.entrySet().isEmpty()){
                            System.out.println("No hay contactos");
                        }else{
                            //Recorremos el hashmap
                            for(Map.Entry<String, Integer> entry: agenda.entrySet()){
                                System.out.println("Nombre: "+entry.getKey()+" Telefono:"+entry.getValue());
                            }
                        }
                        
                        break;
                    case 3:

                        //pido el nombre
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        
                        //Si existe, cojo el valor
                        if(agenda.containsKey(nombre)){
                            System.out.println("El telefono es "+agenda.get(nombre));
                        }else{
                            System.out.println("El contacto no existe");
                        }
                        
                        break;
                    case 4:
                        
                        //pido el nombre
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        
                        //si existe la clave, muestro un mensaje
                        if(agenda.containsKey(nombre)){
                            System.out.println("El contacto existe");
                        }else{
                            System.out.println("El contacto no existe");
                        }
                        break;
                    case 5:

                        //pido el nombre
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        
                        //Si existe una clave, elimino el registro 
                        if(agenda.containsKey(nombre)){
                            agenda.remove(nombre);
                            System.out.println("El contacto se ha borrado");
                        }else{
                            System.out.println("El contacto no existe");
                        }
                        
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
