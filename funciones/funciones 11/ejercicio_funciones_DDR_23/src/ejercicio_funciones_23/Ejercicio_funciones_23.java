package ejercicio_funciones_23;

import java.util.Calendar;

public class Ejercicio_funciones_23 {

    public static void main(String[] args) {

        int dia = 22;
        int mes = 8;
        int anio = 2019;

        System.out.println(calculaMeses(dia, mes, anio));

    }

    public static int calculaMeses(int dia, int mes, int anio) {

        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);

        Calendar actual = Calendar.getInstance();

        int anios_diferencia = calcularAnios(dia, mes, anio);

        int meses = Math.abs((anios_diferencia * 12) + (actual.get(Calendar.MONTH) - inicio.get(Calendar.MONTH)));

        if (actual.get(Calendar.DATE) < dia) {
            meses--;
        }

        return meses;

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
