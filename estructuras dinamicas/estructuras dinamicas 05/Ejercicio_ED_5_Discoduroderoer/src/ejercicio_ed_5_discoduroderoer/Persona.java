package ejercicio_ed_5_discoduroderoer;

/**
 * @author DiscoDurodeRoer
 */
public class Persona {
    
    private int edad;
    
    /**
     * Constructor por defecto
     * @param edad
     */
    public Persona(int edad){
        this.edad=edad;
    }

    /**
     * Devuelve la edad
     * @return Edad acutal
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad
     * @param edad Valor edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}