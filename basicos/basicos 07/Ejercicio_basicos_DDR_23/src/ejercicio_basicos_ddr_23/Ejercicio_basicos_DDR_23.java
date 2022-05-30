package ejercicio_basicos_ddr_23;

import java.util.Scanner;

public class Ejercicio_basicos_DDR_23 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe un dia de la semana");
        String dia = sn.next();
        
        DiasSemana diaS = DiasSemana.valueOf(dia.toUpperCase());
        
        System.out.println(diaS.toString());
        
        
        
        
        
    }
    
}
