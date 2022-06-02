package ejercicio_sockets_ddr_6;

import java.io.Serializable;

public class Gasolinera implements Serializable{

    private double diesel;
    private double gasolinaPlomo;
    private double dieselOptima;

    public Gasolinera(double diesel, double gasolinaPlomo, double dieselOptima) {
        this.diesel = diesel;
        this.gasolinaPlomo = gasolinaPlomo;
        this.dieselOptima = dieselOptima;
    }

    public double getDiesel() {
        return diesel;
    }

    public void setDiesel(double diesel) {
        this.diesel = diesel;
    }

    public double getGasolinaPlomo() {
        return gasolinaPlomo;
    }

    public void setGasolinaPlomo(double gasolinaPlomo) {
        this.gasolinaPlomo = gasolinaPlomo;
    }

    public double getDieselOptima() {
        return dieselOptima;
    }

    public void setDieselOptima(double dieselOptima) {
        this.dieselOptima = dieselOptima;
    }

}
