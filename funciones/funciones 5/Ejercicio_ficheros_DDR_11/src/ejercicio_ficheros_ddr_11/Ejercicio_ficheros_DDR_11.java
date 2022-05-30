package ejercicio_ficheros_ddr_11;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio_ficheros_DDR_11 {

    public static void main(String[] args) {

        //Abro el datainputstream con el fichero del anterior ejercicio
        try (DataInputStream dis = new DataInputStream(new FileInputStream("candidatos.ddr"))) {

            //fila inicial
            System.out.println("DNI\t\t\tNombre\t\tEdad\t\tExpec. Salar.");

            //Variables a usar
            String DNI, nombre;
            int edad;
            double exp_sal;

            //Leemos el fichero
            //Cuando no haya datos, saltará la excepcion
            while (true) {

                //cojo los datos y los muestro
                DNI = dis.readUTF();
                System.out.print(DNI + "\t\t");

                nombre = dis.readUTF();
                System.out.print(nombre + "\t");

                edad = dis.readInt();
                System.out.print(edad + "\t\t");

                exp_sal = dis.readDouble();
                System.out.print(exp_sal + "\t\t");

                System.out.println("");

            }

        } catch (EOFException ex) {
            //si llega aqui, es que termino el bucle
            System.out.println("Fin");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        //Pido una expectativa salarial
        System.out.println("Dame la expectativa salarial");
        double exp_sal_usur = sc.nextDouble();

        //repito el proceso, pero con solo mostrando los que cumplan la condicion
        try (DataInputStream dis = new DataInputStream(new FileInputStream("candidatos.ddr"))) {

            //fila inicial
            System.out.println("DNI\t\t\tNombre\t\tEdad\t\tExpec. Salar.");

            //Variables a usar
            String DNI, nombre;
            int edad;
            double exp_sal;

            //leo el fichero
            while (true) {

                //Cojo los datos
                DNI = dis.readUTF();
                nombre = dis.readUTF();
                edad = dis.readInt();
                exp_sal = dis.readDouble();

                //Si se cumple la condicion, se muestra
                if (exp_sal_usur > exp_sal) {
                    System.out.print(DNI + "\t\t");
                    System.out.print(nombre + "\t");
                    System.out.print(edad + "\t\t");
                    System.out.print(exp_sal + "\t\t");
                    System.out.println("");
                }

            }

        } catch (EOFException ex) {
            System.out.println("Fin");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
