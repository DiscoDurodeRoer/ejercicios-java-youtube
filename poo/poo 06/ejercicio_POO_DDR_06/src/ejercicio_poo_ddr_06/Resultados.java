package ejercicio_poo_ddr_06;

/**
 * Clase Resultados
 * @author Disco Duro de Roer
 */
public class Resultados implements Constantes,MetodosInterfaz{
    
    private String[] partidos;

    public Resultados() {
        partidos=new String[NUMERO_PARTIDOS];
    }

    /**
     * Genera los resultado del partido
     */
    @Override
    public void generarResultados() {
        
        int pLocal, pVisitante;
        
        for(int i=0;i<partidos.length;i++){
            //Generamos los resultados
            pLocal = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
            pVisitante = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
            
            partidos[i] = pLocal +" - "+pVisitante;
            
            System.out.println("El partido "+(i+1)+" ha generado el resultado "+partidos[i]);
        }
        
    }

    public String[] getPartidos() {
        return partidos;
    }

}
