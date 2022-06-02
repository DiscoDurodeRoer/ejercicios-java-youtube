package ejercicio_sockets_ddr_6;

import es.discoduroderoer.expresiones_regulares.ExpresionesRegulares;
import javax.swing.JComboBox;

public class ErroresFormulario {

    private StringBuilder errores;

    public ErroresFormulario() {
        this.errores = new StringBuilder();
    }

    public boolean hasError() {
        return !this.errores.toString().isEmpty();
    }

    public String getErrores() {
        return errores.toString();
    }

    public void validarNumeroEntero(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero entero\n");
        }
    }

    public void validarNumeroEntero(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroEntero_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNumeroReal(String textoValidar) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(" - ").append(textoValidar).append(" no es un numero real\n");
        }
    }

    public void validarNumeroReal(String textoValidar, String mensajeError) {
        if (!textoValidar.isEmpty() && !ExpresionesRegulares.validaNumeroReal_Exp(textoValidar)) {
            this.errores.append(mensajeError);
        }
    }

    public void validarVacio(String textoValidar) {
        if (textoValidar.isEmpty()) {
            this.errores.append("- El texto no puede estar vacio\n");
        }
    }

    public void validarVacio(String textoValidar, String mensajeError) {
        if (textoValidar.isEmpty()) {
            this.errores.append(mensajeError);
        }
    }

    public void validarOpcionSeleccionadaCMB(JComboBox cmb) {
        if (cmb.getSelectedIndex() == 0) {
            this.errores.append("- Debes una opcion del combo\n");
        }
    }

    public void validarOpcionSeleccionadaCMB(JComboBox cmb, String mensajeError) {
        if (cmb.getSelectedIndex() == 0) {
            this.errores.append(mensajeError);
        }
    }

    public void validarNulo(Object o) {
        if (o == null) {
            this.errores.append("- El objecto es nulo\n");
        }
    }

    public void validarNulo(Object o, String mensajeError) {
        if (o == null) {
            this.errores.append(mensajeError);
        }
    }

}
