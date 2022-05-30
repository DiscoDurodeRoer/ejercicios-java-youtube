package ejercicio_basicos_ddr_23;


public enum DiasSemana {
    LUNES(true),
    MARTES(true),
    MIERCOLES(true),
    JUEVES(true),
    VIERNES(true),
    SABADO(false),
    DOMINGO(false);
    
    private boolean laborable;
    
    private DiasSemana(boolean laborable){
        this.laborable = laborable;
    }

    @Override
    public String toString() {
        
        if(laborable){
            return "El dia "+ this.name().toLowerCase() +" es laborable";
        }else{
            return "El dia "+  this.name().toLowerCase() +" no es laborable";
        }
        
    }
    
    
    
}
