package ejercicio_poo_ddr_19;

public enum TipoPokemon {
    ACERO(0),
    AGUA(1),
    BICHO(2),
    DRAGÓN(3),
    ELÉCTRICO(4),
    FANTASMA(5),
    FUEGO(6),
    HADA(7),
    HIELO(8),
    LUCHA(9),
    NORMAL(10),
    PLANTA(11),
    PSÍQUICO(12),
    ROCA(13),
    SINIESTRO(14),
    TIERRA(15),
    VENENO(16),
    VOLADOR(17);
    
    private int indice;
    
    private TipoPokemon(int indice){
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }
    
}
