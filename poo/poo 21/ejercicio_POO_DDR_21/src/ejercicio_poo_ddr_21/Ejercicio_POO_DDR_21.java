package ejercicio_poo_ddr_21;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Ejercicio_POO_DDR_21 {

    public static void main(String[] args) {

        try {
            Fecha f1 = new Fecha(31, 3, 2018);
            
            Fecha f = new Fecha();
            System.out.println(f);
            
            Date d = new Date(120, 1, 1);
            Fecha fD = new Fecha(d);
            System.out.println(fD);
            
            Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH, 5);
            Fecha fC = new Fecha(c);
            System.out.println(fC);
            
            LocalDate l = LocalDate.of(2020, 5, 5);
            Fecha fL = new Fecha(l);
            System.out.println(fL);
            
            
            System.out.println(f.fechaMayor(fD));
            System.out.println(fD.fechaMayor(f));
            System.out.println(f.fechaIgual(f));
            System.out.println(fC.fechaMenor(fL));
            System.out.println(fL.fechaMenor(fC));
            
            System.out.println(f1.toString());
        } catch (FechaException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
