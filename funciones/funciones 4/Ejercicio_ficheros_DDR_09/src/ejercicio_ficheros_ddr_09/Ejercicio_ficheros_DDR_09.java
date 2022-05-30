package ejercicio_ficheros_ddr_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author DiscoDurodeRoer
 */
public class Ejercicio_ficheros_DDR_09 {

    public static void main(String[] args) {

        //Objeto file con la ruta del fichero de entrada
        File f = new File("numeros.txt");
        //Objeto file con la ruta del fichero de salida
        File f_salida = new File("numeros_mayores.txt");

        //Abro el Scanner
        //De esta forma, cuando se cierra el try se cierra solo
        try (Scanner sc = new Scanner(f);
                Scanner sc_usuario = new Scanner(System.in);
                PrintWriter pw = new PrintWriter(f_salida)) {

            int num;
            int num_usuario;

            System.out.println("Introduce un numero");
            num_usuario = sc_usuario.nextInt();
            
            //Leo el fichero hasta que no haya mas numeros
            while(sc.hasNext()){
                //Cojo el numero del fichero
                num = sc.nextInt();
                //si es mayor que el que ha puesto el usuario, lo muestro
                if (num > num_usuario) {
                    pw.println(num);
                }
            }

            System.out.println("Guardado el resultado en el fichero");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
