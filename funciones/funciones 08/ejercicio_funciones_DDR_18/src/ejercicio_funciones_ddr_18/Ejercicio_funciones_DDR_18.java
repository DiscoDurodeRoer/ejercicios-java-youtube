package ejercicio_funciones_ddr_18;

public class Ejercicio_funciones_DDR_18 {

    public static void main(String[] args) {

        System.out.println(esBisiesto(2018));
        System.out.println(esBisiesto(2000));
        System.out.println(esBisiesto(2100));
        System.out.println(esBisiesto(1600));
        System.out.println(esBisiesto(2300));
        System.out.println(esBisiesto(2004));
        System.out.println(esBisiesto(2008));
        System.out.println(esBisiesto(-2008));
        
        
    }

    public static boolean esBisiesto(int anio) {

        if (anio <= 0) {
            return false;
        }

        return (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));

    }

}
