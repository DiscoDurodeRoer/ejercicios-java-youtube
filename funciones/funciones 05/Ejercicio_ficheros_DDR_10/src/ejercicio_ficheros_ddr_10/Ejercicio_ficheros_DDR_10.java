package ejercicio_ficheros_ddr_10;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio_ficheros_DDR_10 {

    public static void main(String[] args) {

        //Creo el scanner y lo preparo
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);

        boolean salir = false;
        
        do {

            //Abro el dataoutputstream
            //el true, es para que se abra el fichero desde el final, no sobrescribe datos
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("candidatos.ddr", true))) {

                //pido datos
                System.out.println("Escribe un DNI");
                String DNI = sc.next();

                System.out.println("Escribe un nombre");
                String nombre = sc.next();

                System.out.println("Escribe una edad");
                int edad = sc.nextInt();

                System.out.println("Escribe valor de la expectativa salarial");
                double expectativa_salarial = sc.nextDouble();

                //Escribo los datos en el fichero
                dos.writeUTF(DNI);

                dos.writeUTF(nombre);

                dos.writeInt(edad);

                dos.writeDouble(expectativa_salarial);

                System.out.println("Candidato añadido");

                //Indico si quiero añadir mas
                System.out.println("¿Quieres añadir mas candidatos?");
                char respuesta = sc.next().toUpperCase().charAt(0);
                
                //Si escribimos no o n, saldremos
                if(respuesta == 'N'){
                    salir=true;
                }
                
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.next();
            }catch(IOException e) {
                System.out.println(e.getMessage());
            }
                
        } while (!salir);

    }

}
