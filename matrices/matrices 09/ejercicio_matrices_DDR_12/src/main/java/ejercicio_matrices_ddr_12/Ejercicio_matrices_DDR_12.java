package ejercicio_matrices_ddr_12;

public class Ejercicio_matrices_DDR_12 {

    public static void main(String[] args) {

        int[][] m = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };
        
        int resultado[][] = adyacentesA(m.length, m[0].length, 1, 1);
        
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
    
    public static int[][] adyacentesA(int filas, int columnas, int filaOrigen, int columnaOrigen){
    
        if( !(filaOrigen >= 0 && filaOrigen <= (filas - 1) && columnaOrigen >= 0 && columnaOrigen <= (columnas - 1)) ){
            return null;
        }
        
        int numPosiciones;
        
        if(filaOrigen == 0 || filaOrigen == (filas -1)){
            if(columnaOrigen == 0 || columnaOrigen == (columnas -1 )){
                numPosiciones = 3;
            }else{
                numPosiciones = 5;
            }
        } else{
            if(columnaOrigen == 0 || columnaOrigen == (columnas -1 )){
                numPosiciones = 5;
            }else{
                numPosiciones = 8;
            }
        }
        
        int posiciones[][] = new int[numPosiciones][2];
        
        int indicePosicion=0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                
                if( (i != 0 || j != 0)
                        && (filaOrigen + i) >= 0 
                        && (filaOrigen + i) <= (filas - 1)
                        && (columnaOrigen + j) >= 0
                        && (columnaOrigen + j) <= (columnas - 1)){
                    posiciones[indicePosicion][0] = filaOrigen + i;
                    posiciones[indicePosicion][1] = columnaOrigen + j;
                    indicePosicion++;
                }
                
            }
        }
        
        
        return posiciones;
    }
    
    

}
