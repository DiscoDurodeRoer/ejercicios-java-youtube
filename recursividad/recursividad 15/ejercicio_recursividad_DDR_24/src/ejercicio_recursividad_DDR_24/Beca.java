package ejercicio_recursividad_DDR_24;

public class Beca {

    private int mesInicio;
    private int mesFin;
    private int dineroMes;

    public Beca(int mesInicio, int mesFin, int dineroMes) {
        this.mesInicio = mesInicio;
        this.mesFin = mesFin;
        this.dineroMes = dineroMes;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
    }

    public int getMesFin() {
        return mesFin;
    }

    public void setMesFin(int mesFin) {
        this.mesFin = mesFin;
    }

    public int getDineroMes() {
        return dineroMes;
    }

    public void setDineroMes(int dineroMes) {
        this.dineroMes = dineroMes;
    }

    public int precioBeca() {
        return dineroMes * (this.mesFin - this.mesInicio + 1);
    }

    public boolean compatible(Beca b) {
        return this.mesInicio < b.getMesInicio() && this.mesFin < b.getMesInicio()
                || this.mesInicio > b.getMesFin() && this.mesFin > b.getMesFin();
    }

    @Override
    public String toString() {
        return "Beca{" + "mesInicio=" + mesInicio + ", mesFin=" + mesFin + ", dinero al mes= " + dineroMes + ", precioBeca=" + precioBeca() + '}';
    }

}
