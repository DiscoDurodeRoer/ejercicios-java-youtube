package ejercicio_poo_ddr_06;

/**
 * Clase Jugador
 * @author Disco Duro de Roer
 */
public class Jugador implements Constantes, MetodosInterfaz{
 
    private String nombre;
    private double dinero;
    private int porrasGanadas;
    private String[] resultados;
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.dinero = DINERO_INICIAL;
        this.porrasGanadas=0;
        this.resultados = new String[NUMERO_PARTIDOS];
        reiniciarResultados();
    }
    
    public void reiniciarResultados(){
        
        for(int i=0;i<resultados.length;i++){
            resultados[i]="";
        }
        
    }
    
    public boolean puedePagar(){
        return dinero>=DINERO_CADA_JORNADA;
    }
    
    public void ponerEnElBote(){
        dinero-=DINERO_CADA_JORNADA;
        System.out.println("Jugador "+nombre+" ha puesto "+DINERO_CADA_JORNADA+" euro/s y le queda "+dinero+" euro/s");
    }
    
    public void ganarBote(double bote){
        dinero+=bote;
        porrasGanadas++;
        System.out.println("Jugador "+nombre+" ha ganado "+bote+" euro/s y tiene "+dinero+" euro/s");
    }
    
    @Override
    public void generarResultados() {
        
        int pLocal, pVisitante;
        
        for(int i=0;i<resultados.length;i++){
            pLocal = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
            pVisitante = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
            
            resultados[i] = pLocal +" - "+pVisitante;
            
            System.out.println("El Jugador "+nombre+" ha elegido el resultado "+resultados[i]);
            
        }
        System.out.println("");
    }
    
    public boolean haAcertadoPorra(String[] resultados_partidos){
        
        for(int i=0;i<resultados.length;i++){
            if(!resultados[i].equals(resultados_partidos[i])){
                return false;
            }    
        }
        return true;
        
    }
    
    
    

    @Override
    public String toString() {
        return "El jugador " + nombre + " tiene dinero=" + dinero + " y ha ganado " + porrasGanadas + " porra/s";
    }
    
    
    
    
    
}
