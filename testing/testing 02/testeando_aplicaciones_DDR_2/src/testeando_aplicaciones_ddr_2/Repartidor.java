package testeando_aplicaciones_ddr_2;

/**
 * Clase Repartidor, hija de empleado
 * @author DiscoDurodeRoer
 */
public class Repartidor extends Empleado {

    //Atributos
    private String zona;

    //Constructores
    public Repartidor(String zona, String nombre, int edad, double salario) {
        super(nombre, edad, salario);
        this.zona = zona;
    }

    //Metodos
    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return super.toString() + " zona=" + zona;
    }

    /**
     * Si tiene menos de 25 años y la zona es "zona 3",
     * aumentamos el sueldo al empleado
     * @return 
     */
    @Override
    public boolean plus() {

        if (super.getEdad() < 25 && this.zona.equalsIgnoreCase("zona 3")) {
            //Con super. llamo a un metodo de la clase padre
            double nuevoSalario = super.getSalario() + super.PLUS;
            super.setSalario(nuevoSalario);
            System.out.println("Se le añadido el plus, al empleado "+super.getNombre());
            return true;
        }

        return false;
    }

}
