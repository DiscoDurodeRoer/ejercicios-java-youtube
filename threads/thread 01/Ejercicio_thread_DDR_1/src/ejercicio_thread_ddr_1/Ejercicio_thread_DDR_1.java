package ejercicio_thread_ddr_1;

public class Ejercicio_thread_DDR_1 {

    public static void main(String[] args) {
        
        HiloNumeroLetras h1 = new HiloNumeroLetras(1);
        HiloNumeroLetras h2 = new HiloNumeroLetras(2);
        
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        
        t1.start();
        t2.start();
        
    }

}
