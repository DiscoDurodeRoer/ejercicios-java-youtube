package ejercicio_poo_ddr_15;

import java.util.Date;
import java.util.logging.Logger;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) throws FechaException {
        validarAnio(anio);
        this.anio = anio;
        validarMes(mes);
        this.mes = mes;
        validarDia(dia, mes, anio);
        this.dia = dia;
    }

    private void validarDia(int dia, int mes, int anio) throws FechaException {

        if (!(dia >= 1 && dia <= numDias(mes, anio))) {
            throw new FechaException("Dia no correcto");
        }

    }

    private void validarMes(int mes) throws FechaException {

        if (!(mes >= 1 && mes <= 12)) {
            throw new FechaException("Mes no correcto");
        }

    }

    private void validarAnio(int anio) throws FechaException {

        if (anio <= 0) {
            throw new FechaException("Año no correcto");
        }

    }

    public int numDias(int mes, int anio) {

        int numDias = 0;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDias = 30;
                break;
            case 2:
                numDias = 28;

                if (esBisiesto(anio)) {
                    numDias++;
                }

                break;
            default:
                numDias = -1;
        }

        return numDias;

    }

    public boolean esBisiesto(int anio) {

        if (anio <= 0) {
            return false;
        }

        return (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));

    }

    @Override
    public String toString() {

        String diaCad = dia + "";
        if (dia < 10) {
            diaCad = "0" + diaCad;
        }

        String mesCad = mes + "";
        if (mes < 10) {
            mesCad = "0" + mesCad;
        }

        return diaCad + "/" + mesCad + "/" + anio;
    }

}
