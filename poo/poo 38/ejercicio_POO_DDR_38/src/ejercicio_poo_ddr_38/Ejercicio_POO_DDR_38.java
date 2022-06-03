package ejercicio_poo_ddr_38;

public class Ejercicio_POO_DDR_38 {

    public static void main(String[] args) {
        
        Dado d = new Dado();
        
        int puntosJ1 = 0;
        int puntosJ2 = 0;
        
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                puntosJ1 += d.tirarDado();
            }else{
                puntosJ2 += d.tirarDado();
            }
        }
        
        System.out.println("Punto J1: " + puntosJ1);
        System.out.println("Punto J2: " + puntosJ2);
        
        if(puntosJ1 == puntosJ2){
            System.out.println("Empate");
        }else if(puntosJ1 > puntosJ2){
            System.out.println("J1 gana");
        }else{
            System.out.println("J2 gana");
        }
        
        
    }
}