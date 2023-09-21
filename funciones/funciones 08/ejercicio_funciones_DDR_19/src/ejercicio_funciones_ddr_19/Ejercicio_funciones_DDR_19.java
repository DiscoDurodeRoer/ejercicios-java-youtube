package ejercicio_funciones_ddr_19;

import java.util.Date;

public class Ejercicio_funciones_DDR_19 {

    public static void main(String[] args) {
     
        System.out.println(numDias(1));
        System.out.println(numDias(2));
        System.out.println(numDias(4));
        System.out.println(numDias(20));
        System.out.println(numDias(12));
        System.out.println(numDias(6));
        
        
    }
    
    public static int numDias(int mes){
        
        int numDias = 0;
        
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDias = 30;
                break;
            case 2:
                numDias = 28;
                
                int anioActual = new Date().getYear()+1900;
                if(esBisiesto(anioActual)){
                    numDias++;
                }
                
                break;
            default:
                numDias = -1;
        }
        
        return numDias;
        
    }
    
    public static boolean esBisiesto(int anio) {

        if (anio <= 0) {
            return false;
        }

        return (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));

    }
    
}
