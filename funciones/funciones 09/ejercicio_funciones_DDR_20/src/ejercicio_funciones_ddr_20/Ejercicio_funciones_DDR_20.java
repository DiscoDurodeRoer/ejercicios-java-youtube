package ejercicio_funciones_ddr_20;

import java.util.Date;

public class Ejercicio_funciones_DDR_20 {

    public static void main(String[] args) {

        System.out.println(calcularAnios(11, 7, 1990));
    }

    public static int calcularAnios(int dia, int mes, int anio) {

        //Fecha actual
        Date actual = new Date();

        //Cojo los datos necesarios
        int diaActual = actual.getDate();
        int mesActual = actual.getMonth() + 1;
        int anioActual = actual.getYear() + 1900;

        //Diferencia de años
        int diferencia = anioActual - anio;

        //Si el mes actual es menor que el que me pasan le resto 1
        //Si el mes es igual y el dia que me pasan es mayor al actual le resto 1
        //Si el mes es igual y el dia que me pasan es menor al actual no le resto 1
        if (mesActual <= mes) {
            //si
            if (mesActual == mes) {
                if (dia > diaActual) {
                    diferencia--;
                }
            } else {
                diferencia--;
            }
        }

        return diferencia;

    }

}
