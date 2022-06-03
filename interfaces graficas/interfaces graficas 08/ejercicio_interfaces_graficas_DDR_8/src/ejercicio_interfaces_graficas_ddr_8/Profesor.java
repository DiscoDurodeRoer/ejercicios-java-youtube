package ejercicio_interfaces_graficas_ddr_8;

public class Profesor extends Persona {
 
    private double salario;
    private boolean fijo;

    public Profesor() {
    }

    public Profesor(double salario, boolean fijo, String DNI, String nombre) {
        super(DNI, nombre);
        this.salario = salario;
        this.fijo = fijo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isFijo() {
        return fijo;
    }

    public void setFijo(boolean fijo) {
        this.fijo = fijo;
    }
    
    public double calcularSalario(double retencionIRPF, int antiguedad){
        
        return salario - (salario * retencionIRPF/100) + (antiguedad * 50);
        
    }
    
    @Override
    public String toString() {
        return super.toString() + " salario=" + salario + ", fijo=" + fijo;
    }
    
}
