package ejercicio_poo_ddr_15;


public class Ejercicio_POO_DDR_15 {

    public static void main(String[] args) {

        try {
            Fecha f1 = new Fecha(31, 3, 2018);
            System.out.println(f1.toString());
        } catch (FechaException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
