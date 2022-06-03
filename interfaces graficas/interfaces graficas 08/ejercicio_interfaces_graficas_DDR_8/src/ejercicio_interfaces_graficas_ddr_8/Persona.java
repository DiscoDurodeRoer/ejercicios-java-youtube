package ejercicio_interfaces_graficas_ddr_8;

public abstract class Persona {
    
    private String DNI;
    private String nombre;

    public Persona() {
    }

    public Persona(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DNI=" + DNI + ", nombre=" + nombre +" ";
    }
    
}
