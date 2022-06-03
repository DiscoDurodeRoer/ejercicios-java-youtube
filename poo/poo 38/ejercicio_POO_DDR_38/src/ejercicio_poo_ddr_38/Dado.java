package ejercicio_poo_ddr_38;

public class Dado {

    private int numeroCaras;
    
    public Dado(){
        this.numeroCaras = 6;
    }
    
    public Dado(int numeroCaras){
        this.numeroCaras = numeroCaras;
    }
    
    public int tirarDado(){
        return this.generaNumeroAleatorio(1, this.numeroCaras);
    }
    
    public int[] tirarDadoNveces(int n){
        int[] valores = new int[n];
        for (int i = 0; i < valores.length; i++) {
            valores[i]=this.tirarDado();
        }
        return valores;
    }
    
    private int generaNumeroAleatorio(int minimo,int maximo){
       int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
       return num;
    }
    
}
