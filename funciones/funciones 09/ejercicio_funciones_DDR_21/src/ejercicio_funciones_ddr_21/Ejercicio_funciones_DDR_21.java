package ejercicio_funciones_ddr_21;

import java.util.Calendar;

public class Ejercicio_funciones_DDR_21 {

    public static void main(String[] args) {
        System.out.println(calcularAnios(13, 7, 1990));
    }

    public static int calcularAnios(int dia, int mes, int anio) {

        //seteamo el dia mes y año
        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);

        //Dia actual
        Calendar actual = Calendar.getInstance();

        //Calcula la diferencia de años
        int diferencia = actual.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);

        //Si el año del dia de la fecha que yo paso es mayor que la actual, resto uno
        if (inicio.get(Calendar.DAY_OF_YEAR) > actual.get(Calendar.DAY_OF_YEAR)) {
            diferencia--;
        }

        return diferencia;

    }

}
