package ejercicio_ficheros_ddr_13;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = -1L;

    private String DNI;
    private String Nombre;
    private String telefono;

    public Cliente(String DNI, String Nombre, String telefono) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.telefono = telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "DNI=" + DNI + ", Nombre=" + Nombre + ", telefono=" + telefono;
    }

}
