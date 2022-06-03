
package ejercicio_poo_ddr_22;

public class Ejercicio_POO_DDR_22 {

    public static void main(String[] args) {

        Mano j1 = Mano.PAPEL;
        Mano j2 = Mano.PAPEL;
        
        PiedraPapelTijera ppt = new PiedraPapelTijera();
        
        int ganador = ppt.ganador(j1, j2);
        
        switch(ganador){
            case 0:
                System.out.println("Empate");
                break;
            case 1:
                System.out.println("J1 gana");
                break;
            case -1:
                System.out.println("J2 gana");
                break;
        }
        
        
        
    }

}
