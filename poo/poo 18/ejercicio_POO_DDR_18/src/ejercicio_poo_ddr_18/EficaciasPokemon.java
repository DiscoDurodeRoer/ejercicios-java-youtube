package ejercicio_poo_ddr_18;

public enum EficaciasPokemon {
    NO_ES_MUY_EFICAZ("NO ES MUY EFICAZ", 0.5),
    NEUTRO("NEUTRO", 1),
    ES_MUY_EFICAZ("ES MUY EFICAZ", 2),
    NO_AFECTA("NO AFECTA", 0),
    DOBLEMENTE_EFICAZ("DOBLEMENTE EFICAZ", 4),
    DOBLEMENTE_NO_MUY_EFICAZ("DOBLEMENTE NO MUY EFICAZ", 0.25);
    
    private String mensaje;
    private double eficacia;
    
    private EficaciasPokemon(String mensaje, double eficacia){
        this.mensaje = mensaje;
        this.eficacia = eficacia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public double getEficacia() {
        return eficacia;
    }

    
    
}
