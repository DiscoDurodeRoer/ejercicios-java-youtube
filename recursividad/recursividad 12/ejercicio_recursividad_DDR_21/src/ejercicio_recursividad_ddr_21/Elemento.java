
package ejercicio_recursividad_ddr_21;

public class Elemento {
 
    private int peso;
    private int beneficio;

    public Elemento(int peso, int beneficio) {
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (this.peso != other.peso) {
            return false;
        }
        if (this.beneficio != other.beneficio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Peso:"+peso+","+" beneficio:"+beneficio;
    }
    
    
}
