package ejercicio_poo_ddr_2;

/**
 * Clase Raices
 * Representa una ecuacion de 2º grado
 * @author discoduroderoer
 */
public class Raices {
    
    /*Atributos*/
    private double a;
    private double b;
    private double c;
    
    /**
     * Ecuacion de 2º grado
     * @param a
     * @param b
     * @param c 
     */
    public Raices(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    /**
     * Metodos para obtener las raices cuando hay 2 soluciones posibles
     */
    private void obtenerRaices(){
        
        double x1=(-b+Math.sqrt(getDiscriminante()))/(2*a);
        double x2=(-b-Math.sqrt(getDiscriminante()))/(2*a);
        
        System.out.println("Solucion X1");
        System.out.println(x1);
        System.out.println("Solucion X2");
        System.out.println(x2);
    }
    
    /**
     * Obtiene una unica raiz, cuando solo tiene la posibilidad de er una solucion
     */
    private void obtenerRaiz(){
        
        double x=(-b)/(2*a);
        
        System.out.println("Unica solucion");
        System.out.println(x);
        
    }
    
    /**
     * Nos devuelve el valor del discriminante,  
     * @return 
     */
    private double getDiscriminante(){
        return Math.pow(b, 2)-(4*a*c);
    }
    
    /**
     * Si el discriminante es mayor que 0 tiene mas de una raiz
     * (No hemos puesto >= ya que puede confundirse con una solucion)
     * @return 
     */
    private boolean tieneRaices(){
        return getDiscriminante()>0;
    }
    
    /**
     * Si el discriminante es igual a cero tiene una sola raiz
     * @return 
     */
    private boolean tieneRaiz(){
        return getDiscriminante()==0;
    }
    
    /**
     * Nos permite calcular las raices de una ecuacion de 2º grado
     */
    public void calcular(){
        
        if(tieneRaices()){
            obtenerRaices();
        }else if(tieneRaiz()){
            obtenerRaiz();
        }else{
            System.out.println("No tiene soluciones");
        }
        
    }
    
}
