package ejercicio_poo_ddr_06;

/**
 * Clase POOrra
 * @author Disco Duro de Roer
 */
public class POOrra implements Constantes{
    
    private double bote;
    
    public POOrra(){
        bote=0;
    }
    
    /**
     * Aumenta la cantidad del bote
     * @param dinero 
     */
    public void aumentarBote(double dinero){
        bote+=dinero;
    }
    
    /**
     * Dejamos el bote a 0
     */
    public void vacirBote(){
        bote=0;
    }
    
    /**
     * Metodo principal que simula el transcurso de la porra
     */
    public void jornadas(){
        
        Resultados resultados = new Resultados();
        String[] partidos;
        
        //Recorremos las jornadas
        for(int i=0;i<NUMERO_JORNADAS;i++){
            
            System.out.println("JORNADA "+(i+1));
            System.out.println("");
            
            //Apuesta
            for(int j=0;j<JUGADORES.length;j++){
                //Si un jugador puede pagar
                if(JUGADORES[j].puedePagar()){
                    //el jugador paga, dice sus resultados y el bote se aumenta
                    JUGADORES[j].ponerEnElBote();
                    JUGADORES[j].generarResultados();
                    aumentarBote(DINERO_CADA_JORNADA);
                }else{
                    //Si no puede pagar, los resultados se vacian
                    JUGADORES[j].reiniciarResultados();
                }
                
            }
            
            
            //Partido
            resultados.generarResultados();
            partidos = resultados.getPartidos();
            
            //Comprobacion
            for(int j=0;j<JUGADORES.length;j++){
                //Indica si ha acertado
                if (JUGADORES[j].haAcertadoPorra(partidos)){
                    //Le damos el bota al jugador y vaciamos el bote
                    JUGADORES[j].ganarBote(bote);
                    vacirBote();
                }
                
            }
            
            System.out.println("");
            System.out.println("");
            
            System.out.println(toString());
            
            System.out.println("");
            System.out.println("");
            
        }
        
        //Motramos el estado de los jugadores
        for(int i=0;i<JUGADORES.length;i++){
            System.out.println(JUGADORES[i]);
        }
        
    }

    @Override
    public String toString() {
        return "En la POOrra hay de bote" + bote + " euro/s";
    }
    
}
