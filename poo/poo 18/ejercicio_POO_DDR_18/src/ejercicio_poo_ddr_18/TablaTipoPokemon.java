package ejercicio_poo_ddr_18;

public class TablaTipoPokemon {
 
    public double[][] efectividadesPokemon;
    
    public TablaTipoPokemon(){
        this.rellenarDatosEfectividades();
    }
    
    private void rellenarDatosEfectividades(){
        double[][] efectividadesPokemon = {
            /*ACERO   AGUA   BICHO   DRAGON   ELÉC   FANT   FUEGO   HADA   HIELO   LUCHA   NORMAL   PLANTA   PSI   ROCA   SINIE  TIERRA   VENENO   VOLADOR   */
            { 0.5   , 0.5  ,   1   ,   1    , 0.5  ,  1   ,  0.5   ,  2  ,   2   ,   1   ,    1    ,   1   ,  1   ,  2  ,   1   ,   1   ,    1   ,   1},   //ACERO
            {  1    , 0.5  ,   1   ,  0.5   ,  1   ,  1   ,   2    ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  2  ,   1   ,   2   ,    1   ,   1},   //AGUA
            { 0.5   ,  1   ,   1   ,   1    ,  1   , 0.5  ,  0.5   , 0.5 ,   1   ,  0.5  ,    1    ,   2   ,  2   ,  1  ,   2   ,   1   ,   0.5  ,  0.5},  //BICHO
            { 0.5   ,  1   ,   1   ,   2    ,  1   ,  1   ,   1    ,  0  ,   1   ,   1   ,    1    ,   1   ,  1   ,  1  ,   1   ,   1   ,    1   ,   1},   // DRAGÓN
            {  1    ,  2   ,   1   ,  0.5   , 0.5  ,  1   ,   1    ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  1  ,   1   ,   0   ,    1   ,   2},   // ELÉCTRICO
            {  1    ,  1   ,   1   ,   1    ,  1   ,  2   ,   1    ,  1  ,   1   ,   1   ,    0    ,   1   ,  2   ,  1  ,  0.5  ,   1   ,    1   ,   1},   // FANTASMA
            {  2    , 0.5  ,   2   ,  0.5   ,  1   ,  1   ,  0.5   ,  1  ,   2   ,   1   ,    1    ,   2   ,  1   , 0.5 ,   1   ,   1   ,    1   ,   1},   // FUEGO
            { 0.5   ,  1   ,   1   ,   2    ,  1   ,  1   ,  0.5   ,  1  ,   1   ,   2   ,    1    ,   1   ,  1   ,  1  ,   2   ,   1   ,   0.5  ,   1},   // HADA
            { 0.5   , 0.5  ,   1   ,   2    ,  1   ,  1   ,  0.5   ,  1  ,  0.5  ,   1   ,    1    ,   2   ,  1   ,  1  ,   1   ,   2   ,    1   ,   2},   // HIELO
            {  2    ,  1   ,  0.5  ,   1    ,  1   ,  0   ,   1    , 0.5 ,   2   ,   1   ,    2    ,   1   , 0.5  ,  2  ,   2   ,   1   ,   0.5  ,  0.5},  // LUCHA
            { 0.5   ,  1   ,   1   ,   1    ,  1   ,  0   ,   1    ,  1  ,   1   ,   1   ,    1    ,   1   ,  1   , 0.5 ,   1   ,   1   ,    1   ,   1},   // NORMAL
            { 0.5   ,  2   ,  0.5  ,  0.5   ,  1   ,  1   ,  0.5   ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  2  ,   1   ,   2   ,   0.5  ,  0.5},  // PLANTA
            { 0.5   ,  1   ,   1   ,   1    ,  1   ,  1   ,   1    ,  1  ,   1   ,   2   ,    1    ,   1   , 0.5  ,  1  ,   0   ,   1   ,    2   ,   1},   // PSÍQUICO
            { 0.5   ,  1   ,   2   ,   1    ,  1   ,  1   ,   2    ,  1  ,   2   ,  0.5  ,    1    ,   1   ,  1   ,  1  ,   1   ,  0.5  ,    1   ,   2},   // ROCA
            {  1    ,  1   ,   1   ,   1    ,  1   ,  2   ,   1    , 0.5 ,   1   ,  0.5  ,    1    ,   1   ,  2   ,  1  ,  0.5  ,   1   ,    1   ,   1},   // SINIESTRO
            {  2    ,  1   ,  0.5  ,   1    ,  2   ,  1   ,   2    ,  1  ,   1   ,   1   ,    1    ,  0.5  ,  1   ,  2  ,   1   ,   1   ,    2   ,   0},   // TIERRA
            {  0    ,  1   ,   1   ,   1    ,  1   , 0.5  ,   1    ,  2  ,   1   ,   1   ,    1    ,   2   ,  1   , 0.5 ,   1   ,  0.5  ,   0.5  ,   1},   // VENENO
            { 0.5   ,  1   ,   2   ,   1    , 0.5  ,  1   ,   1    ,  1  ,   1   ,   2   ,    1    ,   2   ,  1   , 0.5 ,   1   ,   1   ,    1   ,   1}    // VOLADOR
        };
        
        this.efectividadesPokemon = efectividadesPokemon;
    }
    
}
