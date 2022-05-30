package Ejercicio_basicos_DDR_21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_basicos_DDR_21 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        //Indica si salimos o no
        boolean salir = false;
        int opcion;

        //Bucle para pedir las opciones hasta que elijamos salir
        while (!salir) {

            //opciones
            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Opcion 4");
            System.out.println("5. Opcion 5");
            System.out.println("6. Opcion 6");
            System.out.println("7. Salir");

            try{
            
                //Pide una opcion
                System.out.println("Introduce un numero: ");
                opcion = sn.nextInt();

                //Realiza una de las opciones
                switch (opcion) {
                    case 1:
                        System.out.println("Esta es la opcion 1");
                        break;
                    case 2:
                        System.out.println("Esta es la opcion 2");
                        break;
                    case 3:
                        System.out.println("Esta es la opcion 3");
                        break;
                    case 4:
                        System.out.println("Esta es la opcion 4");
                        break;
                    case 5:
                        System.out.println("Esta es la opcion 5");
                        break;
                    case 6:
                        System.out.println("Esta es la opcion 6");
                        break;
                    case 7:
                        salir=true;
                        break;
                    default:
                        System.out.println("Las opciones son entre 1 y 7");
                }
            
                
            //controla la excepcionn en caso de que se introduzca un valor no correcto
            }catch(InputMismatchException e){
                System.out.println("Debes escribir un numero");
                sn.next();
            }

        }
        
        System.out.println("Fin del menu");

    }

}
