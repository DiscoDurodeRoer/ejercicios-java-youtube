package ejercicio_poo_ddr_21;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Fecha implements Comparable<Fecha> {

    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        Date hoy = new Date();
        this.dia = hoy.getDate();
        this.mes = hoy.getMonth() + 1;
        this.anio = hoy.getYear() + 1900;
    }

    public Fecha(Date fecha) throws FechaException {
        if (fecha != null) {
            this.dia = fecha.getDate();
            this.mes = fecha.getMonth() + 1;
            this.anio = fecha.getYear() + 1900;
        } else {
            throw new FechaException("Objeto nulo");
        }
    }

    public Fecha(Calendar fecha) throws FechaException {
        if (fecha != null) {
            this.dia = fecha.get(Calendar.DAY_OF_MONTH);
            this.mes = fecha.get(Calendar.MONTH);
            this.anio = fecha.get(Calendar.YEAR);
        } else {
            throw new FechaException("Objeto nulo");
        }
    }

    public Fecha(LocalDate fecha) throws FechaException {
        if (fecha != null) {
            this.dia = fecha.getDayOfMonth();
            this.mes = fecha.getMonthValue();
            this.anio = fecha.getYear();
        } else {
            throw new FechaException("Objeto nulo");
        }
    }

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

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public long getMilisegundos() {
        Date fecha = this.toDate();
        return fecha.getTime();
    }

    public boolean fechaMayor(Fecha f) {
        return this.compareTo(f) == 1;
    }

    public boolean fechaIgual(Fecha f) {
        return this.compareTo(f) == 0;
    }

    public boolean fechaMenor(Fecha f) {
        return this.compareTo(f) == -1;
    }

    public Date toDate() {
        return new Date(this.getAnio() + 1900, this.getMes() - 1, this.getDia());
    }

    public Calendar toCalendar() {
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.DAY_OF_MONTH, this.getDia());
        fecha.set(Calendar.MONTH, this.getMes() - 1);
        fecha.set(Calendar.YEAR, this.getAnio());
        return fecha;
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(this.getAnio(), this.getMes(), this.getDia());
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

    @Override
    public int compareTo(Fecha fecha) {

        if (fecha.getMilisegundos() == this.getMilisegundos()) {
            return 0;
        } else if (this.getMilisegundos() > fecha.getMilisegundos()) {
            return 1;
        } else {
            return -1;
        }
    }

}
