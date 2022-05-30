package ejercicio_basicos_ddr_24;

public enum Mes {
    ENERO(1,31),
    FEBRERO(2,28),
    MARZO(3,31),
    ABRIL(4,30),
    MAYO(5,31),
    JUNIO(6,30),
    JULIO(7,31),
    AGOSTO(8,31),
    SEPTIEMBRE(9,30),
    OCTUBRE(10,31),
    NOVIEMBRE(11,30),
    DICIEMBRE(12,31);
    
    private int orden;
    private int numDias;
    
    private Mes(int orden, int numDias){
        
        this.orden=orden;
        this.numDias=numDias;
        
    }

    public int getOrden() {
        return orden;
    }

    public int getNumDias() {
        return numDias;
    }

    @Override
    public String toString() {
        return "El mes "+this.name().toLowerCase()+" es el mes "+orden+"º y tiene "+numDias+" dias";
    }
    
    
    
    
}
