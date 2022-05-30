package ejercicio_ficheros_ddr_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author DiscoDurodeRoer
 */
public class Ejercicio_ficheros_DDR_08 {

    public static void main(String[] args) {

        //Objeto file con la ruta del fichero
        File f = new File("numeros.txt");

        //Abro el Scanner
        //De esta forma, cuando se cierra el try se cierra solo
        try (Scanner sc = new Scanner(f);
                Scanner sc_usuario = new Scanner(System.in)) {

            int num;
            int num_usuario;

            System.out.println("Introduce un numero");
            num_usuario = sc_usuario.nextInt();

            System.out.println("");
            System.out.println("Fichero");
            //Leo el fichero hasta que no haya mas numeros
            while (sc.hasNext()) {
                //Cojo el numero del fichero
                num = sc.nextInt();
                //si es mayor que el que ha puesto el usuario, lo muestro
                if (num > num_usuario) {
                    System.out.println(num);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
