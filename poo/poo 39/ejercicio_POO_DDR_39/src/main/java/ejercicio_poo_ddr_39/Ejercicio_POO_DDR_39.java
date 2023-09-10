package ejercicio_poo_ddr_39;

public class Ejercicio_POO_DDR_39 {

    public static void main(String[] args) {
        
        CartonBingo carton = new CartonBingo();
        
        carton.mostrarCarton();
        
        for (int i = 1; i <= 90; i++) {
            carton.marcar(i);
        }
        
        System.out.println(carton.comprobarLinea());
        
        System.out.println(carton.comprobarBingo());
        
        
    }
}
