
package ejercicio_thread_ddr_1;

public class HiloNumeroLetras implements Runnable{

    //Atributos
    private int tipo;

    //Constructor
    public HiloNumeroLetras(int tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public void run() {
        
        //Bucle infinito
        while (true) {
            //Segun el tipo hace una u otra cosa
            switch (tipo) {
                case 1:
                    //numeros
                    for (int i = 1; i < 30; i++) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    //letras
                    for (char c = 'a'; c < 'z'; c++) {
                        System.out.println(c);
                    }
                    break;
                    
            }

        }
        
    }
    
}
