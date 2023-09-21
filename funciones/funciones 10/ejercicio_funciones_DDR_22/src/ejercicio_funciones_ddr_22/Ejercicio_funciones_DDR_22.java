package ejercicio_funciones_ddr_22;

import java.util.Calendar;

public class Ejercicio_funciones_DDR_22 {
    
    public static void main(String[] args) {
        
        int dia = 1;
        int mes = 8;
        int anio = 2018;
        
        System.out.println(calculaDias(dia, mes, anio, true));
        
    }
    
    public static int calculaDias(int dia, int mes, int anio, boolean incluirFin) {
        
        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);
        inicio.set(Calendar.HOUR, 0);
        inicio.set(Calendar.HOUR_OF_DAY, 0);
        inicio.set(Calendar.MINUTE, 0);
        inicio.set(Calendar.SECOND, 0);
        
        Calendar actual = Calendar.getInstance();
        actual.set(Calendar.HOUR, 0);
        actual.set(Calendar.HOUR_OF_DAY, 0);
        actual.set(Calendar.MINUTE, 0);
        actual.set(Calendar.SECOND, 0);
        
        long finMS = actual.getTimeInMillis();
        long inicioMS = inicio.getTimeInMillis();
        
        int dias = (int) ((Math.abs(finMS - inicioMS)) / (86400000) ); //86400000
        
        if(incluirFin){
            dias++;
        }
        
        return dias;

    }
    
}
