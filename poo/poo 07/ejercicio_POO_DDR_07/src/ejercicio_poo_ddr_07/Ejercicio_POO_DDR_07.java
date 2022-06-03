package ejercicio_poo_ddr_07;

/**
 * @author Discoduroderoer
 */
public class Ejercicio_POO_DDR_07 {

    public static void main(String[] args) {
        
        Juego juego = new Juego(2);
        
        while( !juego.finJuego() ){
            juego.ronda();            
            //juego.rondaV2();
        }
        
        System.out.println("El juego ha terminado");
        
    }
    
}
