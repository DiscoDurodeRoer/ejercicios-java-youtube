package ejercicio_poo_ddr_13;


public class Respuesta {
    
    private String respuesta;
    private boolean correcta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return respuesta;
    }
    
    
    
    
}
