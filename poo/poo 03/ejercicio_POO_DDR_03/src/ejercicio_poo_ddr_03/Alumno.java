package ejercicio_poo_ddr_03;

//Clase Alumno, hereda de la clase Persona
public class Alumno extends Persona{
    
    /*Atributos*/
    private int nota;
    
    /*Constructor*/
    public Alumno(){
        super();
        
        nota=MetodosSueltos.generaNumeroAleatorio(0,10);
        
        super.setEdad(MetodosSueltos.generaNumeroAleatorio(12,15));
        
    }

    /*Metodos*/
    
    /**
     * Devuelve la nota
     * @return nota del alumno
     */
    
    public int getNota() {
        return nota;
    }

    /**
     * Modifica la nota del alumno
     * @param nota 
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Indica si el alumno esta disponible (50%)
     */
    @Override
    public void disponibilidad() {
        
        int prob=MetodosSueltos.generaNumeroAleatorio(0, 100);
        
        if(prob<50){
            super.setAsistencia(false);
        }else{
            super.setAsistencia(true);
        }
        
    }
    
    /**
     * Muestra la informacion del alumno
     * @return informacion
     */
    public String toString(){
        
        return "Nombre: "+super.getNombre()+" ,sexo: "+super.getSexo()+" , nota: "+nota;
       
    }
    
    
    
    
}
