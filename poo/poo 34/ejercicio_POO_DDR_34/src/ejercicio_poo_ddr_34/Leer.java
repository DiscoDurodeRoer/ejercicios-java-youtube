/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_poo_ddr_34;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase para gestionar entrada de datos y validaciones
 *
 * @author DiscoDurodeRoer
 */
public class Leer {

    //Scanner para pedir datos
    private Scanner sc;

    /**
     * Por defecto
     */
    public Leer() {
        sc = new Scanner(System.in);
        sc.useDelimiter("\n"); //Usado para nextLine()
        sc.useLocale(Locale.US); // Para double
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByte() {

        byte num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero byte");
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero byte");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByte(String mensaje) {

        byte num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero byte");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByte(String mensaje, String mensajeError) {

        byte num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero byte positivo introducido por el usuario
     */
    public byte pedirBytePositivo() {

        byte num;
        do {
            try {
                System.out.println("Introduce un numero entero byte positivo");
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero byte positivo");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero byte positivo introducido por el usuario
     */
    public byte pedirBytePositivo(String mensaje) {

        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero byte positivo");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte positivo introducido por el usuario
     */
    public byte pedirBytePositivo(String mensaje, String mensajeError) {

        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println(mensajeError);
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero byte negativo introducido por el usuario
     */
    public byte pedirByteNegativo() {
        byte num;
        do {
            try {
                System.out.println("Introduce un numero entero byte negativo");
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero byte negativo");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero byte negativo introducido por el usuario
     */
    public byte pedirByteNegativo(String mensaje) {
        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero byte negativo");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte negativo introducido por el usuario
     */
    public byte pedirByteNegativo(String mensaje, String mensajeError) {
        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println(mensajeError);
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByteRango(byte minimo, byte maximo) {
        byte num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            byte aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println("Introduce un numero byte entre " + minimo + " y " + maximo);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero byte entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByteRango(byte minimo, byte maximo, String mensaje) {
        byte num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            byte aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero byte entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByteRango(byte minimo, byte maximo, String mensaje, String mensajeError) {
        byte num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            byte aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero introducido por el usuario
     */
    public int pedirInt() {

        int num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero integer");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero integer");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public int pedirInt(String mensaje) {

        int num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero integer");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public int pedirInt(String mensaje, String mensajeError) {

        int num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero positivo introducido por el usuario
     */
    public int pedirIntPositivo() {

        int num;
        do {
            try {
                System.out.println("Introduce un numero entero positivo integer");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo integer");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero positivo introducido por el usuario
     */
    public int pedirIntPositivo(String mensaje) {

        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo integer");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero positivo introducido por el usuario
     */
    public int pedirIntPositivo(String mensaje, String mensajeError) {

        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println(mensajeError);
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero negativo introducido por el usuario
     */
    public int pedirIntNegativo() {
        int num;
        do {
            try {
                System.out.println("Introduce un numero entero negativo integer");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo integer");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero negativo introducido por el usuario
     */
    public int pedirIntNegativo(String mensaje) {
        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo integer");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero negativo introducido por el usuario
     */
    public int pedirIntNegativo(String mensaje, String mensajeError) {
        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println(mensajeError);
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo) {
        int num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println("Introduce un numero integer entre " + minimo + " y " + maximo);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero integer entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo, String mensaje) {
        int num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero integer entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo, String mensaje, String mensajeError) {
        int num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide una cadena
     *
     * @return cadena introducida por el usuario
     */
    public String pedirString() {

        System.out.println("Introduce una cadena");
        String cadena = sc.next();

        return cadena;

    }

    /**
     * Pide una cadena
     *
     * @param mensaje
     * @return cadena introducida por el usuario
     */
    public String pedirString(String mensaje) {

        System.out.println(mensaje);
        String cadena = sc.next();

        return cadena;

    }

    /**
     * Pide una cadena con una longitud maxima
     *
     * @param longitudMaxima
     * @return cadena introducida por el usuario
     */
    public String pedirString(int longitudMaxima) {

        String cadena = "";
        do {
            System.out.println("Introduce una cadena");
            cadena = sc.next();

            if (!(cadena.length() < longitudMaxima)) {
                System.out.println("Error, la longitud maxima es " + longitudMaxima + " caracteres");
            }

        } while (!(cadena.length() < longitudMaxima));

        return cadena;

    }

    /**
     * Pide una cadena con una longitud maxima
     *
     * @param longitudMaxima
     * @param mensaje
     * @return cadena introducida por el usuario
     */
    public String pedirString(int longitudMaxima, String mensaje) {

        String cadena = "";
        do {
            System.out.println(mensaje);
            cadena = sc.next();

            if (!(cadena.length() < longitudMaxima)) {
                System.out.println("Error, la longitud maxima es " + longitudMaxima + " caracteres");
            }

        } while (!(cadena.length() < longitudMaxima));

        return cadena;

    }

    /**
     * Pide una cadena con una longitud maxima
     *
     * @param longitudMaxima
     * @param mensaje
     * @param mensajeError
     * @return cadena introducida por el usuario
     */
    public String pedirString(int longitudMaxima, String mensaje, String mensajeError) {

        String cadena = "";
        do {
            System.out.println(mensaje);
            cadena = sc.next();

            if (!(cadena.length() < longitudMaxima)) {
                System.out.println(mensajeError);
            }

        } while (!(cadena.length() < longitudMaxima));

        return cadena;

    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero introducido por el usuario
     */
    public long pedirLong() {

        long num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero long");
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero long");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public long pedirLong(String mensaje) {

        long num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero long");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public long pedirLong(String mensaje, String mensajeError) {

        long num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero byte positivo introducido por el usuario
     */
    public long pedirLongPositivo() {

        long num;
        do {
            try {
                System.out.println("Introduce un numero entero positivo long");
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo long");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero byte positivo introducido por el usuario
     */
    public long pedirLongPositivo(String mensaje) {

        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo long");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte positivo introducido por el usuario
     */
    public long pedirLongPositivo(String mensaje, String mensajeError) {

        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println(mensajeError);
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero byte negativo introducido por el usuario
     */
    public long pedirLongNegativo() {
        long num;
        do {
            try {
                System.out.println("Introduce un numero entero negativo long");
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo long");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero byte negativo introducido por el usuario
     */
    public long pedirLongNegativo(String mensaje) {
        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo long");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte negativo introducido por el usuario
     */
    public long pedirLongNegativo(String mensaje, String mensajeError) {
        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println(mensajeError);
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero byte introducido por el usuario
     */
    public long pedirLongRango(long minimo, long maximo) {
        long num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println("Introduce un numero long entre " + minimo + " y " + maximo);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero long entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public long pedirLongRango(long minimo, long maximo, String mensaje) {
        long num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero long entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public long pedirLongRango(long minimo, long maximo, String mensaje, String mensajeError) {
        long num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero introducido por el usuario
     */
    public short pedirShort() {

        short num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero short");
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero short");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public short pedirShort(String mensaje) {

        short num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero short");
            }

        } while (!correcto);

        return num;
    }

    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public short pedirShort(String mensaje, String mensajeError) {

        short num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero byte positivo introducido por el usuario
     */
    public short pedirShortPositivo() {

        short num;
        do {
            try {
                System.out.println("Introduce un numero entero positivo short");
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo short");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero byte positivo introducido por el usuario
     */
    public short pedirShortPositivo(String mensaje) {

        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo short");
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte positivo introducido por el usuario
     */
    public short pedirShortPositivo(String mensaje, String mensajeError) {

        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }

            if (num < 0) {
                System.out.println(mensajeError);
            }

        } while (num < 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero byte negativo introducido por el usuario
     */
    public short pedirShortNegativo() {
        short num;
        do {
            try {
                System.out.println("Introduce un numero entero negativo short");
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo short");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero byte negativo introducido por el usuario
     */
    public short pedirShortNegativo(String mensaje) {
        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo short");
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte negativo introducido por el usuario
     */
    public short pedirShortNegativo(String mensaje, String mensajeError) {
        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }

            if (num >= 0) {
                System.out.println(mensajeError);
            }

        } while (num >= 0);

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero byte introducido por el usuario
     */
    public short pedirShortRango(long minimo, long maximo) {
        short num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println("Introduce un numero short entre " + minimo + " y " + maximo);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero short entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public short pedirShortRango(short minimo, short maximo, String mensaje) {
        short num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            short aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero short entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public short pedirShortRango(short minimo, short maximo, String mensaje, String mensajeError) {
        short num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            short aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un double, valida que sea un numero
     *
     * @return double introducido por el usuario
     */
    public double pedirDouble() {

        double real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real double");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real double");
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un double, valida que sea un numero
     *
     * @param mensaje
     * @return double introducido por el usuario
     */
    public double pedirDouble(String mensaje) {

        double real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real");
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un double, valida que sea un numero
     *
     * @param mensaje
     * @param mensajeError
     * @return double introducido por el usuario
     */
    public double pedirDouble(String mensaje, String mensajeError) {

        double real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un double positivo, valida que sea un numero y positivo
     *
     * @return double positivo introducido por el usuario
     */
    public double pedirDoublePositivo() {

        double real;
        do {
            try {
                System.out.println("Introduce un numero real positivo double");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un double positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @return double positivo introducido por el usuario
     */
    public double pedirDoublePositivo(String mensaje) {

        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un double positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return double positivo introducido por el usuario
     */
    public double pedirDoublePositivo(String mensaje, String mensajeError) {

        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println(mensajeError);
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un double negativo, valida que sea un numero y negativo
     *
     * @return double negativo introducido por el usuario
     */
    public double pedirDoubleNegativo() {
        double real;
        do {
            try {
                System.out.println("Introduce un numero real negativo double");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }

            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo double");
            }

        } while (real >= 0);

        return real;
    }

    /**
     * Pide un double negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @return double negativo introducido por el usuario
     */
    public double pedirDoubleNegativo(String mensaje) {
        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }

            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo double");
            }

        } while (real >= 0);

        return real;
    }

    /**
     * Pide un double negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return double negativo introducido por el usuario
     */
    public double pedirDoubleNegativo(String mensaje, String mensajeError) {
        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }

            if (real >= 0) {
                System.out.println(mensajeError);
            }

        } while (real >= 0);

        return real;
    }

    /**
     * Pide un double entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @return double entre un rango introducido por el usuario
     */
    public double pedirDoubleRango(double minimo, double maximo) {

        double real;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            double aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println("Introduce un numero double entre " + minimo + " y " + maximo);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }

            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero double entre " + minimo + " y " + maximo + " como maximo");
            }

        } while (!(real >= minimo && real <= maximo));

        return real;
    }

    /**
     * Pide un double entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return double entre un rango introducido por el usuario
     */
    public double pedirDoubleRango(double minimo, double maximo, String mensaje) {

        double real;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            double aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }

            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero double entre " + minimo + " y " + maximo + " como maximo");
            }

        } while (!(real >= minimo && real <= maximo));

        return real;
    }

    /**
     * Pide un double entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return double entre un rango introducido por el usuario
     */
    public double pedirDoubleRango(double minimo, double maximo, String mensaje, String mensajeError) {

        double real;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            double aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }

            if (!(real >= minimo && real <= maximo)) {
                System.out.println(mensajeError);
            }

        } while (!(real >= minimo && real <= maximo));

        return real;
    }

    /**
     * Pide un double, con un numero de decimales como maximo
     *
     * @param decimales
     * @return double con un double con unos decimales menos que lo indicado
     */
    public double pedirDoubleDecimales(int decimales) {

        if (decimales < 1) {
            decimales = 1;
        }

        double real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real double con " + decimales + " decimales como maximo");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real double");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un double, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return double con un double con unos decimales menos que lo indicado
     */
    public double pedirDoubleDecimales(int decimales, String mensaje) {

        if (decimales < 1) {
            decimales = 1;
        }

        double real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real double");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un double, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return double con un double con unos decimales menos que lo indicado
     */
    public double pedirDoubleDecimales(int decimales, String mensaje, String mensajeError) {

        if (decimales < 1) {
            decimales = 1;
        }

        double real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un double positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @return double con un double positivo con unos decimales menos que lo
     * indicado
     */
    public double pedirDoublePositivoDecimales(int decimales) {

        double real;
        String[] parteDecimal;
        do {
            try {
                System.out.println("Introduce un numero real positivo double con " + decimales + " decimales como maximo");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un double positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return double con un double positivo con unos decimales menos que lo
     * indicado
     */
    public double pedirDoublePositivoDecimales(int decimales, String mensaje) {

        double real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un double positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return double con un double positivo con unos decimales menos que lo
     * indicado
     */
    public double pedirDoublePositivoDecimales(int decimales, String mensaje, String mensajeError) {

        double real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un float, valida que sea un numero
     *
     * @return float introducido por el usuario
     */
    public float pedirFloat() {

        float real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real float");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real float");
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un float, valida que sea un numero
     *
     * @param mensaje
     * @return float introducido por el usuario
     */
    public float pedirFloat(String mensaje) {

        float real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real float");
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un float, valida que sea un numero
     *
     * @param mensaje
     * @param mensajeError
     * @return float introducido por el usuario
     */
    public float pedirFloat(String mensaje, String mensajeError) {

        float real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un float positivo, valida que sea un numero y positivo
     *
     * @return float positivo introducido por el usuario
     */
    public float pedirFloatPositivo() {

        float real;
        do {
            try {
                System.out.println("Introduce un numero real positivo float");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un float positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @return float positivo introducido por el usuario
     */
    public float pedirFloatPositivo(String mensaje) {

        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un float positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return float positivo introducido por el usuario
     */
    public float pedirFloatPositivo(String mensaje, String mensajeError) {

        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println(mensajeError);
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un float negativo, valida que sea un numero y negativo
     *
     * @return float negativo introducido por el usuario
     */
    public float pedirFloatNegativo() {
        float real;
        do {
            try {
                System.out.println("Introduce un numero real negativo float");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }

            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo float");
            }

        } while (real >= 0);

        return real;
    }

    /**
     * Pide un float negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @return float negativo introducido por el usuario
     */
    public float pedirFloatNegativo(String mensaje) {
        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }

            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo float");
            }

        } while (real >= 0);

        return real;
    }

    /**
     * Pide un float negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return float negativo introducido por el usuario
     */
    public float pedirFloatNegativo(String mensaje, String mensajeError) {
        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }

            if (real >= 0) {
                System.out.println(mensajeError);
            }

        } while (real >= 0);

        return real;
    }

    /**
     * Pide un float entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @return float entre un rango introducido por el usuario
     */
    public float pedirFloatRango(float minimo, float maximo) {

        float real;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            float aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println("Introduce un numero float entre " + minimo + " y " + maximo);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }

            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero float entre " + minimo + " y " + maximo + " como maximo");
            }

        } while (!(real >= minimo && real <= maximo));

        return real;
    }

    /**
     * Pide un float entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return float entre un rango introducido por el usuario
     */
    public float pedirFloatRango(float minimo, float maximo, String mensaje) {

        float real;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            float aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }

            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero float entre " + minimo + " y " + maximo + " como maximo");
            }

        } while (!(real >= minimo && real <= maximo));

        return real;
    }

    /**
     * Pide un float entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return float entre un rango introducido por el usuario
     */
    public float pedirFloatRango(float minimo, float maximo, String mensaje, String mensajeError) {

        float real;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            float aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }

            if (!(real >= minimo && real <= maximo)) {
                System.out.println(mensajeError);
            }

        } while (!(real >= minimo && real <= maximo));

        return real;
    }

    /**
     * Pide un float, con un numero de decimales como maximo
     *
     * @param decimales
     * @return float con unos decimales menos que lo indicado
     */
    public float pedirFloatDecimales(int decimales) {

        if (decimales < 1) {
            decimales = 1;
        }

        float real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real float con " + decimales + " decimales como maximo");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real float");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un float, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return float con unos decimales menos que lo indicado
     */
    public float pedirFloatDecimales(int decimales, String mensaje) {

        if (decimales < 1) {
            decimales = 1;
        }

        float real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println("Error, introduce un numero real float con " + decimales + " decimales como maximo");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un float, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return float con unos decimales menos que lo indicado
     */
    public float pedirFloatDecimales(int decimales, String mensaje, String mensajeError) {

        if (decimales < 1) {
            decimales = 1;
        }

        float real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }

            if (!correcto) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }

        } while (!correcto);

        return real;

    }

    /**
     * Pide un float positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @return float positivo con unos decimales menos que lo indicado
     */
    public float pedirFloatPositivoDecimales(int decimales) {

        float real;
        String[] parteDecimal;
        do {
            try {
                System.out.println("Introduce un numero real positivo float con " + decimales + " decimales como maximo");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un float positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return double con un float positivo con unos decimales menos que lo
     * indicado
     */
    public float pedirFloatPositivoDecimales(int decimales, String mensaje) {

        float real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un float positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return float positivo con unos decimales menos que lo indicado
     */
    public float pedirFloatPositivoDecimales(int decimales, String mensaje, String mensajeError) {

        float real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }

            if (real < 0) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\\.");

                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }

        } while (real < 0);

        return real;
    }

    /**
     * Pide un char, si tiene mas de un caracter, coge el primero
     *
     * @return
     */
    public char pedirChar() {

        System.out.println("Introduce un caracter (en caso de tener mas de un caracter, se cogera el primer caracter)");
        char caracter = sc.next().charAt(0);

        return caracter;

    }

    /**
     * Pide un char, si tiene mas de un caracter, coge el primero
     *
     * @param mensaje
     * @return
     */
    public char pedirChar(String mensaje) {

        System.out.println(mensaje);
        char caracter = sc.next().charAt(0);

        return caracter;

    }

    /**
     * Pide un booleano, valida que sea un booleano
     *
     * @return booleano introducido por el usuario
     */
    public boolean pedirBoolean() {

        boolean booleano = false, correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un booleano (true o false)");
                booleano = sc.nextBoolean();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }

        } while (!correcto);

        return booleano;
    }

    /**
     * Pide un booleano, valida que sea un booleano
     *
     * @param mensaje
     * @return booleano introducido por el usuario
     */
    public boolean pedirBoolean(String mensaje) {

        boolean booleano = false, correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                booleano = sc.nextBoolean();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }

        } while (!correcto);

        return booleano;
    }

    /**
     * Pide un booleano, valida que sea un booleano
     *
     * @param mensaje
     * @param mensajeError
     * @return booleano introducido por el usuario
     */
    public boolean pedirBoolean(String mensaje, String mensajeError) {

        boolean booleano = false, correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                booleano = sc.nextBoolean();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return booleano;
    }

    /**
     * Pide al usuario un si o un no, true = si, no = false
     *
     * @return booleano introducido por el usuario
     */
    public boolean pedirBooleanSiNo() {

        boolean correcto, booleano = false;
        String respuesta = "";
        do {
            correcto = true;
            try {
                System.out.println("Introduce Si o No");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase().trim();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }

            if (respuesta.equals("si")) {
                booleano = true;
            } else if (respuesta.equals("no")) {
                booleano = false;
            } else {
                correcto = false;
            }

            if (!(respuesta.equals("si")) || respuesta.equals("no")) {
                correcto = false;
            }

            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }

        } while (!correcto);

        return booleano;
    }

    /**
     * Pide al usuario un si o un no, true = si, no = false
     *
     * @param mensaje
     * @return booleano introducido por el usuario
     */
    public boolean pedirBooleanSiNo(String mensaje) {

        boolean correcto, booleano = false;
        String respuesta = "";
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase().trim();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }

            if (respuesta.equals("si")) {
                booleano = true;
            } else if (respuesta.equals("no")) {
                booleano = false;
            } else {
                correcto = false;
            }

            if (!(respuesta.equals("si")) || respuesta.equals("no")) {
                correcto = false;
            }

            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }

        } while (!correcto);

        return booleano;
    }

    /**
     * Pide al usuario un si o un no, true = si, no = false
     *
     * @param mensaje
     * @param mensajeError
     * @return booleano introducido por el usuario
     */
    public boolean pedirBooleanSiNo(String mensaje, String mensajeError) {

        boolean correcto, booleano = false;
        String respuesta = "";
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase().trim();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }

            if (respuesta.equals("si")) {
                booleano = true;
            } else if (respuesta.equals("no")) {
                booleano = false;
            } else {
                correcto = false;
            }

            if (!(respuesta.equals("si")) || respuesta.equals("no")) {
                correcto = false;
            }

            if (!correcto) {
                System.out.println(mensajeError);
            }

        } while (!correcto);

        return booleano;
    }

}
